package model;

import java.time.LocalDate;
import java.util.Objects;

public class Place {
    private final Link homePadge;
    private final LocalDate beginDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Place(String name, String url, LocalDate beginDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(beginDate, "begin date must not be null");
        Objects.requireNonNull(endDate, "endDate date must not be null");
        Objects.requireNonNull(title, "title date must not be null");
        this.homePadge = new Link(name, url);
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return homePadge.equals(place.homePadge) &&
                beginDate.equals(place.beginDate) &&
                endDate.equals(place.endDate) &&
                title.equals(place.title) &&
                Objects.equals(description, place.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePadge, beginDate, endDate, title, description);
    }

    @Override
    public String toString() {
        return "Place{" +
                "homePadge=" + homePadge +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
