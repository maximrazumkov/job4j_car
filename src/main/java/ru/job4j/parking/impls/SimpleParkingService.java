package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.interfaces.ParkingService;
import ru.job4j.parking.interfaces.RoleParking;
import ru.job4j.parking.place.BasePlace;

import java.util.List;
import java.util.Map;

public class SimpleParkingService implements ParkingService {

    private final Map<RoleParking, MethodParking> regulations;
    private final Map<String, List<BasePlace>> places;

    public SimpleParkingService(Map<RoleParking, MethodParking> regulations, Map<String, List<BasePlace>> places) {
        this.regulations = regulations;
        this.places = places;
    }

    public boolean park(BaseCar car) {
        boolean result = false;
        for (Map.Entry<RoleParking, MethodParking> regulation : regulations.entrySet()) {
            RoleParking roleParking = regulation.getKey();
            if (roleParking.check(car)) {
                MethodParking methodParking = regulation.getValue();
                result = methodParking.park(car, places);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }

    public boolean unPark(BaseCar car) {
        boolean result = false;
        for (Map.Entry<RoleParking, MethodParking> regulation : regulations.entrySet()) {
            RoleParking roleParking = regulation.getKey();
            if (roleParking.check(car)) {
                MethodParking methodParking = regulation.getValue();
                result = methodParking.unPark(car, places);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }
}
