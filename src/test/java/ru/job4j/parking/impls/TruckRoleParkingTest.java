package ru.job4j.parking.impls;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.BaseCar;
import ru.job4j.car.TruckCar;
import ru.job4j.parking.interfaces.RoleParking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TruckRoleParkingTest {

    private RoleParking roleParking;

    @Before
    public void init() {
        roleParking = new CarRoleParking(500);
    }

    @Test
    public void whenOkRole() {
        BaseCar car = new TruckCar(500, "СО589Е");
        assertTrue(roleParking.check(car));
    }

    @Test
    public void whenFailRole() {
        BaseCar car = new TruckCar(550, "СО589Е");
        assertFalse(roleParking.check(car));
    }
}
