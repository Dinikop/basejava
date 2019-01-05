package org.dnk.model;

import java.util.Objects;

public class TextSection extends AbstractSection {

    private final String item;

    public TextSection(String item) {
        Objects.requireNonNull(item, "item must not be null");
        this.item = item;
    }

    public String getItem() {
        return item;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return item.equals(that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return item;
    }
}
