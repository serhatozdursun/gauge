package com.hepsiburada.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    Properties prop = new Properties();

    public Configuration() {
        setProp();
    }

    public void setProp() {
        String path = System.getProperty("user.dir") + "\\env\\default\\user.properties";
        try {
            InputStream input = new FileInputStream(path);
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String key) {

        return prop.getProperty(key);
    }
}
