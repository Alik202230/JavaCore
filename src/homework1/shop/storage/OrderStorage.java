package homework1.shop.storage;

import homework1.shop.entity.Order;

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

  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.println(orders[i]);
    }
  }

  public Order getOrderById(int id) {
    for (int i = 0; i < size; i++) {
      if (orders[i].getId() == id) {
        return orders[i];
      }
    }
    return null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
