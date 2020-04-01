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

public class TruckMethodParkingTest {

    private MethodParking methodParking;
    private List<BasePlace> places;

    @Before
    public void init() {
        methodParking = new TruckMethodParking();
        places = new ArrayList<>();
    }

    @Test
    public void whenSuccessParkingOnOnePlace() {
        BaseCar car = new PassengerCar(500);
        SimplePlace place = new SimplePlace(500);
        place.setUsed(false);
        places.add(place);
        assertTrue(methodParking.run(car, places));
    }

    @Test
    public void whenSuccessParkingOnSomePlace() {
        BaseCar car = new PassengerCar(500);
        SimplePlace place1 = new SimplePlace(250);
        SimplePlace place2 = new SimplePlace(250);
        place1.setUsed(false);
        place2.setUsed(false);
        places.add(place1);
        places.add(place2);
        assertTrue(methodParking.run(car, places));
    }

    @Test
    public void whenPlaceUsedFailParking() {
        BaseCar car = new PassengerCar(500);
        SimplePlace place = new SimplePlace(500);
        place.setUsed(true);
        assertFalse(methodParking.run(car, places));
    }

    @Test
    public void whenSomePlaceUsedFailParking() {
        BaseCar car = new PassengerCar(500);
        SimplePlace place1 = new SimplePlace(250);
        SimplePlace place2 = new SimplePlace(250);
        place1.setUsed(false);
        place2.setUsed(true);
        places.add(place1);
        places.add(place2);
        assertFalse(methodParking.run(car, places));
    }
}
