package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.place.BasePlace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TruckMethodParking implements MethodParking {
    @Override
    public boolean park(BaseCar car, Map<String, List<BasePlace>> places) {
        boolean result = false;
        List<BasePlace> placesList = places.get("truck");
        if (placesList != null && !placesList.isEmpty()) {
            for (BasePlace place : placesList) {
                if (!place.isUsed()) {
                    place.setCar(car);
                    place.setUsed(true);
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            placesList = places.get("passenger");
            double wight = 0;
            List<BasePlace> basePlaces = new ArrayList<>();
            for (BasePlace place : placesList) {
                if (!place.isUsed()) {
                    wight += place.getWidth();
                    basePlaces.add(place);
                    if (wight >= car.getWidth()) {
                        for (BasePlace placeUsed : placesList) {
                            placeUsed.setCar(car);
                            placeUsed.setUsed(true);
                            result = true;
                            break;
                        }
                        break;
                    }
                } else {
                    basePlaces.clear();
                    wight = 0;
                }
            }
        }
        return result;
    }

    @Override
    public boolean unPark(BaseCar car, Map<String, List<BasePlace>> places) {
        boolean result = false;
        List<BasePlace> placesList = places.get("truck");
        if (placesList != null && !placesList.isEmpty()) {
            for (BasePlace place : placesList) {
                if (!place.isUsed() && car.equals(place.getCar())) {
                    place.setCar(null);
                    place.setUsed(false);
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            placesList = places.get("passenger");
            double wight = 0;
            List<BasePlace> basePlaces = new ArrayList<>();
            for (BasePlace place : placesList) {
                if (!place.isUsed() && car.equals(place.getCar())) {
                    wight += place.getWidth();
                    basePlaces.add(place);
                    if (wight >= car.getWidth()) {
                        for (BasePlace placeUsed : placesList) {
                            placeUsed.setCar(null);
                            placeUsed.setUsed(false);
                            result = true;
                            break;
                        }
                        break;
                    }
                } else {
                    basePlaces.clear();
                    wight = 0;
                }
            }
        }
        return result;
    }
}
