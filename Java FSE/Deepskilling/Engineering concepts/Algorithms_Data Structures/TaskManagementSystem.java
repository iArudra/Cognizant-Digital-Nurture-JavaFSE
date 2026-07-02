/**
 * Exercise 5: Task Management System
 *
 * Linked List Types:
 * - Singly Linked List : Each node holds data + pointer to next node. O(1) insert at head.
 * - Doubly Linked List : Each node holds data + next + prev pointers. O(1) delete with node ref.
 * - Circular Linked List: Last node points back to head. Used in round-robin schedulers.
 *
 * Advantages of Linked Lists over Arrays:
 * - Dynamic size (no pre-allocation needed)
 * - O(1) insert/delete at head (no shifting)
 * - Efficient for frequent insertions/deletions
 *
 * Disadvantage:
 * - O(n) random access (no direct index)
 * - Extra memory for pointer/reference per node
 */
public class TaskManagementSystem {

    // ── Task class ────────────────────────────────────────────────────────────
    static class Task {
        int taskId;
        String taskName;
        String status;
        Task next;

        Task(int taskId, String taskName, String status) {
            this.taskId   = taskId;
            this.taskName = taskName;
            this.status   = status;
            this.next     = null;
        }

        @Override
        public String toString() {
            return String.format("[ID=%d | %-25s | %s]", taskId, taskName, status);
        }
    }

    // ── Singly Linked List ────────────────────────────────────────────────────
    private Task head;
    private int size;

    TaskManagementSystem() {
        head = null;
        size = 0;
    }

    /** Add task at the beginning – O(1) */
    public void addTask(Task task) {
        task.next = head;
        head      = task;
        size++;
        System.out.println("Added: " + task);
    }

    /** Search task by ID – O(n) */
    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) return current;
            current = current.next;
        }
        return null;
    }

    /** Traverse all tasks – O(n) */
    public void traverseTasks() {
        System.out.println("\n--- Task List (" + size + " tasks) ---");
        if (head == null) { System.out.println("  (no tasks)"); return; }
        Task current = head;
        int pos = 1;
        while (current != null) {
            System.out.println("  " + pos++ + ". " + current);
            current = current.next;
        }
        System.out.println("----------------------------------------------");
    }

    /** Delete task by ID – O(n) */
    public boolean deleteTask(int taskId) {
        if (head == null) { System.out.println("List is empty."); return false; }

        // Special case: head is the target
        if (head.taskId == taskId) {
            System.out.println("Deleted: " + head);
            head = head.next;
            size--;
            return true;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == taskId) {
                System.out.println("Deleted: " + current.next);
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        System.out.println("Task ID " + taskId + " not found.");
        return false;
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Task Management System (Singly Linked List) ===\n");

        TaskManagementSystem tms = new TaskManagementSystem();

        // Add tasks
        System.out.println("-- Adding Tasks --");
        tms.addTask(new Task(1, "Design Database Schema",    "Pending"));
        tms.addTask(new Task(2, "Implement REST API",        "In Progress"));
        tms.addTask(new Task(3, "Write Unit Tests",          "Pending"));
        tms.addTask(new Task(4, "Code Review",               "Completed"));
        tms.addTask(new Task(5, "Deploy to Staging",         "Pending"));

        tms.traverseTasks();

        // Search
        System.out.println("\n-- Search for Task ID 3 --");
        Task found = tms.searchTask(3);
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("\n-- Search for Task ID 99 --");
        found = tms.searchTask(99);
        System.out.println(found != null ? "Found: " + found : "Not found");

        // Delete
        System.out.println("\n-- Delete Task ID 2 --");
        tms.deleteTask(2);

        System.out.println("\n-- Delete Task ID 5 (head) --");
        tms.deleteTask(5);

        tms.traverseTasks();

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Add (at head) : O(1) — update head pointer only");
        System.out.println("Search        : O(n) — must traverse from head");
        System.out.println("Traverse      : O(n) — visit every node");
        System.out.println("Delete        : O(n) — find node then re-link pointers");
        System.out.println("\nAdvantages over arrays:");
        System.out.println("- No shifting of elements; O(1) insert/delete at head");
        System.out.println("- Dynamic size — grows as needed without pre-allocation");
        System.out.println("- Memory allocated per element, not wasted for unused slots");
    }
}
