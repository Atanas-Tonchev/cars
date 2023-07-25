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
        List<String> listReverse = new ArrayList<>();
        String[] commands = {"java", "-jar", "cars.jar"};
        ProcessBuilder pb = new ProcessBuilder(commands);
        File selectedFile = new File(ApiPathConfiguration.PATH_JAR_FILE);
        pb.redirectError(new File(Paths.get(ApiPathConfiguration.PATH_JAR_ERROR_FILE).toUri()));
        pb.directory(selectedFile.getAbsoluteFile());
        try {
            final Process process = pb.start();

            final int exitStatus = process.waitFor();

            if (exitStatus == 0) {
                listReverse = LoggerFile.getLoggJarFile(ApiPathConfiguration.PATH_JAR_LOGGER_FILE);
            } else {
                listReverse = LoggerFile.getLoggJarFile(ApiPathConfiguration.PATH_JAR_ERROR_FILE);
            }

        } catch (InterruptedException | IOException ex) {
            logger.error("InterruptedException: " + ex.getMessage());
        }

        return listReverse;
    }
}

