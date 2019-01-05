package org.dnk.model;

import java.util.List;
import java.util.Objects;

public class Place {
    private final Link homePage;
    private final List<Position> positions;

    public Place(String name, String url, List<Position> positions) {
        this.homePage = new Link(name, url);
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(homePage, place.homePage) &&
                Objects.equals(positions, place.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }

    @Override
    public String toString() {
        return "Place{" +
                "homePage=" + homePage +
                ", positions=" + positions +
                '}';
    }
}
