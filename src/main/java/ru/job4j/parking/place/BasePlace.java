package ru.job4j.parking.place;

import ru.job4j.car.BaseCar;

public abstract class BasePlace {
    private final double width;
    private BaseCar car;
    private boolean isUsed;

    public BasePlace(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public BaseCar getCar() {
        return car;
    }

    public void setCar(BaseCar car) {
        this.car = car;
    }
}
