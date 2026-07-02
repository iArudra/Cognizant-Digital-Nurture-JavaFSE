/**
 * Exercise 4: Employee Management System
 *
 * Array Representation in Memory:
 * - Arrays store elements in contiguous memory locations.
 * - Each element is accessed via base_address + (index × element_size) → O(1) random access.
 * - Fixed size: must declare capacity upfront; resizing requires creating a new array (O(n)).
 *
 * Advantages of arrays:
 * - O(1) access by index
 * - Cache-friendly (contiguous memory)
 * - Simple, low overhead
 *
 * Limitations:
 * - Fixed size (static allocation)
 * - O(n) insert/delete (shifting required)
 * - Wasted space if under-utilized
 */
public class EmployeeManagementSystem {

    // ── Employee class ────────────────────────────────────────────────────────
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name       = name;
            this.position   = position;
            this.salary     = salary;
        }

        @Override
        public String toString() {
            return String.format("[ID=%d | %-15s | %-20s | $%.2f]",
                    employeeId, name, position, salary);
        }
    }

    // ── Array-based storage ───────────────────────────────────────────────────
    private Employee[] employees;
    private int size;
    private static final int CAPACITY = 100;

    EmployeeManagementSystem() {
        employees = new Employee[CAPACITY];
        size = 0;
    }

    /** Add employee – O(1) amortized (append to end) */
    public void addEmployee(Employee e) {
        if (size >= CAPACITY) {
            System.out.println("Array full. Cannot add more employees.");
            return;
        }
        employees[size++] = e;
        System.out.println("Added: " + e);
    }

    /** Search employee by ID – O(n) linear scan */
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) return employees[i];
        }
        return null;
    }

    /** Traverse all employees – O(n) */
    public void traverseEmployees() {
        System.out.println("\n--- Employee List (" + size + " records) ---");
        if (size == 0) { System.out.println("  (no employees)"); return; }
        for (int i = 0; i < size; i++) {
            System.out.println("  " + employees[i]);
        }
        System.out.println("-----------------------------------------------");
    }

    /** Delete employee by ID – O(n) [shift elements left after deletion] */
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                System.out.println("Deleted: " + employees[i]);
                // Shift remaining elements left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // help GC
                return true;
            }
        }
        System.out.println("Employee ID " + employeeId + " not found.");
        return false;
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Exercise 4: Employee Management System ===\n");

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Add employees
        System.out.println("-- Adding Employees --");
        ems.addEmployee(new Employee(1001, "Alice Johnson",  "Software Engineer", 85000));
        ems.addEmployee(new Employee(1002, "Bob Smith",      "Project Manager",   95000));
        ems.addEmployee(new Employee(1003, "Carol White",    "QA Analyst",        72000));
        ems.addEmployee(new Employee(1004, "David Brown",    "DevOps Engineer",   88000));
        ems.addEmployee(new Employee(1005, "Eva Martinez",   "UI/UX Designer",    78000));

        ems.traverseEmployees();

        // Search
        System.out.println("\n-- Search for Employee ID 1003 --");
        Employee found = ems.searchEmployee(1003);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n-- Search for Employee ID 9999 --");
        found = ems.searchEmployee(9999);
        System.out.println(found != null ? "Found: " + found : "Not found");

        // Delete
        System.out.println("\n-- Delete Employee ID 1002 --");
        ems.deleteEmployee(1002);
        ems.traverseEmployees();

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Add      : O(1) — append to end of array");
        System.out.println("Search   : O(n) — linear scan (no index on ID)");
        System.out.println("Traverse : O(n) — visit every element");
        System.out.println("Delete   : O(n) — find element + shift remaining elements left");
        System.out.println("\nArray Limitations:");
        System.out.println("- Fixed capacity (must resize manually)");
        System.out.println("- Delete/Insert in middle is O(n) due to shifting");
        System.out.println("- Use ArrayList for dynamic resizing, or HashMap for O(1) lookup by ID");
    }
}
