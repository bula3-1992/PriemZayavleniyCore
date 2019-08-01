package utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author 003-0818
 */
public class FileUtils{

    @Deprecated
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    @Deprecated
    private static void copyFolder(File src, File dest)
            throws IOException {

        if (src.isDirectory()) {

            if (!dest.exists()) {
                dest.mkdirs();

            }

            String files[] = src.list();

            for (String file : files) {

                File srcFile = new File(src, file);
                File destFile = new File(dest, file);

                copyFolder(srcFile, destFile);
            }

        } else {
            OutputStream out;
            try (InputStream in = new FileInputStream(src)) {
                out = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            out.close();

        }
    }

    public static List<File> findDirectories(String startPath) throws Exception {

        List<File> files = new ArrayList<>();

        if (startPath == null) {
            throw new Exception("Ошибка: Не задан входной каталог программы.");
        }


        File topDirectory = new File(startPath);
        if (!topDirectory.exists()) {
            throw new Exception("Ошибка: Указанный путь \"<b>" + topDirectory.getAbsolutePath() + "</b>\" не существует. Проверьте правильность входного каталога в настройках.");
        }

        for (File file : topDirectory.listFiles()) {
            if (file != null && file.isDirectory()) {
                files.add(file);
            }
        }

        return files;
    }

    @Deprecated
    public static List<File> findXMLFile(String startPath) throws Exception {
        return find(startPath, "^(?!.*\\/)(\\w|\\s|-|[А-Яа-я])+\\.(XML|xml)$", FILES);
    }

    @Deprecated
    public static List<File> findP7SFile(String startPath) throws Exception {
        return find(startPath, "^(?!.*\\/)(\\w|\\s|-|[А-Яа-я])+\\.(p7s)$", FILES);
    }

    @Deprecated
    private static List<File> find(String startPath, String mask, int ObjectType) throws Exception {
        if (startPath == null || mask == null) {
            throw new Exception("Ошибка поиска файла.");
        }
        File topDirectory = new File(startPath);
        if (!topDirectory.exists()) {
            throw new Exception("Указанный путь \"" + topDirectory.getAbsolutePath() + "\" не существует.");
        }
        if (!mask.equals("")) {
            p = Pattern.compile(mask, Pattern.CASE_INSENSITIVE);
        }
        filesNumber = 0;
        directoriesNumber = 0;
        totalLength = 0;
        List<File> res = new ArrayList(100);
        search(topDirectory, res, ObjectType);
        p = null;
        return res;
    }

    @Deprecated
    private static void search(File topDirectory, List res, int objectType) {
        File[] list = topDirectory.listFiles();

        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory()) {
                if (objectType != FILES && accept(list[i].getName())) {
                    directoriesNumber++;
                    res.add(list[i]);
                }
                search(list[i], res, objectType);
            } else {
                if (objectType != DIRECTORIES && accept(list[i].getName())) {
                    filesNumber++;
                    totalLength += list[i].length();
                    res.add(list[i]);
                }
            }
        }
    }

    @Deprecated
    private static boolean accept(String name) {

        if (p == null) {
            return true;
        }
        m = p.matcher(name);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }

    }

    private static Pattern p = null;
    private static Matcher m = null;
    private static long totalLength = 0;
    private static long filesNumber = 0;
    private static long directoriesNumber = 0;

    private static final int FILES = 0;
    private static final int DIRECTORIES = 1;
    private static final int ALL = 2;

}