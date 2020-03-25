package ru.job4j.parking;

import ru.job4j.car.Car;

public interface ParkingService {
    boolean park(Car car);
    boolean unPark(Car car);
}
