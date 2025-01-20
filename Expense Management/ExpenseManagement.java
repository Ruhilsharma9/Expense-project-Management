import java.io.*;
import java.util.*;

class Expense {
    private int id;
    private String category;
    private String description;
    private double amount;

    // Constructor
    public Expense(int id, String category, String description, double amount) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Category: " + category + ", Description: " + description + ", Amount: " + amount;
    }
}

public class ExpenseManagement {
    private static final String FILE_NAME = "expenses.txt";
    private static List<Expense> expenseList = new ArrayList<>();
    private static int expenseIdCounter = 1;

    public static void main(String[] args) {
        loadExpenses(); // Load expenses from file on startup
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Management System");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    updateExpense(scanner);
                    break;
                case 4:
                    deleteExpense(scanner);
                    break;
                case 5:
                    saveExpenses();
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter category: ");
        scanner.nextLine(); // Consume newline
        String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        Expense expense = new Expense(expenseIdCounter++, category, description, amount);
        expenseList.add(expense);
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\nExpenses:");
        for (Expense expense : expenseList) {
            System.out.println(expense);
        }
    }

    private static void updateExpense(Scanner scanner) {
        System.out.print("Enter the ID of the expense to update: ");
        int id = scanner.nextInt();
        Expense expense = findExpenseById(id);

        if (expense == null) {
            System.out.println("Expense not found.");
            return;
        }

        System.out.print("Enter new category: ");
        scanner.nextLine(); // Consume newline
        String category = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new amount: ");
        double amount = scanner.nextDouble();

        expense.setCategory(category);
        expense.setDescription(description);
        expense.setAmount(amount);
        System.out.println("Expense updated successfully!");
    }

    private static void deleteExpense(Scanner scanner) {
        System.out.print("Enter the ID of the expense to delete: ");
        int id = scanner.nextInt();
        Expense expense = findExpenseById(id);

        if (expense == null) {
            System.out.println("Expense not found.");
            return;
        }

        expenseList.remove(expense);
        System.out.println("Expense deleted successfully!");
    }

    private static Expense findExpenseById(int id) {
        for (Expense expense : expenseList) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }

    private static void saveExpenses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(expenseList);
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadExpenses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            expenseList = (List<Expense>) ois.readObject();
            if (!expenseList.isEmpty()) {
                expenseIdCounter = expenseList.get(expenseList.size() - 1).getId() + 1;
            }
            System.out.println("Expenses loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
}
