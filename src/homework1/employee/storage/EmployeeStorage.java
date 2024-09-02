package homework1.employee.storage;

import homework1.employee.entity.Employee;

public class EmployeeStorage {
  private Employee[] employees = new Employee[10];
  private int size;

  public void addEmployee(Employee employee) {
    if (size == employees.length) {
      extend();
    }
    employees[size++] = employee;
  }

  private void extend() {
    Employee[] newEmployees = new Employee[size * 2];
    if (size >= 0) System.arraycopy(employees, 0, newEmployees, 0, size);
    employees = newEmployees;
  }

  public Employee getEmployeeById(String id) {
    for (int i = 0; i < size; i++) {
      Employee employee = employees[i];
      if (employee.getId().equals(id)) {
        return employee;
      }
    }
    return null;
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      Employee employee = employees[i];
      System.out.println(employee);
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void getEmployeeByCompanyName(String company) {
    for (int i = 0; i < size; i++) {
      Employee employee = employees[i];
      if (employee.getCompany().equals(company)) {
        System.out.println(employee);
      }
    }
  }
}
