package com.haemimont.cars.api;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoggerFile {

    public static List<String> getLoggApiFile() {
        //call singleton
        SingletonApiLoggFile singletonApiLoggFile = SingletonApiLoggFile.getApiLoggFile();
        //create new list for reverse the data from result list
        List<String> listReverse = new ArrayList<>();
        //try with resources to auto close FileReader and BufferedReader
        try (FileReader fr = new FileReader(singletonApiLoggFile.loggPath);
             BufferedReader reader = new BufferedReader(fr)) {
            //create list to keep data from logg file
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                //line by line add in to list
                list.add(line);
            }
            for (int i = list.size() - 1; i > 0; i--) {
                //reverse list and add to listReverse
                listReverse.add(list.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return the last 200 lines in logg file
        return listReverse.subList(listReverse.size() - 200, listReverse.size());
    }

    public static List<String> getLoggJarFile() {
        //create new list for reverse the data from result list
        List<String> listReverse = new ArrayList<>();
        //try with resources to auto close FileReader and BufferedReader
        try (FileReader fr = new FileReader(ApiPathConfiguration.PATH_JAR_LOGGER_FILE);
             BufferedReader reader = new BufferedReader(fr)) {
            //create list to keep data from logg file
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                //line by line add in to list
                list.add(line);
            }
            for (int i = list.size() - 1; i > 0; i--) {
                //reverse list and add to listReverse
                listReverse.add(list.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return the last 200 lines in logg file
        return listReverse.subList(listReverse.size() - 200, listReverse.size());
    }
}
