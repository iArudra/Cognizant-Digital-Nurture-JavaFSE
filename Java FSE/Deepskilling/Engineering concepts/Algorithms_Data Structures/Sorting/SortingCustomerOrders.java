import java.util.Arrays;

/**
 * Exercise 3: Sorting Customer Orders
 *
 * Sorting Algorithms Overview:
 * - Bubble Sort : Simple, compares adjacent elements. O(n²) worst/avg. Good for tiny datasets.
 * - Insertion Sort: Builds sorted array one item at a time. O(n²) worst, O(n) best.
 * - Quick Sort   : Divide & conquer, pivot-based. O(n log n) average, O(n²) worst case.
 * - Merge Sort   : Divide & conquer, always O(n log n). Uses extra O(n) space.
 *
 * Implemented: Bubble Sort + Quick Sort (sort by totalPrice ascending)
 */
public class SortingCustomerOrders {

    // ── Order class ───────────────────────────────────────────────────────────
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        Order(int orderId, String customerName, double totalPrice) {
            this.orderId      = orderId;
            this.customerName = customerName;
            this.totalPrice   = totalPrice;
        }

        @Override
        public String toString() {
            return String.format("[OrderID=%d | %-15s | $%.2f]", orderId, customerName, totalPrice);
        }
    }

    // ── Bubble Sort – O(n²) ───────────────────────────────────────────────────
    /**
     * Repeatedly swaps adjacent elements if they are out of order.
     * Time Complexity: Best O(n) [already sorted], Average/Worst O(n²)
     * Space Complexity: O(1) in-place
     */
    public static Order[] bubbleSort(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp  = arr[j];
                    arr[j]      = arr[j + 1];
                    arr[j + 1]  = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimisation: early exit if already sorted
        }
        return arr;
    }

    // ── Quick Sort – O(n log n) avg ────────────────────────────────────────────
    /**
     * Picks a pivot, partitions array so all elements < pivot come before it.
     * Recursively sorts partitions.
     * Time Complexity: Average O(n log n), Worst O(n²) [sorted/reverse-sorted input]
     * Space Complexity: O(log n) stack space
     */
    public static Order[] quickSort(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSortHelper(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low,  pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                i++;
                Order temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        Order temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    // ── Helpers ───────────────────────────────────────────────────────────────
    private static void printOrders(String label, Order[] orders) {
        System.out.println("\n" + label);
        for (Order o : orders) System.out.println("  " + o);
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Exercise 3: Sorting Customer Orders ===\n");

        Order[] orders = {
            new Order(1001, "Alice",   245.50),
            new Order(1002, "Bob",      89.99),
            new Order(1003, "Charlie", 512.00),
            new Order(1004, "Diana",   175.75),
            new Order(1005, "Eve",     340.00),
            new Order(1006, "Frank",    55.25),
        };

        printOrders("Original Orders:", orders);

        // Bubble Sort
        long start = System.nanoTime();
        Order[] bubbleSorted = bubbleSort(orders);
        long bubbleTime = System.nanoTime() - start;
        printOrders("Bubble Sort (by totalPrice):", bubbleSorted);
        System.out.println("  Time taken: " + bubbleTime + " ns");

        // Quick Sort
        start = System.nanoTime();
        Order[] quickSorted = quickSort(orders);
        long quickTime = System.nanoTime() - start;
        printOrders("Quick Sort (by totalPrice):", quickSorted);
        System.out.println("  Time taken: " + quickTime + " ns");

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Bubble Sort : Best O(n) | Average O(n²) | Worst O(n²) | Space O(1)");
        System.out.println("Quick Sort  : Best O(n log n) | Average O(n log n) | Worst O(n²) | Space O(log n)");
        System.out.println("\nWhy Quick Sort is preferred:");
        System.out.println("- Much faster in practice for large datasets (cache-friendly, in-place)");
        System.out.println("- O(n log n) average vs O(n²) for Bubble Sort");
        System.out.println("- Worst case avoided by choosing good pivot (random/median-of-3)");
        System.out.println("- Bubble Sort only practical for n < 10 or nearly sorted data");
    }
}
