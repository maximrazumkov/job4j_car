package ru.job4j.parking;

import ru.job4j.car.BaseCar;

public interface Parking {
    boolean openParkingSession(BaseCar car);
    boolean closeParkingSession(BaseCar car);
}
