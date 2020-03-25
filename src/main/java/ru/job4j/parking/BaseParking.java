package ru.job4j.parking;

import ru.job4j.car.Car;
import ru.job4j.parking.place.Place;

import java.util.List;
import java.util.Map;

public abstract class BaseParking implements Parking {
    private final int countTruckPlaces;
    private final int countPassengerCarPlaces;
    private final List<Place> places;
    private final Map<Car, List<Place>> cars;

    public BaseParking(int countTruckPlaces, int countPassengerCarPlaces, List<Place> places, Map<Car, List<Place>> cars) {
        this.countTruckPlaces = countTruckPlaces;
        this.countPassengerCarPlaces = countPassengerCarPlaces;
        this.places = places;
        this.cars = cars;
    }

    public int getCountTruckPlaces() {
        return countTruckPlaces;
    }

    public int getCountPassengerCarPlaces() {
        return countPassengerCarPlaces;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
