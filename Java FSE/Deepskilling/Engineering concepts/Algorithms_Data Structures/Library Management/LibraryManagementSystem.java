import java.util.Arrays;
import java.util.Comparator;

/**
 * Exercise 6: Library Management System
 *
 * Search Algorithms:
 * - Linear Search: Iterate through each record until match found. O(n).
 * - Binary Search: Works on SORTED data. Divide-and-conquer, each step eliminates half.
 *                  O(log n) – much faster for large datasets.
 *
 * When to use:
 * - Linear Search : Small datasets, unsorted data, or one-time searches.
 * - Binary Search : Large datasets that are already sorted (or worth sorting once).
 */
public class LibraryManagementSystem {

    // ── Book class ────────────────────────────────────────────────────────────
    static class Book {
        int bookId;
        String title;
        String author;

        Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title  = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("[ID=%d | %-35s | %s]", bookId, title, author);
        }
    }

    // ── Linear Search by title – O(n) ─────────────────────────────────────────
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    // ── Binary Search by title – O(log n) ────────────────────────────────────
    // Pre-condition: books[] must be sorted alphabetically by title
    public static Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int low = 0, high = sortedBooks.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedBooks[mid].title.compareToIgnoreCase(title);
            if      (cmp == 0) return sortedBooks[mid];
            else if (cmp < 0)  low  = mid + 1;
            else               high = mid - 1;
        }
        return null;
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Library Management System ===\n");

        Book[] books = {
            new Book(1,  "The Pragmatic Programmer",        "Andrew Hunt"),
            new Book(2,  "Clean Code",                      "Robert C. Martin"),
            new Book(3,  "Design Patterns",                 "Gang of Four"),
            new Book(4,  "Introduction to Algorithms",      "Cormen et al."),
            new Book(5,  "Effective Java",                   "Joshua Bloch"),
            new Book(6,  "Head First Java",                 "Kathy Sierra"),
            new Book(7,  "Java Concurrency in Practice",    "Brian Goetz"),
            new Book(8,  "Spring in Action",                "Craig Walls"),
        };

        System.out.println("Library Catalog:");
        for (Book b : books) System.out.println("  " + b);

        // -- Linear Search --
        String target = "Effective Java";
        System.out.println("\n-- Linear Search for: \"" + target + "\" --");
        long start = System.nanoTime();
        Book result = linearSearchByTitle(books, target);
        long linearTime = System.nanoTime() - start;
        System.out.println(result != null ? "Found   : " + result : "Not Found");
        System.out.println("Time    : " + linearTime + " ns");

        // -- Binary Search (sorted array) --
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n-- Binary Search for: \"" + target + "\" --");
        start = System.nanoTime();
        result = binarySearchByTitle(sortedBooks, target);
        long binaryTime = System.nanoTime() - start;
        System.out.println(result != null ? "Found   : " + result : "Not Found");
        System.out.println("Time    : " + binaryTime + " ns");

        // -- Search for non-existent book --
        String missing = "The Hobbit";
        System.out.println("\n-- Searching for non-existent book: \"" + missing + "\" --");
        System.out.println("Linear: " + (linearSearchByTitle(books, missing) != null ? "Found" : "Not Found"));
        System.out.println("Binary: " + (binarySearchByTitle(sortedBooks, missing) != null ? "Found" : "Not Found"));

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Linear Search : O(n)      — no prerequisite; checks each element");
        System.out.println("Binary Search : O(log n)  — requires sorted data");
        System.out.println("\nWhen to use each:");
        System.out.println("- Small library (< 100 books) : Linear search is fine and simpler");
        System.out.println("- Large library (> 1000 books): Binary search gives significant speedup");
        System.out.println("  e.g., n=1,000,000 → linear needs up to 1M comparisons vs binary ~20");
        System.out.println("- If data changes frequently, maintaining sorted order has overhead → consider a BST or index");
    }
}
