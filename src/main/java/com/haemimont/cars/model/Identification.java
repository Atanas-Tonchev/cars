package com.haemimont.cars.model;

public class Identification {
    private final String Classification;
    private final String ID;
    private final String Make;
    private final String ModelYear;
    private final int Year;

    public Identification(String classification, String ID, String make, String modelYear, int year) {
        Classification = classification;
        this.ID = ID;
        Make = make;
        ModelYear = modelYear;
        Year = year;
    }

    public String getClassification() {
        return Classification;
    }

    public String getID() {
        return ID;
    }

    public String getMake() {
        return Make;
    }

    public String getModelYear() {
        return ModelYear;
    }

    public int getYear() {
        return Year;
    }

    @Override
    public String toString() {
        return "Model.Identification{" +
                "Classification='" + Classification + '\'' +
                ", ID='" + ID + '\'' +
                ", Make='" + Make + '\'' +
                ", ModelYear='" + ModelYear + '\'' +
                ", Year=" + Year +
                '}';
    }
}
