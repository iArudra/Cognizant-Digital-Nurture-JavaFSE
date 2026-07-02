import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 7: Financial Forecasting
 *
 * Recursion:
 * - Recursion solves a problem by breaking it into smaller sub-problems of the same type.
 * - A recursive function calls itself with a simpler input until a base case is reached.
 * - It simplifies code for naturally recursive problems (trees, divide & conquer, math series).
 *
 * Future Value Formula:
 *   FV(n) = PV × (1 + r)^n
 *   where:
 *     PV = Present Value (initial investment)
 *     r  = Annual growth rate (as decimal, e.g. 0.08 for 8%)
 *     n  = Number of years
 *
 * Recursive definition:
 *   FV(0) = PV                 (base case)
 *   FV(n) = FV(n-1) × (1 + r) (recursive case)
 *
 * Time Complexity:
 * - Naive recursion: O(n) — one call per year
 * - With memoization: O(n) time, O(n) space (avoids recomputation in branching scenarios)
 * - Iterative version: O(n) time, O(1) space (best for simple linear recursion)
 */
public class FinancialForecasting {

    // ── Recursive future value – O(n) ─────────────────────────────────────────
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int years) {
        // Base case: no years left, return present value
        if (years == 0) return presentValue;
        // Recursive case: apply one year's growth, then recurse
        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // ── Memoized recursive future value – O(n) time, O(n) space ──────────────
    private static Map<Integer, Double> memo = new HashMap<>();

    /**
     * Memoization avoids recomputing overlapping sub-problems.
     * Useful when the same year value is queried multiple times (e.g., in complex branching scenarios).
     */
    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        if (memo.containsKey(years)) return memo.get(years);
        double result = calculateFutureValueMemo(presentValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    // ── Iterative future value – O(n) time, O(1) space ───────────────────────
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double value = presentValue;
        for (int i = 0; i < years; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }

    // ── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Exercise 7: Financial Forecasting ===\n");

        double initialInvestment = 10_000.00; // $10,000
        double annualGrowthRate  = 0.08;      // 8% annual return

        System.out.printf("Initial Investment : $%.2f%n", initialInvestment);
        System.out.printf("Annual Growth Rate : %.0f%%%n%n", annualGrowthRate * 100);

        System.out.println("-- Year-by-Year Forecast (Recursive) --");
        System.out.printf("%-6s  %-20s  %-20s%n", "Year", "Recursive", "Iterative");
        System.out.println("-".repeat(50));

        for (int year : new int[]{1, 5, 10, 15, 20, 25, 30}) {
            memo.clear();
            double recursive = calculateFutureValueRecursive(initialInvestment, annualGrowthRate, year);
            double iterative = calculateFutureValueIterative(initialInvestment, annualGrowthRate, year);
            System.out.printf("%-6d  $%-19.2f  $%-19.2f%n", year, recursive, iterative);
        }

        // Performance comparison
        System.out.println("\n-- Performance Comparison (30 years) --");
        int years = 30;

        long start = System.nanoTime();
        double rResult = calculateFutureValueRecursive(initialInvestment, annualGrowthRate, years);
        long rTime = System.nanoTime() - start;

        memo.clear();
        start = System.nanoTime();
        double mResult = calculateFutureValueMemo(initialInvestment, annualGrowthRate, years);
        long mTime = System.nanoTime() - start;

        start = System.nanoTime();
        double iResult = calculateFutureValueIterative(initialInvestment, annualGrowthRate, years);
        long iTime = System.nanoTime() - start;

        System.out.printf("Recursive   : $%.2f  (%d ns)%n", rResult, rTime);
        System.out.printf("Memoized    : $%.2f  (%d ns)%n", mResult, mTime);
        System.out.printf("Iterative   : $%.2f  (%d ns)%n", iResult, iTime);

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Recursive   : O(n) — one recursive call per year (linear chain)");
        System.out.println("Memoized    : O(n) time, O(n) space — stores each year's value");
        System.out.println("Iterative   : O(n) time, O(1) space — best for simple linear growth");
        System.out.println("\nOptimization Notes:");
        System.out.println("- For simple linear growth, iterative is most efficient (no call stack overhead)");
        System.out.println("- Memoization shines for branching scenarios (e.g., multiple rate scenarios reusing sub-results)");
        System.out.println("- For very large n, use the closed-form formula: PV × (1+r)^n → O(log n) with fast exponentiation");
    }
}
