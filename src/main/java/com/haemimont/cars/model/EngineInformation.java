package com.haemimont.cars.model;

public class EngineInformation {
    private final String DriveLine;
    private final String EngineType;
    private final String Hybrid;
    private final String Transmission;
    private final int NumberOfForwardGears;
    EngineStatistics engineStatistics;

    public EngineInformation(String driveLine, String engineType, String hybrid,
                             String transmission, int numberOfForwardGears,
                             EngineStatistics engineStatistics) {
        DriveLine = driveLine;
        EngineType = engineType;
        Hybrid = hybrid;
        Transmission = transmission;
        NumberOfForwardGears = numberOfForwardGears;
        this.engineStatistics = engineStatistics;
    }

    public EngineStatistics getEngineStatistics() {
        return engineStatistics;
    }

    public String getDriveLine() {
        return DriveLine;
    }

    public String getEngineType() {
        return EngineType;
    }

    public String getHybrid() {
        return Hybrid;
    }

    public String getTransmission() {
        return Transmission;
    }

    public int getNumberOfForwardGears() {
        return NumberOfForwardGears;
    }

    @Override
    public String toString() {
        return "Model.EngineInformation{" +
                "DriveLine='" + DriveLine + '\'' +
                ", EngineType='" + EngineType + '\'' +
                ", Hybrid='" + Hybrid + '\'' +
                ", Transmission='" + Transmission + '\'' +
                ", NumberOfForwardGears=" + NumberOfForwardGears +
                ", engineStatistics=" + engineStatistics +
                '}';
    }
}
