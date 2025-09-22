# H10E02 - Strategy Pattern

This project is a solution to the "Strategy Pattern" exercise for the INHN0006 Introduction to Software Engineering course by Prof. Dr. Stefan Wagner. The goal is to implement a system for searching book chapters, using different search algorithms based on the book's properties at runtime. The **Strategy Pattern** is a behavioral design pattern that allows you to choose different algorithms at runtime based on a policy.

---

## Project Tasks and Implementation

The solution is divided into two main tasks, with code implemented in files like `LinearSearch.java`, `BinarySearch.java`, `InterpolationSearch.java`, `SearchStrategy.java`, `Context.java`, and `Policy.java`.

### Task 1: Searching
This task involved implementing three distinct search algorithms to find a chapter within a book's list of chapters.

* **Linear Search**: Implemented to iterate through a list until the target chapter is found. It should be used when chapters are not sorted.
* **Binary Search**: Implemented for use on a sorted list of chapters, making it more efficient than a linear search. It should be used when chapters are sorted by name.
* **Interpolation Search**: Implemented for cases where chapters are sorted by page number, offering an even more efficient search. It should be used when chapters are sorted by page number.

### Task 2: Strategy Pattern Implementation
This task focused on applying the Strategy Pattern to dynamically select the most appropriate search algorithm.

* **`SearchStrategy` Interface**: A new interface was created and implemented by all three search algorithms (`LinearSearch`, `BinarySearch`, and `InterpolationSearch`).
* **`Context` Class**: This class holds the list of chapters and a `searchAlgorithm` object. It includes helper methods (`isChaptersSortedByName` and `isChaptersSortedByPageNumber`) to check if the chapters are sorted. The main `search` method executes the search using the currently selected strategy.
* **`Policy` Class**: This class contains the logic to configure the `Context` with the best search algorithm. The policy selects the appropriate search method based on the sorted state of the chapter list.
