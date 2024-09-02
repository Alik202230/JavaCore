package homework1.employee.entity;

import java.util.Objects;

public class Employee {

  private String id;
  private String name;
  private String surname;
  private double salary;
  private String position;
  private String company;

  public Employee(String id, String name, String surname, double salary, String position, String company) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.salary = salary;
    this.position = position;
    this.company = company;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Double.compare(salary, employee.salary) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(position, employee.position) && Objects.equals(company, employee.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, salary, position, company);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", salary=" + salary +
        ", position='" + position + '\'' +
        ", company=" + company +
        '}';
  }
}
