package model;

import java.util.List;
import java.util.Objects;

public class PlaceSection extends AbstractSection {
    private List<Place> places;

    public PlaceSection(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return places.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceSection that = (PlaceSection) o;
        return Objects.equals(places, that.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(places);
    }
}
