package model;

import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private List<String> descriptions;

    public ListSection(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return descriptions.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(descriptions, that.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptions);
    }
}
