package ru.job4j.parking.place;

public abstract class Place {
    private final double width;
    private boolean isUsed;

    public Place(double width) {
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
