package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.RoleParking;

public class TruckRoleParking implements RoleParking {
    public boolean check(BaseCar car) {
        return false;
    }
}
