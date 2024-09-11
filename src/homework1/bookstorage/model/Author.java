package homework1.bookstorage.model;

import java.util.Objects;

public class Author {
  private String id;
  private String name;
  private String surname;
  private String phone;
  private int age;

  public Author(String id, String name, String surname, String phone, int age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phone = phone;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return age == author.age && Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(surname, author.surname) && Objects.equals(phone, author.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, phone, age);
  }

  @Override
  public String toString() {
    return "Author{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", phone='" + phone + '\'' +
        ", age=" + age +
        '}';
  }
}
