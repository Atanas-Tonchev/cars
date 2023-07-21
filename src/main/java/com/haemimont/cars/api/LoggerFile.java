package com.haemimont.cars.api;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LoggerFile {

    public static List<String> getLoggApiFile() {
        SingletonApiLoggFile singletonApiLoggFile = SingletonApiLoggFile.getApiLoggFile();
        List<String> listLogs = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(singletonApiLoggFile.loggPath));
            List<String> list = new ArrayList<>();
            String line;
            while((line = reader.readLine())!= null) {
                list.add(line);
            }
            for (int i = list.size()-1; i > 0; i--){
                listLogs.add(list.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (listLogs.size()<=30) {
            return listLogs;
        }else {
            return listLogs.subList(0,30);
        }
    }
    public static List<String> getLoggJarFile() {
        List<String> listLogs = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ApiPathConfiguration.PATH_JAR_LOGGER_FILE));
            List<String> list = new ArrayList<>();
            String line;
            while((line = reader.readLine())!= null) {
                list.add(line);
            }
            for (int i = list.size()-1; i > 0; i--){
                listLogs.add(list.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (listLogs.size()<=30) {
            return listLogs;
        }else {
            return listLogs.subList(0,30);
        }
    }
}
