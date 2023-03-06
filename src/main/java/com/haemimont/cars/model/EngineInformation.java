package com.haemimont.cars.model;

public class EngineInformation {
    private String DriveLine;
    private String EngineType;
    private String Hybrid;
    private String Transmission;
    private int NumberOfForwardGears;
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
    public EngineInformation(String engineType, String transmission, EngineStatistics engineStatistics) {
        this.EngineType = engineType;
        this.Transmission = transmission;
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
