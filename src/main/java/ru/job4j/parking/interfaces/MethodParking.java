package ru.job4j.parking.interfaces;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.place.BasePlace;

import java.util.List;
import java.util.Map;

public interface MethodParking {
    boolean park(BaseCar car, Map<String, List<BasePlace>> places);
    boolean unPark(BaseCar car, Map<String, List<BasePlace>> places);
}
