package homework.ecommerce.entity;

import homework.ecommerce.entity.enums.Card;
import homework.ecommerce.entity.enums.OrderStatus;
import homework1.medicalcenter.entity.Doctor;

import java.util.Date;
import java.util.Objects;

public class Order extends BaseEntity {

  private User user;
  private Date date;
  private Product product;
  private OrderStatus status;
  private int totalPrice;
  private int quantity;
  private Card card;

  public Order() {}

  public Order(String id,User user, Date date, Product product, OrderStatus status, int totalPrice, int quantity, Card card) {
    super(id);
    this.user = user;
    this.date = date;
    this.product = product;
    this.status = status;
    this.totalPrice = totalPrice;
    this.quantity = quantity;
    this.card = card;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Product getPrice() {
    return product;
  }

  public void setPrice(Product product) {
    this.product = product;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    Order order = (Order) object;
    return totalPrice == order.totalPrice
        && quantity == order.quantity
        && Objects.equals(user, order.user)
        && Objects.equals(date, order.date)
        && Objects.equals(product, order.product)
        && status == order.status
        && card == order.card;
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(user);
    result = 31 * result + Objects.hashCode(date);
    result = 31 * result + Objects.hashCode(product);
    result = 31 * result + Objects.hashCode(status);
    result = 31 * result + totalPrice;
    result = 31 * result + quantity;
    result = 31 * result + Objects.hashCode(card);
    return result;
  }

  @Override
  public String toString() {
    return "Order{" +
        "user=" + user +
        ", date=" + date +
        ", product=" + product +
        ", status=" + status +
        ", totalPrice=" + totalPrice +
        ", quantity=" + quantity +
        ", card=" + card +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
