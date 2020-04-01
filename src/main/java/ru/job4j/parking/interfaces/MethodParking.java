package ru.job4j.parking.interfaces;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.place.BasePlace;

import java.util.List;

public interface MethodParking {
    boolean run(BaseCar car, List<BasePlace> places);
}
