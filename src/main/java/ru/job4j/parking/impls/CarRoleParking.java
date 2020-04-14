package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.RoleParking;

public class CarRoleParking implements RoleParking {
    private final double width;

    public CarRoleParking(double width) {
        this.width = width;
    }

    public boolean check(BaseCar car) {
        return car.getWidth() <= width;
    }
}
