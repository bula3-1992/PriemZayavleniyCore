/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author 003-0823
 */
public class CommonUtils {
    //    private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);

    private final static int BUFSIZE_BIG = 20 * 1024 * 1024;//размер буфера для ZIP-архивов (20Мб), дада... вот так
    private final static int BUFSIZE = 4096;//размер буфера для P7S и XML файлов (4Кб)
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    //Заголовок и окончание zip файла в HEX
    private final static String ZIP_HEADER = "504B03041400";
    private final static String ZIP_SUFFIX = "504B05060000";
    private final static int ZIP_END_BYTES = 16;
    //Заголовок и окончание p7s файла в HEX
    /*private final static String P7S_HEADER = "00003082";
     private final static String P7S_SUFFIX = "0440";
     private final static int P7S_END_BYTES = 64;*/
    //Заголовок и окончание META в HEX
    private static String FILENAME_INFO_HEADER;
    private final static int FILENAME_INFO_HEADER_END_BYTES = 4;
    private final static String FILENAME_INFO_SUFFIX = "646F635F74797065";
    private final static int FILENAME_INFO_END_BEFORE_BYTES = 4;

    public static String loadSQL(String sqlfilename) {
        StringBuilder sb = new StringBuilder();
        sqlfilename += ".sql";
        String str;
        try {
            InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream(sqlfilename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(CommonUtils.class.getName()).log(Level.SEVERE, "Невозможно загрузить sql-файл из ресурсов проекта", ex);
        }
        return sb.toString();
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Делит загадочные blob из базы БПИ, которые для типов сообщений
     * "неформализованный документооборот" всегдя являются архивами с одним
     * файлом, склеенными по определенным правилам, которые известны только
     * самим разработчикам
     *
     * @param body - blob из базы БПИ
     * @return - массив файлов и наименований подготовленный для дальнейшей
     * обработки
     */
    private static List<List<byte[]>> divideBlob(byte[] body) {
        List<List<byte[]>> out = new ArrayList<>();
        List<byte[]> zips = new ArrayList<>();
        String hex = bytesToHex(body);
        int Start = 0;
        int End;
        if (hex.length() / 2 == body.length) {
            while ((Start = hex.indexOf(ZIP_HEADER, Start)) != -1) {
                //находим байтовые границы ZIP-файла
                End = hex.indexOf(ZIP_SUFFIX, Start) + ZIP_SUFFIX.length();
                zips.add(Arrays.copyOfRange(body, Start / 2, (End / 2) + ZIP_END_BYTES));
                Start = End++;
            }
        }
        Start = 0;
        List<byte[]> names = new ArrayList<>();
        for (int i = 0; i < zips.size(); i++) {
            //находим байтовые границы META-данных имени файла
            String header = "file_name" + i;
            FILENAME_INFO_HEADER = bytesToHex(header.getBytes());
            Start = hex.indexOf(FILENAME_INFO_HEADER, Start);
            if (Start == -1) {
                continue;
            }
            Start += FILENAME_INFO_HEADER.length() + FILENAME_INFO_HEADER_END_BYTES;
            End = hex.indexOf(FILENAME_INFO_SUFFIX, Start) - FILENAME_INFO_END_BEFORE_BYTES;
            names.add(Arrays.copyOfRange(body, Start / 2, End / 2));
            Start = End++;
        }
        out.add(zips);
        out.add(names);
        return out;
    }

    /**
     * Ищет файлы в необычном блобе, придуманным разработчиками БПИ видимо just
     * for luls.
     *
     * @param blobField - blob из базы БПИ, имеющий необычный формат.
     * @return - список файлов в PreparedBlob представлении.
     * @throws java.lang.Exception
     */
    public static FilePairFactory getFilesInByteArray(byte[] blobField) throws Exception {
        //Данный алгоритм сработает если в одном ZIP-архиве будет больше одного файла
        //придется дорабатывать, если в архиве больше одного файла
        FilePairFactory out = new FilePairFactory();
        List<List<byte[]>> blobs = divideBlob(blobField);
        List<byte[]> zips = blobs.get(0);
        List<byte[]> names = blobs.get(1);
        //Charset Windows1251 = Charset.forName("CP1251");
        if (zips.size() != names.size()) {
            //возникает в случае других типов посылок, напр. "запрос" или "регпакет"
            Logger.getLogger(CommonUtils.class.getName()).log(Level.SEVERE, "FATAL: Количество найденных zip-архивов в BLOB-е не совпадает с количеством зашифрованных имен файлов");
        }
        int size = zips.size();
        for (int i = 0; i < size; i++) {
            byte[] zip = zips.get(i);
            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zip))) {
                String zipName = new String(names.get(i));
                //Определяем расширение вложенного файла
                if (zipName.substring(zipName.length() - 4, zipName.length()).toLowerCase().equals(".zip")) {
                    zis.getNextEntry();//только 1-ый файл
                    byte[] byteBuff = new byte[BUFSIZE_BIG];
                    int bytesRead;
                    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                        while ((bytesRead = zis.read(byteBuff)) != -1) {
                            baos.write(byteBuff, 0, bytesRead);
                        }
                        //Распаковываем архив, требования COMPRESSION_METHOD=DEFLATED
                        try (ZipInputStream zisArchive = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
                            ZipEntry ze;
                            while ((ze = zisArchive.getNextEntry()) != null) {//все файлы
                                byte[] byteBuffArchive = new byte[BUFSIZE];
                                int bytesReadArchive;
                                try (ByteArrayOutputStream baosArchive = new ByteArrayOutputStream()) {
                                    while ((bytesReadArchive = zisArchive.read(byteBuffArchive)) != -1) {
                                        baosArchive.write(byteBuffArchive, 0, bytesReadArchive);
                                    }
                                    out.putFile(ze.getName(), baosArchive.toByteArray());
                                }
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(CommonUtils.class.getName()).log(Level.SEVERE, "Вложенный ZIP-архив поврежден", ex);
                            throw ex;
                        }
                    }
                }
                if (zipName.substring(zipName.length() - 4, zipName.length()).toLowerCase().equals(".p7s")
                        || zipName.substring(zipName.length() - 4, zipName.length()).toLowerCase().equals(".xml")) {
                    //Пациент имеет расширение P7S или XML
                    zis.getNextEntry();//только 1-ый файл
                    byte[] byteBuff = new byte[BUFSIZE];
                    int bytesRead;
                    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                        while ((bytesRead = zis.read(byteBuff)) != -1) {
                            baos.write(byteBuff, 0, bytesRead);
                        }
                        out.putFile(new String(names.get(i)), baos.toByteArray());
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(CommonUtils.class.getName()).log(Level.SEVERE, "Ошибка чтения файлов из зашифрованного BLOB с файлами", ex);
                throw ex;
            }
        }
        return out;
    }
}
