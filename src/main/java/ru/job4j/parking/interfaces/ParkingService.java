package ru.job4j.parking.interfaces;

import ru.job4j.car.BaseCar;

public interface ParkingService {
    boolean park(BaseCar car);
    boolean unPark(BaseCar car);
}
