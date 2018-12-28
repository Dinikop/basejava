package model;

import java.time.LocalDate;
import java.util.Objects;

public class Place {
    private String name;
    private String url;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String description;
    private String note;

    public Place(String name, String url, LocalDate beginDate, LocalDate endDate, String description, String note) {
        this.name = name;
        this.url = url;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.description = description;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(name, place.name) &&
                Objects.equals(url, place.url) &&
                Objects.equals(beginDate, place.beginDate) &&
                Objects.equals(endDate, place.endDate) &&
                Objects.equals(description, place.description) &&
                Objects.equals(note, place.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, beginDate, endDate, description, note);
    }
}
