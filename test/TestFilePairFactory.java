
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import utils.CommonUtils;
import utils.FilePair;
import utils.FilePairFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 003-0823
 */
public class TestFilePairFactory {

    private final static int BUFSIZE_BIG = 20 * 1024 * 1024;
    private final static int BUFSIZE = 4096;

    public static void main(String[] args) {
        FilePairFactory filePairFactory = new FilePairFactory();
        try (ZipInputStream zisArchive = new ZipInputStream(new FileInputStream(new File("arch.zip")))) {
            ZipEntry ze;
            while ((ze = zisArchive.getNextEntry()) != null) {//все файлы
                byte[] byteBuffArchive = new byte[BUFSIZE];
                int bytesReadArchive;
                try (ByteArrayOutputStream baosArchive = new ByteArrayOutputStream()) {
                    while ((bytesReadArchive = zisArchive.read(byteBuffArchive)) != -1) {
                        baosArchive.write(byteBuffArchive, 0, bytesReadArchive);
                    }
                    filePairFactory.putFile(ze.getName(), baosArchive.toByteArray());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonUtils.class.getName()).log(Level.SEVERE, "Вложенный ZIP-архив поврежден", ex);
        }
        for (FilePair filePair : filePairFactory.getFilePairs()) {
            String xmlName = filePair.getXmlName();
            String p7sName = filePair.getP7sName();
            System.out.println(xmlName + " " + p7sName);
        }
    }
}
