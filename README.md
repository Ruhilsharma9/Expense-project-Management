# Expense Management System

## Project Overview
The Expense Management System is a Java-based console application that allows users to manage their daily expenses. The application provides features to add, view, update, and delete expenses, along with persistent data storage using file serialization.

## Features
1. **Add Expense**: Users can add a new expense by providing a category, description, and amount.
2. **View Expenses**: Displays the list of all stored expenses.
3. **Update Expense**: Allows users to update an existing expense by specifying its ID.
4. **Delete Expense**: Users can delete an expense by specifying its ID.
5. **Data Persistence**: Expenses are saved to a file (`expenses.txt`) and loaded automatically when the application starts.

## Technologies Used
- **Java**: Core programming language.
- **File I/O**: Used for reading and writing expenses to a file.
- **Serialization**: Ensures data persistence between application runs.

## Prerequisites
- Java Development Kit (JDK) 8 or higher.
- Any IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).

## How to Run
1. **Clone or Download the Repository**: 
   ```
   git clone https://github.com/your-repo/expense-management-system.git
   ```

2. **Navigate to the Project Directory**:
   ```
   cd expense-management-system
   ```

3. **Compile the Program**:
   ```
   javac ExpenseManagement.java
   ```

4. **Run the Program**:
   ```
   java ExpenseManagement
   ```

## Usage
### Main Menu
After starting the application, you will see the following options:
```
Expense Management System
1. Add Expense
2. View Expenses
3. Update Expense
4. Delete Expense
5. Exit
Choose an option: 
```

### Adding an Expense
- Select option `1`.
- Enter the category, description, and amount of the expense.
- The expense will be added and saved in memory.

### Viewing Expenses
- Select option `2`.
- All stored expenses will be displayed with their details (ID, category, description, and amount).

### Updating an Expense
- Select option `3`.
- Enter the ID of the expense you want to update.
- Provide the new category, description, and amount.
- The expense will be updated.

### Deleting an Expense
- Select option `4`.
- Enter the ID of the expense you want to delete.
- The expense will be removed from the list.

### Exiting the Application
- Select option `5` to save all expenses to the file and exit the program.

## File Structure
- **`ExpenseManagement.java`**: Main program file containing all the application logic.
- **`expenses.txt`**: File used to store serialized expense data.

## Example Interaction
```
Expense Management System
1. Add Expense
2. View Expenses
3. Update Expense
4. Delete Expense
5. Exit
Choose an option: 1

Enter category: Food
Enter description: Lunch
Enter amount: 250
Expense added successfully!

Choose an option: 2

Expenses:
ID: 1, Category: Food, Description: Lunch, Amount: 250.0

Choose an option: 5
Expenses saved successfully.
Exiting... Goodbye!
```

## Error Handling
- If an invalid ID is entered for updating or deleting an expense, the program will display a "Expense not found" message.
- If the `expenses.txt` file is not found during startup, the program will initialize a fresh list of expenses.
- If an error occurs while saving or loading expenses, an appropriate error message will be displayed.

## Future Enhancements
- Implement user authentication for secure access.
- Add search functionality to filter expenses by category or description.
- Develop a graphical user interface (GUI) for improved user experience.

## License
This project is open-source and free to use under the [MIT License](LICENSE).

---

Developed with ❤️ in Java.
