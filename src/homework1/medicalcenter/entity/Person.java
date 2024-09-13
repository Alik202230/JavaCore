package homework1.medicalcenter.entity;

public abstract class Person {
  protected String id;
  protected String name;
  protected String surname;
  protected String phone;

  public Person(String id, String name, String surname, String phone) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phone = phone;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
