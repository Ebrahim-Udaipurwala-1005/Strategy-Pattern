package de.tum.in.ase.eist;

import java.util.List;

public class InterpolationSearch implements SearchStrategy {
    @Override
    public Chapter performSearch(List<Chapter> book, String name, int pageNumber) {
        if (book == null || book.isEmpty()) {
            return null;
        }

        int low = 0;
        int high = book.size() - 1;

        while (low <= high
                && pageNumber >= book.get(low).getPageNumber()
                && pageNumber <= book.get(high).getPageNumber()) {

            // Special case when all page numbers are equal
            if (book.get(low).getPageNumber() == book.get(high).getPageNumber()) {
                if (book.get(low).getPageNumber() == pageNumber) {
                    return book.get(low);
                }
                return null;
            }

            // Interpolation formula
            int pos = low + ((pageNumber - book.get(low).getPageNumber()) * (high - low)) /
                    (book.get(high).getPageNumber() - book.get(low).getPageNumber());

            pos = Math.max(low, Math.min(pos, high)); // Ensure pos stays within bounds

            Chapter current = book.get(pos);

            if (current.getPageNumber() == pageNumber) {
                return current;
            } else if (current.getPageNumber() < pageNumber) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return null;
    }
}
