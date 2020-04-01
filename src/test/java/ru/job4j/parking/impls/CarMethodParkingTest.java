package ru.job4j.parking.impls;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.BaseCar;
import ru.job4j.car.PassengerCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.place.BasePlace;
import ru.job4j.parking.place.SimplePlace;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarMethodParkingTest {

    private MethodParking methodParking;
    private List<BasePlace> places;

    @Before
    public void init() {
        methodParking = new CarMethodParking();
        places = new ArrayList<>();
    }

    @Test
    public void whenSuccessParking() {
        BaseCar car = new PassengerCar(300);
        SimplePlace place = new SimplePlace(300);
        place.setUsed(false);
        places.add(place);
        assertTrue(methodParking.run(car, places));
        assertTrue(place.isUsed());
    }

    @Test
    public void whenFailParking() {
        BaseCar car = new PassengerCar(300);
        SimplePlace place = new SimplePlace(300);
        place.setUsed(true);
        places.add(place);
        assertFalse(place.isUsed());
        assertFalse(methodParking.run(car, places));
    }
}
