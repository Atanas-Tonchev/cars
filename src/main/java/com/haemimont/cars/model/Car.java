package com.haemimont.cars.model;

public class Car {
    Dimensions dimensions;
    EngineInformation engineInformation;
    FuelInformation fuelInformation;
    Identification identification;

    public Car(Dimensions dimensions, EngineInformation engineInformation,
               FuelInformation fuelInformation, Identification identification) {
        this.dimensions = dimensions;
        this.engineInformation = engineInformation;
        this.fuelInformation = fuelInformation;
        this.identification = identification;
    }

    public Car() {

    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Car setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return null;
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

    @Override
    public String toString() {
        return "Car{" +
                "dimensions=" + dimensions +
                ", engineInformation=" + engineInformation +
                ", fuelInformation=" + fuelInformation +
                ", identification=" + identification +
                '}';
    }
}
