package model;

import java.util.Objects;

public class Place {
    private String name;
    private String beginDate;
    private String endDate;
    private String description;
    private String note;

    public Place(String name, String beginDate, String endDate, String description, String note) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.description = description;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
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
                Objects.equals(beginDate, place.beginDate) &&
                Objects.equals(endDate, place.endDate) &&
                Objects.equals(description, place.description) &&
                Objects.equals(note, place.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, beginDate, endDate, description, note);
    }
}
