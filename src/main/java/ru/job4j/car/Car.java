package ru.job4j.car;

import ru.job4j.parking.BaseParking;

public interface Car {
    boolean park(BaseParking parking);
    boolean unPark(BaseParking parking);
}
