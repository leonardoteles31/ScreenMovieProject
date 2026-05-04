package br.com.leodev.screenmovie.env;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class EnvLoader {
    public static void loadEnv(String filePath) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(filePath));

        for (String key : props.stringPropertyNames()) {
                System.setProperty(key, props.getProperty(key));
        }
    }
}
