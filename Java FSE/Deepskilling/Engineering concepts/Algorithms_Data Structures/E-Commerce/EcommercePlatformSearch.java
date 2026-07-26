import java.util.Arrays;
import java.util.Comparator;

/**
 * Exercise 2: E-commerce Platform Search Function
 *
 * Big O Notation:
 * - Big O describes the upper bound of an algorithm's time complexity as input grows.
 * - It helps compare algorithms independent of hardware.
 *
 * Search Scenarios:
 * - Linear Search:  Best O(1) | Average O(n) | Worst O(n)
 * - Binary Search:  Best O(1) | Average O(log n) | Worst O(log n)
 *   (Binary search requires a sorted array)
 */
public class EcommercePlatformSearch {

    // ── Product class ─────────────────────────────────────────────────────────
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId   = productId;
            this.productName = productName;
            this.category    = category;
        }

        @Override
        public String toString() {
            return String.format("[ID=%d | %-25s | %s]", productId, productName, category);
        }
    }

    // ── Linear Search – O(n) ─────────────────────────────────────────────────
    /**
     * Scans every element until a match is found.
     * Time Complexity: O(n) — must check each product in worst case.
     */
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // ── Binary Search – O(log n) ──────────────────────────────────────────────
    /**
     * Divides the sorted array in half each iteration.
     * Pre-condition: products array MUST be sorted by productName.
     * Time Complexity: O(log n) — eliminates half the search space each step.
     */
    public static Product binarySearch(Product[] sortedProducts, String targetName) {
        int low = 0, high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedProducts[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return sortedProducts[mid];
            else if (cmp < 0) low  = mid + 1;
            else              high = mid - 1;
        }
        return null;
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Exercise 2: E-commerce Platform Search Function ===\n");

        Product[] products = {
            new Product(1, "Smartphone",       "Electronics"),
            new Product(2, "Running Shoes",    "Footwear"),
            new Product(3, "Coffee Maker",     "Appliances"),
            new Product(4, "Java Programming", "Books"),
            new Product(5, "Yoga Mat",         "Sports"),
            new Product(6, "Headphones",       "Electronics"),
            new Product(7, "Backpack",         "Accessories"),
        };

        // Linear Search
        System.out.println("-- Linear Search --");
        String target = "Coffee Maker";
        long start = System.nanoTime();
        Product result = linearSearch(products, target);
        long elapsed = System.nanoTime() - start;
        System.out.println("Search for: \"" + target + "\"");
        System.out.println("Result : " + (result != null ? result : "Not Found"));
        System.out.println("Time   : " + elapsed + " ns\n");

        // Sort for Binary Search
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("-- Binary Search (sorted array) --");
        start = System.nanoTime();
        result = binarySearch(sortedProducts, target);
        elapsed = System.nanoTime() - start;
        System.out.println("Search for: \"" + target + "\"");
        System.out.println("Result : " + (result != null ? result : "Not Found"));
        System.out.println("Time   : " + elapsed + " ns\n");

        // Search for non-existent
        System.out.println("-- Searching for non-existent product --");
        System.out.println("Linear: " + (linearSearch(products, "Toaster") != null ? "Found" : "Not Found"));
        System.out.println("Binary: " + (binarySearch(sortedProducts, "Toaster") != null ? "Found" : "Not Found"));

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Linear Search : O(n)      — checks every element");
        System.out.println("Binary Search : O(log n)  — requires sorted data, halves search space");
        System.out.println("\nRecommendation for e-commerce:");
        System.out.println("- Small/unsorted datasets  => Linear Search (simpler, no pre-sort cost)");
        System.out.println("- Large/sorted datasets    => Binary Search (much faster, O(log n))");
        System.out.println("- Production systems       => Inverted index / search engines (e.g., Elasticsearch)");
    }
}
