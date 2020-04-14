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

public class CarMethodParkingTest {

    private MethodParking methodParking;
    private Map<String, List<BasePlace>> places;

    @Before
    public void init() {
        methodParking = new CarMethodParking();
        places = new HashMap<>();
    }

    @Test
    public void whenSuccessParking() {
        BaseCar car = new PassengerCar(300, "СО589Е");
        SimplePlace place = new SimplePlace(300);
        place.setUsed(false);
        List<BasePlace> basePlaces = new ArrayList<>();
        basePlaces.add(place);
        places.put("passenger", basePlaces);
        assertTrue(methodParking.park(car, places));
        assertTrue(place.isUsed());
    }

    @Test
    public void whenFailParking() {
        BaseCar car = new PassengerCar(300, "СО589Е");
        SimplePlace place = new SimplePlace(300);
        place.setUsed(true);
        List<BasePlace> basePlaces = new ArrayList<>();
        basePlaces.add(place);
        places.put("passenger", basePlaces);
        assertFalse(methodParking.park(car, places));
    }
}
