package ru.job4j.car;

import java.util.Objects;

public abstract class BaseCar {
    private final double width;
    private final String number;

    public BaseCar(double width, String number) {
        this.width = width;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCar baseCar = (BaseCar) o;
        return Objects.equals(number, baseCar.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public double getWidth() {
        return width;
    }

    public String getNumber() {
        return number;
    }
}
