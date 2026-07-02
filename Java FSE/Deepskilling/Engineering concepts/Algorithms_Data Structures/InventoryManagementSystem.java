import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 1: Inventory Management System
 *
 * Why Data Structures & Algorithms matter for large inventories:
 * - A warehouse may hold thousands/millions of products; naive linear search is too slow.
 * - HashMap gives O(1) average-case for add, update, delete and lookup by productId.
 * - Sorting algorithms help generate reports by price/quantity in O(n log n).
 *
 * Data Structure chosen: HashMap<Integer, Product>
 *   - Key   : productId  (unique identifier)
 *   - Value : Product object
 *   - Add    : O(1) average
 *   - Update : O(1) average
 *   - Delete : O(1) average
 *   - Lookup : O(1) average
 */
public class InventoryManagementSystem {

    // ── Product class ─────────────────────────────────────────────────────────
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId   = productId;
            this.productName = productName;
            this.quantity    = quantity;
            this.price       = price;
        }

        @Override
        public String toString() {
            return String.format("[ID=%d | %-20s | Qty=%-4d | Price=$%.2f]",
                    productId, productName, quantity, price);
        }
    }

    // ── Inventory using HashMap ───────────────────────────────────────────────
    private Map<Integer, Product> inventory = new HashMap<>();

    /** Add a product – O(1) average */
    public void addProduct(Product p) {
        if (inventory.containsKey(p.productId)) {
            System.out.println("Product ID " + p.productId + " already exists. Use update instead.");
            return;
        }
        inventory.put(p.productId, p);
        System.out.println("Added: " + p);
    }

    /** Update an existing product – O(1) average */
    public void updateProduct(int productId, int newQty, double newPrice) {
        Product p = inventory.get(productId);
        if (p == null) {
            System.out.println("Product ID " + productId + " not found.");
            return;
        }
        p.quantity = newQty;
        p.price    = newPrice;
        System.out.println("Updated: " + p);
    }

    /** Delete a product by ID – O(1) average */
    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed == null) {
            System.out.println("Product ID " + productId + " not found.");
        } else {
            System.out.println("Deleted: " + removed);
        }
    }

    /** Display all products – O(n) */
    public void displayInventory() {
        System.out.println("\n--- Current Inventory (" + inventory.size() + " products) ---");
        if (inventory.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            inventory.values().forEach(System.out::println);
        }
        System.out.println("-------------------------------------------");
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        System.out.println("=== Exercise 1: Inventory Management System ===\n");

        // Add products
        System.out.println("-- Adding Products --");
        ims.addProduct(new Product(101, "Laptop",        50,  999.99));
        ims.addProduct(new Product(102, "Wireless Mouse", 200, 29.99));
        ims.addProduct(new Product(103, "USB-C Hub",     150, 49.99));
        ims.addProduct(new Product(104, "Monitor 27\"",  30,  399.99));

        ims.displayInventory();

        // Update
        System.out.println("\n-- Updating Product 102 --");
        ims.updateProduct(102, 180, 24.99);
        ims.displayInventory();

        // Delete
        System.out.println("\n-- Deleting Product 103 --");
        ims.deleteProduct(103);
        ims.displayInventory();

        // Try duplicate add
        System.out.println("\n-- Attempting duplicate add (ID 101) --");
        ims.addProduct(new Product(101, "Duplicate Laptop", 10, 10.0));

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Add    : O(1) average  [HashMap.put()]");
        System.out.println("Update : O(1) average  [HashMap.get() + field update]");
        System.out.println("Delete : O(1) average  [HashMap.remove()]");
        System.out.println("Display: O(n)          [iterate all entries]");
        System.out.println("\nOptimization: HashMap already provides near-constant time operations.");
        System.out.println("For sorted reports, use TreeMap (O(log n) ops) or sort values on demand.");
    }
}
