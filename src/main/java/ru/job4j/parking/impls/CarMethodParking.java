package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.place.BasePlace;

import java.util.List;
import java.util.Map;

public class CarMethodParking implements MethodParking {
    @Override
    public boolean park(BaseCar car, Map<String, List<BasePlace>> places) {
        boolean result = false;
        List<BasePlace> placesList = places.get("passenger");
        for (BasePlace place : placesList) {
            if (!place.isUsed()) {
                place.setCar(car);
                place.setUsed(true);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean unPark(BaseCar car, Map<String, List<BasePlace>> places) {
        boolean result = false;
        List<BasePlace> placesList = places.get("passenger");
        for (BasePlace place : placesList) {
            if (!place.isUsed() && car.equals(place.getCar())) {
                place.setCar(null);
                place.setUsed(false);
                result = true;
                break;
            }
        }
        return result;
    }
}
