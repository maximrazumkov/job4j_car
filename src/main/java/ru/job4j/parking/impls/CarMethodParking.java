package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.place.BasePlace;

import java.util.List;

public class CarMethodParking implements MethodParking {
    public boolean run(BaseCar car, List<BasePlace> places) {
        return false;
    }
}
