package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private List<Chapter> book;
    private SearchStrategy searchAlgorithm;

    public Context() {
        this.book = new ArrayList<>();
    }

    public List<Chapter> getBook() {
        return book;
    }

    public void setBook(List<Chapter> book) {
        this.book = book;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public boolean isChaptersSortedByName() {
        for (int i = 0; i < this.book.size(); i++) {
            int comparison = book.get(i).getName().compareTo(book.get(i + 1).getName());
            if (comparison < 0) {
                return true;
            }
            else if (comparison > 0) {
                return false;
            }
        }
        return false;
    }

    public boolean isChaptersSortedByPageNumber() {
        return false;
    }
}
