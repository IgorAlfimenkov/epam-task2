package com.alfimenkov.task2.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Reader {

    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    public static String readTextFile(String filename) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        LOGGER.debug("Try to read text file {}", filename);
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            LOGGER.debug("File reading completed successfully.");
        } catch (Exception e) {
            LOGGER.error("Failing to read file with name {}", filename);
        } finally {
            reader.close();
        }
        return stringBuilder.toString();
    }
}
