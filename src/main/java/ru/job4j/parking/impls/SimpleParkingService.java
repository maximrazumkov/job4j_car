package ru.job4j.parking.impls;

import ru.job4j.car.BaseCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.interfaces.ParkingService;
import ru.job4j.parking.interfaces.RoleParking;

import java.util.Map;

public class SimpleParkingService implements ParkingService {

    private final Map<RoleParking, MethodParking> regulation;

    public SimpleParkingService(Map<RoleParking, MethodParking> regulation) {
        this.regulation = regulation;
    }

    public boolean park(BaseCar car) {
        return false;
    }

    public boolean unPark(BaseCar car) {
        return false;
    }
}
