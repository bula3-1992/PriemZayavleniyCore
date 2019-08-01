/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 003-0823
 */
public class FilePairFactory {

    private final Map<String, String> xmlNames;
    private final Map<String, String> p7sNames;
    private final Map<String, byte[]> contents;

    public FilePairFactory() {
        xmlNames = new HashMap<>();
        p7sNames = new HashMap<>();
        contents = new HashMap<>();
    }

    public void putFile(String name, byte[] content) {
        int end = name.indexOf('.');
        String key = name.substring(0, end);
        int ext = name.lastIndexOf('.');
        String extension = name.substring(ext);
        if (extension.toUpperCase().equals(".XML")) {
            xmlNames.put(key, name);
        }
        if (extension.toUpperCase().equals(".P7S")) {
            p7sNames.put(key, name);
        }
        contents.put(name, content);
    }

    public List<FilePair> getFilePairs() {
        //Возвращает список всех XML файлов, а также P7S файлов к ним, если такой имеются, иначе null
        List<FilePair> out = new ArrayList<>();
        for (String key : xmlNames.keySet()) {
            FilePair fp = new FilePair();
            String xmlName = xmlNames.get(key);
            byte[] xml = contents.get(xmlName);
            fp.setXML(xmlName, xml);
            String p7sName = p7sNames.get(key);
            byte[] p7s = contents.get(p7sName);
            fp.setP7S(p7sName, p7s);
            out.add(fp);
        }
        return out;
    }
}
