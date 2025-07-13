package de.tum.in.ase.eist;

import java.util.List;

public class InterpolationSearch implements SearchStrategy {
    @Override
    public Chapter performSearch(List<Chapter> book, String name, int pageNumber) {
        if (book == null || book.isEmpty()) {
            return null;
        }
        int left = 0;
        int right = book.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) * (pageNumber - book.get(left).getPageNumber()) / (book.get(right).getPageNumber() - book.get(left).getPageNumber()));
            Chapter chapter = book.get(mid);
            if (chapter.getPageNumber() == pageNumber) {
                return chapter;
            }
            else if (chapter.getPageNumber() < pageNumber) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return null;
    }
}
