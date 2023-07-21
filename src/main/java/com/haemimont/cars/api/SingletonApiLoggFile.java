package com.haemimont.cars.api;

public class SingletonApiLoggFile {
    private static volatile SingletonApiLoggFile apiLoggFile;
    public String loggPath;

    private SingletonApiLoggFile(String loggPath) {
        this.loggPath = loggPath;
    }

    public static SingletonApiLoggFile getApiLoggFile(){
        if(apiLoggFile == null){
            synchronized(SingletonApiLoggFile.class){
                //double-checking SingletonApiLoggFile apiLoggFile
                if(apiLoggFile == null){
                    apiLoggFile = new SingletonApiLoggFile("logger.log");
                }
            }
        }
        return apiLoggFile;
    }
}
