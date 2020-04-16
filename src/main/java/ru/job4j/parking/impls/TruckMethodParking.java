package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.place.BasePlace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class TruckMethodParking implements MethodParking {
    @Override
    public boolean park(BaseCar car, Map<String, List<BasePlace>> places) {
        boolean result = false;
        List<BasePlace> placesList = places.get("truck");
        result = truckPark(car, placesList, true, place -> !place.isUsed());
        if (!result) {
            placesList = places.get("passenger");
            result = passengerPark(car, placesList, true, place -> !place.isUsed());
        }
        return result;
    }

    @Override
    public boolean unPark(BaseCar car, Map<String, List<BasePlace>> places) {
        boolean result = false;
        List<BasePlace> placesList = places.get("truck");
        result = truckPark(car, placesList, false, place -> place.isUsed() && place.getCar().equals(car));
        if (!result) {
            placesList = places.get("passenger");
            result = passengerPark(car, placesList, false, place -> place.isUsed() && place.getCar().equals(car));
        }
        return result;
    }

    private boolean truckPark(BaseCar car, List<BasePlace> placesList, boolean park, Predicate<BasePlace> predicate) {
        boolean result = false;
        if (placesList != null && !placesList.isEmpty()) {
            for (BasePlace place : placesList) {
                if (predicate.test(place)) {
                    place.setCar(park ? car : null);
                    place.setUsed(park);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private boolean passengerPark(BaseCar car, List<BasePlace> placesList, boolean park, Predicate<BasePlace> predicate) {
        boolean result = false;
        double wight = 0;
        List<BasePlace> basePlaces = new ArrayList<>();
        if (placesList != null && !placesList.isEmpty()) {
            for (BasePlace place : placesList) {
                if (predicate.test(place)) {
                    wight += place.getWidth();
                    basePlaces.add(place);
                    if (wight >= car.getWidth()) {
                        for (BasePlace placeUsed : placesList) {
                            placeUsed.setCar(park ? car : null);
                            placeUsed.setUsed(park);
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
