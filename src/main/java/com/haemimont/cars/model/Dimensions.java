package com.haemimont.cars.model;

public class Dimensions {
    private final int Height;
    private final int Length;
    private final int Width;

    public Dimensions(int height, int length, int width) {
        this.Height = height;
        this.Length = length;
        this.Width = width;
    }
    public int getHeight() {
        return Height;
    }

    public int getLength() {
        return Length;
    }

    public int getWidth() {
        return Width;
    }


    @Override
    public String toString() {
        return "Model.Dimensions{" +
                "Height=" + Height +
                ", Length=" + Length +
                ", Width=" + Width +
                '}';
    }
}
