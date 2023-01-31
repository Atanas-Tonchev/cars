package com.haemimont.cars.model;

public class Car {
    Dimensions dimensions;
    EngineInformation engineInformation;
    FuelInformation fuelInformation;
    Identification identification;
    EngineStatistics engineStatistics;

    public Car(Dimensions dimensions, EngineInformation engineInformation,
               FuelInformation fuelInformation, Identification identification,
               EngineStatistics engineStatistics) {
        this.dimensions = dimensions;
        this.engineInformation = engineInformation;
        this.fuelInformation = fuelInformation;
        this.identification = identification;
        this.engineStatistics = engineStatistics;
    }
    public Car(){

    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public EngineInformation getEngineInformation() {
        return engineInformation;
    }

    public void setEngineInformation(EngineInformation engineInformation) {
        this.engineInformation = engineInformation;
    }

    public FuelInformation getFuelInformation() {
        return fuelInformation;
    }

    public void setFuelInformation(FuelInformation fuelInformation) {
        this.fuelInformation = fuelInformation;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public EngineStatistics getEngineStatistics() {
        return engineStatistics;
    }

    public void setEngineStatistics(EngineStatistics engineStatistics) {
        this.engineStatistics = engineStatistics;
    }
}
