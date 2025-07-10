package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {
    public Chapter performSearch(List<Chapter> book, String name, int pageNumber) {
        if (book == null || book.isEmpty()) {
            return null;
        }
        else {
            int left = 0;
            int right = book.size() - 1;
            while (left <= right) {
                int middle = left + Math.floorDiv(right - left, 2);
                Chapter chapter = book.get(middle);
                int comparison = name.compareTo(chapter.getName());

                if (comparison == 0) {
                    return chapter;
                } else if (comparison < 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return null;
    }
}
