package classwork.onlineStore.model;

import classwork.onlineStore.model.enums.ProductType;

import java.util.Objects;

public class Product {
  private String id;
  private String name;
  private String description;
  private double price;
  private int quantity;
  private ProductType productType;

  public Product(String id, String description, String name, double price, int quantity, ProductType productType) {
    this.id = id;
    this.description = description;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.productType = productType;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    Product product = (Product) object;
    return Double.compare(price, product.price) == 0
        && quantity == product.quantity && Objects.equals(id, product.id)
        && Objects.equals(name, product.name)
        && Objects.equals(description, product.description)
        && productType == product.productType;
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(id);
    result = 31 * result + Objects.hashCode(name);
    result = 31 * result + Objects.hashCode(description);
    result = 31 * result + Double.hashCode(price);
    result = 31 * result + quantity;
    result = 31 * result + Objects.hashCode(productType);
    return result;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", quantity=" + quantity +
        ", productType=" + productType +
        '}';
  }
}
