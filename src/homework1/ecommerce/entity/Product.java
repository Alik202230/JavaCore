package homework1.ecommerce.entity;

import homework1.ecommerce.entity.enums.Type;

import java.util.Objects;

public class Product extends BaseEntity {

  private String description;
  private Double price;
  private int quantity;
  private Type type;


  public Product(String id, String name, String description, Double price, int quantity, Type type) {
    super(id, name);
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object object) {

    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    Product product = (Product) object;
    return quantity == product.quantity
        && Objects.equals(description, product.description)
        && Objects.equals(price, product.price)
        && type == product.type;
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(description);
    result = 31 * result + Objects.hashCode(price);
    result = 31 * result + quantity;
    result = 31 * result + Objects.hashCode(type);
    return result;
  }

  @Override
  public String toString() {
    return "Product{" +
        "description='" + description + '\'' +
        ", price=" + price +
        ", type=" + type +
        ", quantity=" + quantity +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
