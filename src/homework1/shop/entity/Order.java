package homework1.shop.entity;

import java.util.Arrays;
import java.util.Objects;

public class Order {
  private int id;
  private User user;
  private Product[] products;
  private double totalPrice;

  public Order() {}

  public Order(int id, User user, Product[] products, double totalPrice) {
    this.id = id;
    this.user = user;
    this.products = products;
    this.totalPrice = totalPrice;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Order order = (Order) o;
    return id == order.id && Double.compare(totalPrice, order.totalPrice) == 0 && Objects.equals(user, order.user) && Arrays.equals(products, order.products);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + Objects.hashCode(user);
    result = 31 * result + Arrays.hashCode(products);
    result = 31 * result + Double.hashCode(totalPrice);
    return result;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", user=" + user +
        ", products=" + Arrays.toString(products) +
        ", totalPrice=" + totalPrice +
        '}';
  }
}
