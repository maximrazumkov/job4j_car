package ru.job4j.parking.impls;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.BaseCar;
import ru.job4j.car.PassengerCar;
import ru.job4j.parking.interfaces.RoleParking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarRoleParkingTest {
    private RoleParking roleParking;

    @Before
    public void init() {
        roleParking = new CarRoleParking();
    }

    @Test
    public void whenOkRole() {
        BaseCar car = new PassengerCar(300);
        assertTrue(roleParking.check(car));
    }

    @Test
    public void whenFailRole() {
        BaseCar car = new PassengerCar(300);
        assertFalse(roleParking.check(car));
    }
}
