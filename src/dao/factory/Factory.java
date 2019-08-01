/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 003-0823
 */
public class Factory {

    private EntityManagerFactory BpiEmf = null;
    private EntityManagerFactory PzFilesEmf = null;
    private static Factory instance = null;
    private static Properties properties = null;

    private static synchronized Properties getProperties() {
        //Открываем файл настроек подключения к БД
        if (properties == null) {
            properties = new Properties();
            String propertyHome = System.getenv("CATALINA_HOME");
            try (FileInputStream fis = new FileInputStream(propertyHome + "\\pzSettings.properties")) {
                properties.load(fis);
            } catch (IOException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return properties;
    }

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public EntityManagerFactory getBpiEmf() {
        if (BpiEmf == null) {
            Map emProperties = new HashMap();
            properties = getProperties();
            emProperties.put("javax.persistence.jdbc.url", "jdbc:firebirdsql:" + properties.getProperty("bpi_db") + "?encoding=UTF8");

            BpiEmf = Persistence.createEntityManagerFactory("BpiPU", emProperties);
        }
        return BpiEmf;
    }

    public EntityManagerFactory getPzFilesEmf() {
        if (PzFilesEmf == null) {
            Map emProperties = new HashMap();
            properties = getProperties();
            emProperties.put("javax.persistence.jdbc.url", "jdbc:postgresql://" + properties.getProperty("pzfiles_db"));
            emProperties.put("javax.persistence.jdbc.user", properties.getProperty("pzfiles_user"));
            emProperties.put("javax.persistence.jdbc.password", properties.getProperty("pzfiles_pass"));
            PzFilesEmf = Persistence.createEntityManagerFactory("PzFilesPU", emProperties);
        }
        return PzFilesEmf;
    }
}
