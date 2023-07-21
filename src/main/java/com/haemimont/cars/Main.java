package com.haemimont.cars;
import com.haemimont.cars.api.*;
import com.haemimont.cars.tests.IntegrationTestApi;
import com.haemimont.cars.tests.MultiThreadTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        String username = "Atanas1990";
        String pass = "betimoni2215";
        String email = "rrrrrrrsjsf@example.com";
        List<String> userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil req = new ApiObjectUtil(new ApiRegistration(username, pass, email, userRoles),
                new ApiLogin(username, pass),
                new ApiAuthorization());

        MultiThreadTest test = new MultiThreadTest();
        IntegrationTestApi testApi = new IntegrationTestApi();

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
                System.out.println(listLogs);
            }else {
                System.out.println(listLogs.subList(0,30));
            }



        //test.getThreadTestApi(req);
        //test.getThreadTestApiInnerLock(req);

        //System.out.println(new UnitTestApi().getConnectionTest());
        //System.out.println(LoggerFile.getLoggApiFile(LoggerFile.getBufferReaderApi()));


        //File logFile = new File("C:\\Users\\User\\Desktop\\nasko\\logger.log");

    }
}

