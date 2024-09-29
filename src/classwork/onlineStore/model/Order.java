package classwork.onlineStore.model;

import classwork.onlineStore.model.enums.OrderStatus;
import classwork.onlineStore.model.enums.PaymentMethod;

import java.util.Date;
import java.util.Objects;

public class Order {
  public String id;
  private User user;
  private Product product;
  private Date date;
  private int quantity;
  private double price;
  private OrderStatus status;
  private PaymentMethod paymentMethod;

  public Order() {}

  public Order (String id, User user, Product product, Date date, int quantity, double price, OrderStatus status, PaymentMethod paymentMethod) {
    this.id = id;
    this.user = user;
    this.product = product;
    this.date = date;
    this.quantity = quantity;
    this.price = price;
    this.status = status;
    this.paymentMethod = paymentMethod;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    Order order = (Order) object;
    return quantity == order.quantity
        && Double.compare(price, order.price) == 0
        && Objects.equals(id, order.id)
        && Objects.equals(user, order.user)
        && Objects.equals(product, order.product)
        && Objects.equals(date, order.date)
        && status == order.status
        && paymentMethod == order.paymentMethod;
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(id);
    result = 31 * result + Objects.hashCode(user);
    result = 31 * result + Objects.hashCode(product);
    result = 31 * result + Objects.hashCode(date);
    result = 31 * result + quantity;
    result = 31 * result + Double.hashCode(price);
    result = 31 * result + Objects.hashCode(status);
    result = 31 * result + Objects.hashCode(paymentMethod);
    return result;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id='" + id + '\'' +
        ", user=" + user +
        ", product=" + product +
        ", date=" + date +
        ", quantity=" + quantity +
        ", price=" + price +
        ", status=" + status +
        ", paymentMethod=" + paymentMethod +
        '}';
  }
}
