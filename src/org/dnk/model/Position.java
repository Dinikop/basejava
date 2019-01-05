package org.dnk.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private final LocalDate beginDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Position(LocalDate beginDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(beginDate, "begin date must not be null");
        Objects.requireNonNull(endDate, "endDate date must not be null");
        Objects.requireNonNull(title, "title date must not be null");
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return beginDate.equals(position.beginDate) &&
                endDate.equals(position.endDate) &&
                title.equals(position.title) &&
                Objects.equals(description, position.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginDate, endDate, title, description);
    }

    @Override
    public String toString() {
        return "Position{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
