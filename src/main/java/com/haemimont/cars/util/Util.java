package com.haemimont.cars.util;

import com.haemimont.cars.model.*;
import com.haemimont.cars.storage.Storage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Util {


    public static Storage<Object, Car> loadCarStorage(String csvFileName) {
        Storage<Object, Car> carStorage = new Storage<>();

        try {
            String[] record = null;
            int lineNumber = 0;

            CSVReader reader = new CSVReader(new FileReader(csvFileName));
            while ((record = reader.readNext()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }

                Car car = new Car();

                car.setDimensions(new Dimensions(Integer.parseInt(record[0]), Integer.parseInt(record[1]),
                        Integer.parseInt(record[2])));

                car.setEngineInformation(new EngineInformation(record[3], record[4], record[5],
                        record[7], Integer.parseInt(record[6]),
                        new EngineStatistics(Integer.parseInt(record[16]),
                                Integer.parseInt(record[17]))));

                car.setIdentification(new Identification(record[11], record[12], record[13],
                        record[14], Integer.parseInt(record[15])));

                car.setFuelInformation(new FuelInformation(record[9], Integer.parseInt(record[8]),
                        Integer.parseInt(record[10])));

                carStorage.put(lineNumber, car);

                lineNumber++;

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carStorage;
    }
}
