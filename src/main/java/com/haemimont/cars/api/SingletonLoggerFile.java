package com.haemimont.cars.api;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingletonLoggerFile {
    private static volatile SingletonLoggerFile INSTANCE;

    public static SingletonLoggerFile getINSTANCE(){
        if(INSTANCE == null){
            synchronized(SingletonLoggerFile.class){
                //double-checking Singleton instance
                if(INSTANCE == null){
                    INSTANCE = new SingletonLoggerFile();
                }
            }
        }
        return INSTANCE;
    }

    private SingletonLoggerFile() {
    }

    public static List<String> getLoggFile(String loggPath) {
        List<String> listLogs = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(loggPath));
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
