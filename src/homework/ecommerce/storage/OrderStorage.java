package homework.ecommerce.storage;

import homework.ecommerce.entity.Order;
import homework.ecommerce.entity.User;

public class OrderStorage {
  private Order[] orders = new Order[10];
  private int size;

  public void add(Order order) {
    if (size == orders.length) {
      extend();
    }
    orders[size++] = order;
  }

  private void extend() {
    Order[] newOrders = new Order[orders.length * 2];
    System.arraycopy(orders, 0, newOrders, 0, orders.length);
    orders = newOrders;
  }

  public Order getOrderById(String orderId) {
    for (int i = 0; i < size; i++) {
      Order order = orders[i];
      if (order.getId().equals(orderId)) {
        return order;
      }
    }
    return null;
  }

  public boolean getOrderByUser(User user) {
    for (int i = 0; i < size; i++) {
      Order order = orders[i];
      if (order.getUser().equals(user)) {
        System.out.println(order);
      }
    }
    return false;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.println(orders[i]);
    }
  }

  public void removeOrderById(String id) {
    int index = getIndex(id);
    if (index != -1) {
      for (int i = index + 1; i < size; i++) {
        orders[i - 1] = orders[i];
      }
      size--;
    }
  }

  private int getIndex(String id) {
    for (int i = 0; i < size; i++) {
      if (orders[i].getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }
}
