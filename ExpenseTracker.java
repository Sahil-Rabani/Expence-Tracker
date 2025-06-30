
import java.util.*;

class Expense {
    String description;
    double amount;
    String date;

    Expense(String description, double amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return date + " | " + description + " | ₹" + String.format("%.2f", amount);
    }
}

public class ExpenseTracker {
    static Scanner sc = new Scanner(System.in);
    static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Expense Tracker Menu ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewExpenses();
                case 3 -> viewTotal();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addExpense() {
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        expenses.add(new Expense(desc, amount, date));
        System.out.println("Expense added.");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense exp : expenses) {
                System.out.println(exp);
            }
        }
    }

    static void viewTotal() {
        double total = 0;
        for (Expense exp : expenses) {
            total += exp.amount;
        }
        System.out.println("Total Expense: ₹" + String.format("%.2f", total));
    }
}
