package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class Client {
    // TODO 1.1: Implement a new LinearSearch class according to the problem statement
    // TODO 1.2: Implement a new BinarySearch class according to the problem statement
    // TODO 1.3: Implement a new InterpolationSearch class according to the problem statement
    // TODO 2.1: Implement a new SearchStrategy interface
    // TODO 2.2: Implement a new Context class according to the UML and the problem statement
    // TODO 2.3: Implement a new Policy class according to the problem statement
    private static final int BOOK_MIN_SIZE = 5;
    private static final int BOOK_MAX_SIZE = 15;
    private static final int NUMBER_OF_SIMULATIONS = 10;
    private static final int PAGE_NUMBER_START_VALUE = 5;
    private static final int PAGE_NUMBER_MAX_VALUE = 4252343;

    private Client() {
        // Default
    }

    /**
     * Main method. Add code to demonstrate your implementation here.
     */
    public static void main(String[] args) {
        // TODO 7: Init Context and Policy

        // Run 10 times to simulate different search strategies
        for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++) {
            // TODO 8: Create a list of book entries using the method createRandomBook

            // TODO 9: Configure Context

            String chapterToSearch = createChapters(1).get(0);
            // TODO: Select a random page number from the book you created in TODO 8.
            int pageNumberToSearch = -1;
            // TODO 10: Search for the chapter in the book and store the result in the foundChapter
            Chapter foundChapter = null;
            System.out.println(
                    "Found the chapter \"" + foundChapter + "\"\nAccording to the search parameters: chapterName=" +
                    chapterToSearch + " | pageNumber=" + pageNumberToSearch);
        }
    }

    /**
     * Generates list of {@link Chapter} objects with random list size between 5 and 15.
     * The list is with equal probability sorted or not.
     * Also, the list is sorted by name or page number with equal probability.
     */
    private static List<Chapter> createRandomBook() {
        int listLength = randomIntegerWithin(BOOK_MIN_SIZE, BOOK_MAX_SIZE);

        List<Chapter> book = createChapters(listLength).stream()
                                                       .map(chapter -> new Chapter(chapter, createRandomPageNumber()))
                                                       .collect(Collectors.toList());

        boolean sorted = randomIntegerWithin(0, 1) == 0;
        boolean sortedByName = randomIntegerWithin(0, 1) == 0;
        if (sorted) {
            if (sortedByName) {
                book.sort(Comparator.comparing(Chapter::getName));
            } else {
                book.sort(Comparator.comparing(Chapter::getPageNumber));
            }
        }
        return book;
    }

    /**
     * Creates pseudo-random int value within a specified range
     *
     * @param high upper bound of the range (included)
     * @param low  lower bound of the range (included)
     */
    private static int randomIntegerWithin(int low, int high) {
        return ThreadLocalRandom.current().nextInt(low, high + 1);
    }

    private static int createRandomPageNumber() {
        return ThreadLocalRandom.current().nextInt(PAGE_NUMBER_START_VALUE, PAGE_NUMBER_MAX_VALUE);
    }

    private static List<String> createChapters(int numberOfChapters) {
        List<String> entryChapters = new ArrayList<>();
        List<String> chapters = new ArrayList<>(List.of("Modelling with UML", "System Design: Decomposing the system",
                                                        "Object Design: Reusing Pattern Solutions",
                                                        "Introduction to Software Engineering",
                                                        "Project Organization and Communication",
                                                        "Requirements Elicitation", "Analysis",
                                                        "System Design: Addressing Design Goals",
                                                        "Object Design: Specifying Interfaces",
                                                        "Mapping Models to Code", "Testing", "Rationale Management",
                                                        "Configuration Management", "How to pass an EIST exam",
                                                        "Introduction to High Performance Computing"));

        for (int i = 0; i < numberOfChapters; i++) {
            entryChapters.add(chapters.remove(randomIntegerWithin(0, chapters.size() - 1)));
        }
        return entryChapters;
    }
}
