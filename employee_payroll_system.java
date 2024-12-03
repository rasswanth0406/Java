import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double basicSalary;

    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double calculateGrossSalary() {
        double hra = basicSalary * 0.20; // 20% of basic salary
        double da = basicSalary * 0.50; // 50% of basic salary
        return basicSalary + hra + da;
    }

    public double calculateNetSalary() {
        double grossSalary = calculateGrossSalary();
        double tax = grossSalary * 0.10; // 10% tax
        return grossSalary - tax;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id +
                "\nName: " + name +
                "\nBasic Salary: " + basicSalary +
                "\nGross Salary: " + calculateGrossSalary() +
                "\nNet Salary: " + calculateNetSalary();
    }
}

public class EmployeePayrollSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Employee Payroll System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Generate Salary Slip");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> generateSalarySlip();
                case 4 -> {
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        Employee employee = new Employee(id, name, basicSalary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("\n===== Employee List =====");
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("------------------------");
        }
    }

    private static void generateSalarySlip() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Employee foundEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                foundEmployee = employee;
                break;
            }
        }

        if (foundEmployee != null) {
            System.out.println("\n===== Salary Slip =====");
            System.out.println(foundEmployee);
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }
}
