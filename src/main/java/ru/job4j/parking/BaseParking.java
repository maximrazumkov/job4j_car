package ru.job4j.parking;

import ru.job4j.parking.place.BasePlace;

import java.util.List;

public abstract class BaseParking {
    private final int countTruckPlaces;
    private final int countPassengerCarPlaces;
    private final List<BasePlace> places;

    public BaseParking(int countTruckPlaces, int countPassengerCarPlaces, List<BasePlace> places) {
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

    public List<BasePlace> getPlaces() {
        return places;
    }
}
