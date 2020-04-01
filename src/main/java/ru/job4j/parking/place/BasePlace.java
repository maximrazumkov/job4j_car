package ru.job4j.parking.place;

public abstract class BasePlace {
    private final double width;
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
}
