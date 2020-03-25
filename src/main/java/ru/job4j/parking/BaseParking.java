package ru.job4j.parking;

import ru.job4j.parking.place.Place;

import java.util.List;

public abstract class BaseParking {
    private final int countTruckPlaces;
    private final int countPassengerCarPlaces;
    private final List<Place> places;

    public BaseParking(int countTruckPlaces, int countPassengerCarPlaces, List<Place> places) {
        this.countTruckPlaces = countTruckPlaces;
        this.countPassengerCarPlaces = countPassengerCarPlaces;
        this.places = places;
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
