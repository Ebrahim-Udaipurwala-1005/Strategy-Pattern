package de.tum.in.ase.eist;

import java.util.List;

public interface SearchStrategy {
    public Chapter performSearch(List<Chapter> book, String name, int pageNumber);
}
