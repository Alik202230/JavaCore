package homework1.shop.entity;

import homework1.shop.enums.Category;

import java.util.Objects;

public class Product {
  private int id;
  private String name;
  private double price;
  private Category category;

  public Product(int id, String name, double price, Category category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;
    return id == product.id
        && Double.compare(price, product.price) == 0
        && Objects.equals(name, product.name)
        && category == product.category;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + Objects.hashCode(name);
    result = 31 * result + Double.hashCode(price);
    result = 31 * result + Objects.hashCode(category);
    return result;
  }

  @Override
  public String toString() {
    return "Product[" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", category=" + category +
        ']';
  }
}
