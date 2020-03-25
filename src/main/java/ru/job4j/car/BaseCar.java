package ru.job4j.car;

public abstract class BaseCar implements Car {
    private final double width;

    public BaseCar(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
