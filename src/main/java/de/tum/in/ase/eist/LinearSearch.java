package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {
    public Chapter performSearch(List<Chapter> book, String name, int pageNumber) {
        for (Chapter chapter : book) {
            if (chapter.getName().equals(name)) {
                return chapter;
            }
        }
        return null;
    }
}
