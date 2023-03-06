package com.haemimont.cars.model;

public class FuelInformation {
    private final String FuelType;
    private int CityMpg;
    private int HighwayMpg;

    public FuelInformation(String fuelType, int cityMpg, int highwayMpg) {
        FuelType = fuelType;
        CityMpg = cityMpg;
        HighwayMpg = highwayMpg;
    }
    public FuelInformation(String fuelType) {
        FuelType = fuelType;
    }

    public String getFuelType() {
        return FuelType;
    }

    public int getCityMpg() {
        return CityMpg;
    }

    public int getHighwayMpg() {
        return HighwayMpg;
    }

    @Override
    public String toString() {
        return "Model.FuelInformation{" +
                "FuelType='" + FuelType + '\'' +
                ", CityMpg=" + CityMpg +
                ", HighwayMpg=" + HighwayMpg +
                '}';
    }
}
