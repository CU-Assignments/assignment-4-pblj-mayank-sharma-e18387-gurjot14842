import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2: // Update Employee
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter new Name: ");
                            emp.name = scanner.nextLine();
                            System.out.print("Enter new Salary: ");
                            emp.salary = scanner.nextDouble();
                            System.out.println("Employee details updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee with ID " + updateId + " not found.");
                    }
                    break;

                case 3: // Remove Employee
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    found = false;
                    for (Employee emp : employees) {
                        if (emp.id == removeId) {
                            employees.remove(emp);
                            System.out.println("Employee removed successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee with ID " + removeId + " not found.");
                    }
                    break;

                case 4: // Search Employee
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    found = false;
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println(emp);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee with ID " + searchId + " not found.");
                    }
                    break;

                case 5: // Display All Employees
                    if (employees.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("\nEmployee List:");
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
