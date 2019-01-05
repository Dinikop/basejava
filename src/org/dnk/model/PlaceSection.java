package org.dnk.model;

import java.util.List;
import java.util.Objects;

public class PlaceSection extends AbstractSection {
    private final List<Place> places;

    public PlaceSection(List<Place> places) {
        Objects.requireNonNull(places, "Places must not be null");
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceSection that = (PlaceSection) o;
        return places.equals(that.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(places);
    }

    @Override
    public String toString() {
        return places.toString();
    }
}
