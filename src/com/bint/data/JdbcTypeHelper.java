package com.bint.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by bint on 2017/12/10.
 */
public class JdbcTypeHelper {

    private static Properties prop = new Properties();

    static {

        try {
            prop.load(new FileInputStream("src/jdbc-type.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getJdbcType(String typeStr){
        return prop.getProperty(typeStr);
    }


    public static String getMySQLJdbcType(String typeStr){
        return prop.getProperty("mysql." + typeStr);
    }
}
