package ru.job4j.parking.impls;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.BaseCar;
import ru.job4j.car.PassengerCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.place.BasePlace;
import ru.job4j.parking.place.SimplePlace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TruckMethodParkingTest {

    private MethodParking methodParking;
    private Map<String, List<BasePlace>> places;

    @Before
    public void init() {
        methodParking = new TruckMethodParking();
        places = new HashMap<>();
    }

    @Test
    public void whenSuccessParkingOnOnePlace() {
        BaseCar car = new PassengerCar(500, "СО589Е");
        SimplePlace place = new SimplePlace(500);
        place.setUsed(false);
        List<BasePlace> basePlaces = new ArrayList<>();
        basePlaces.add(place);
        places.put("truck", basePlaces);
        assertTrue(methodParking.park(car, places));
    }

    @Test
    public void whenSuccessParkingOnSomePlace() {
        BaseCar car = new PassengerCar(500, "СО589Е");
        SimplePlace place1 = new SimplePlace(250);
        SimplePlace place2 = new SimplePlace(250);
        place1.setUsed(false);
        place2.setUsed(false);
        List<BasePlace> basePlaces = new ArrayList<>();
        basePlaces.add(place1);
        basePlaces.add(place2);
        places.put("passenger", basePlaces);
        assertTrue(methodParking.park(car, places));
    }

    @Test
    public void whenPlaceUsedFailParking() {
        BaseCar car = new PassengerCar(500, "СО589Е");
        SimplePlace place = new SimplePlace(500);
        place.setUsed(true);
        place.setCar(car);
        List<BasePlace> basePlaces = new ArrayList<>();
        basePlaces.add(place);
        places.put("truck", basePlaces);
        assertFalse(methodParking.park(car, places));
    }

    @Test
    public void whenSomePlaceUsedFailParking() {
        BaseCar car = new PassengerCar(500, "СО589Е");
        SimplePlace place1 = new SimplePlace(250);
        SimplePlace place2 = new SimplePlace(250);
        place1.setUsed(false);
        place2.setUsed(true);
        List<BasePlace> basePlaces = new ArrayList<>();
        basePlaces.add(place1);
        basePlaces.add(place2);
        places.put("passenger", basePlaces);
        assertFalse(methodParking.park(car, places));
    }
}
