package com.haemimont.cars.api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class JarExecutor {
    private static final Logger logger = LogManager.getLogger(JarExecutor.class);

    public static List<String> startExtJarProgram() {
        //create new list for reverse the data from result list
        List<String> listReverse = new ArrayList<>();
        //declaration commands for jar executor
        String[] commands = {"java", "-jar", "cars.jar"};
        //create process builder with the commands
        ProcessBuilder pb = new ProcessBuilder(commands);
        //chose a path of .jar file
        File selectedFile = new File(ApiPathConfiguration.PATH_JAR_FILE);
        //redirect error to error.txt
        pb.redirectError(new File(Paths.get(ApiPathConfiguration.PATH_JAR_ERROR_FILE).toUri()));
        //get .jar file
        pb.directory(selectedFile.getAbsoluteFile());
        try {
            //create process and start process builder
            final Process process = pb.start();
            //create exit status
            final int exitStatus = process.waitFor();

            if (exitStatus == 0) {
                //get data from logger file
                listReverse = LoggerFile.getLoggJarFile(ApiPathConfiguration.PATH_JAR_LOGGER_FILE);
            } else {
                //get data from error file
                listReverse = LoggerFile.getLoggJarFile(ApiPathConfiguration.PATH_JAR_ERROR_FILE);
            }

        } catch (InterruptedException | IOException ex) {
            logger.error("InterruptedException: " + ex.getMessage());
        }
        //return data after check status
        return listReverse;
    }
}

