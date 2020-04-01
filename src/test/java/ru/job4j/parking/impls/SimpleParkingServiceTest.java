package ru.job4j.parking.impls;


import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.BaseCar;
import ru.job4j.car.PassengerCar;
import ru.job4j.car.TruckCar;
import ru.job4j.parking.interfaces.MethodParking;
import ru.job4j.parking.interfaces.ParkingService;
import ru.job4j.parking.interfaces.RoleParking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleParkingServiceTest {

    private Map<RoleParking, MethodParking> regulation;
    private ParkingService parkingService;

    @Before
    public void init() {
        regulation = new HashMap<>();
        parkingService = new SimpleParkingService(regulation);
    }

    @Test
    public void whenSuccessPassengerParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new PassengerCar(300);
        when(carRoleParking.check(baseCar)).thenReturn(true);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(true);
        assertTrue(parkingService.park(baseCar));
    }

    @Test
    public void whenNotRolePassengerParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new PassengerCar(300);
        when(carRoleParking.check(baseCar)).thenReturn(false);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(true);
        assertFalse(parkingService.park(baseCar));
    }

    @Test
    public void whenBadRunMethodPassengerParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new PassengerCar(300);
        when(carRoleParking.check(baseCar)).thenReturn(true);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(false);
        assertFalse(parkingService.park(baseCar));
    }

    @Test
    public void whenSuccessUnParkPassengerParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new PassengerCar(300);
        when(carRoleParking.check(baseCar)).thenReturn(true);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(true);
        when(parkingService.park(baseCar)).thenReturn(true);
        assertTrue(parkingService.unPark(baseCar));
    }

    @Test
    public void whenFailUnParkPassengerParking() {
        BaseCar baseCar = new PassengerCar(300);
        assertFalse(parkingService.unPark(baseCar));
    }

    @Test
    public void whenSuccessTruckParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new TruckCar(500);
        when(carRoleParking.check(baseCar)).thenReturn(true);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(true);
        assertTrue(parkingService.park(baseCar));
    }

    @Test
    public void whenNotRoleTruckParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new TruckCar(500);
        when(carRoleParking.check(baseCar)).thenReturn(false);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(true);
        assertFalse(parkingService.park(baseCar));
    }

    @Test
    public void whenBadRunMethodTruckParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new TruckCar(500);
        when(carRoleParking.check(baseCar)).thenReturn(true);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(false);
        assertFalse(parkingService.park(baseCar));
    }

    @Test
    public void whenSuccessUnParkTruckParking() {
        RoleParking carRoleParking = mock(RoleParking.class);
        MethodParking carMethodParking = mock(MethodParking.class);
        regulation.put(carRoleParking, carMethodParking);
        BaseCar baseCar = new TruckCar(500);
        when(carRoleParking.check(baseCar)).thenReturn(true);
        when(carMethodParking.run(baseCar, new ArrayList<>())).thenReturn(true);
        when(parkingService.park(baseCar)).thenReturn(true);
        assertTrue(parkingService.unPark(baseCar));
    }

    @Test
    public void whenFailUnParkTruckParking() {
        BaseCar baseCar = new TruckCar(500);
        assertTrue(parkingService.unPark(baseCar));
    }
}
