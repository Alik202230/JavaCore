package homework1.employee;

import homework1.employee.constant.AppCommand;
import homework1.employee.entity.Employee;
import homework1.employee.storage.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo implements AppCommand {

  private static final EmployeeStorage employeeStorage = new EmployeeStorage();
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    generateRandomEmployee();
    boolean isRunning = true;
    while (isRunning) {
      AppCommand.printCommand();
      String command = scanner.nextLine();
      switch (command) {
        case ZERO:
          isRunning = false;
          break;
        case ONE:
          addEmployee();
          break;
        case TWO:
          employeeStorage.display();
          break;
        case THREE:
          getEmployeeById();
          break;
        case FOUR:
          getEmployeeByCompanyName();
      }

    }

  }

  private static void getEmployeeByCompanyName() {
    System.out.println("Enter company name: ");
    String companyName = scanner.nextLine();
    employeeStorage.getEmployeeByCompanyName(companyName);
  }


  private static void getEmployeeById() {
    System.out.println("Please enter id");
    String employeeId = scanner.nextLine();
    Employee employee = employeeStorage.getEmployeeById(employeeId);
    if (employee == null) {
      System.out.println("Employee with id " + employeeId + " not found");
      return;
    }
    System.out.println(employee);
  }

  private static void addEmployee() {
    System.out.println("Please enter id");
    String id = scanner.nextLine();
    Employee employeeID = employeeStorage.getEmployeeById(id);

    if (employeeID != null) {
      System.out.println("Employee ID: " + employeeID.getId() + " already exist");
    } else {
      System.out.println("Please enter name");
      String name = scanner.nextLine();
      System.out.println("Please enter surname");
      String surname = scanner.nextLine();
      System.out.println("Please enter salary");
      double salary = Double.parseDouble(scanner.nextLine());
      System.out.println("Please enter position");
      String position = scanner.nextLine();
      System.out.println("Please enter company");
      String company = scanner.nextLine();
      Employee employee = new Employee(id, name, surname, salary, position, company);
      employeeStorage.addEmployee(employee);
      System.out.println("Employee added successfully");
    }
  }

  private static void generateRandomEmployee() {
    employeeStorage.addEmployee(new Employee("A001", "Michael", "Moore", 18162, "Support", "Apple"));
    employeeStorage.addEmployee(new Employee("A002", "Sophia", "Davis", 18647, "Logistics", "Intel"));
    employeeStorage.addEmployee(new Employee("A003", "Emily", "Johnson", 12981, "HR", "Samsung"));
    employeeStorage.addEmployee(new Employee("A004", "James", "Jones", 14802, "IT", "Microsoft"));
    employeeStorage.addEmployee(new Employee("A005", "Michael", "Miller", 16902, "Finance", "Google"));
    employeeStorage.addEmployee(new Employee("A006", "Daniel", "Johnson", 17216, "Engineering", "Samsung"));
    employeeStorage.addEmployee(new Employee("A007", "Sophia", "Wilson", 17456, "IT", "Tesla"));
    employeeStorage.addEmployee(new Employee("A008", "James", "Davis", 11145, "Logistics", "IBM"));
    employeeStorage.addEmployee(new Employee("A009", "James", "Johnson", 18899, "HR", "Amazon"));
    employeeStorage.addEmployee(new Employee("A0010", "James", "Williams", 19622, "R&D", "Intel"));

  }

}
