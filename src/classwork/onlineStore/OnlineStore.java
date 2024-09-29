package classwork.onlineStore;

import classwork.onlineStore.model.Order;
import classwork.onlineStore.model.Product;
import classwork.onlineStore.model.User;
import classwork.onlineStore.model.enums.OrderStatus;
import classwork.onlineStore.model.enums.PaymentMethod;
import classwork.onlineStore.model.enums.ProductType;
import classwork.onlineStore.model.enums.Role;
import classwork.onlineStore.storage.DataStore;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OnlineStore {

  private static final Scanner scanner = new Scanner(System.in);
  private static final DataStore storage = new DataStore();
  private static User currentUser;

  public static void main(String[] args) {
    boolean isRune = true;

    while (isRune) {
      printCommands();
      String command = scanner.nextLine();
      switch (command) {
        case "0":
          isRune = false;
          break;
        case "1":
          loginUser();
          break;
        case "2":
          registerUser();
          break;
        default:
          System.out.println("Invalid command");

      }
    }

  }

  private static void loginUser() {
    System.out.println("Please enter email and password");
    String userData = scanner.nextLine();
    String[] userDataArray = userData.split(",");
    String email = userDataArray[0];
    String password = userDataArray[1];

    User userByEmail = storage.getUserByEmail(email);

    if (userByEmail != null && userByEmail.getPassword().equals(password)) {
      currentUser = userByEmail;
      if (userByEmail.getRole() == Role.USER) {
        userDashboard();
      } else {
        adminDashboard();
      }
    }

  }

  private static void userDashboard() {
    boolean isRun = true;
    while (isRun) {
      printUserCommands();
      String command = scanner.nextLine();
      switch (command) {
        case "0":
          currentUser = null;
          isRun = false;
          break;
        case "1":
          storage.printProducts();
          break;
        case "2":
          buyProduct();
          break;
        case "3":
          System.out.println(storage.getOrdersByUser(currentUser));
          break;
        case "4":
          cancelOrderById();
          break;
        default:
          System.out.println("Invalid command");
      }
    }

  }

  private static void cancelOrderById() {
    storage.getOrdersByUser(currentUser);
    System.out.println("Please enter order id");
    String orderId = scanner.nextLine();
    Order order = storage.getOrderById(orderId);

    if (order != null && order.getUser().equals(currentUser)) {
      order.setStatus(OrderStatus.CANCELLED);
      System.out.println("Order cancelled successfully");
    } else {
      System.out.println("Invalid order id");
    }

  }

  private static void buyProduct() {
    storage.printProducts();
    System.out.println("Please enter product id");
    String productId = scanner.nextLine();
    Product productById = storage.getProductById(productId);

    if(productById != null && productById.getQuantity() > 0) {
      System.out.println("Please enter quantity, payment method (CARD, CASH, PAYPAL)");
      String orderDetails = scanner.nextLine();
      String[] orderDetailsArray = orderDetails.split(",");

      Order order = new Order();
      order.setId("ID = " + new Random().nextInt(15000));
      order.setProduct(productById);
      order.setQuantity(Integer.parseInt(orderDetailsArray[0]));
      order.setDate(new Date());
      order.setUser(currentUser);
      order.setPaymentMethod(PaymentMethod.valueOf(orderDetailsArray[1]));
      order.setPrice(order.getQuantity() * productById.getPrice());
      order.setStatus(OrderStatus.NEW);
      storage.addOrder(order);
    }

  }

  private static void adminDashboard() {
    boolean isRun = true;
    while (isRun) {
      printAdminCommands();
      String command = scanner.nextLine();
      switch (command) {
        case "0":
          currentUser = null;
          isRun = false;
          break;
        case "1":
          addProduct();
          break;
        case "2":
          removeProduct();
          break;
        case "3":
          storage.printProducts();
          break;
        case "4":
          storage.printUsers();
          break;
        case "5":
          storage.printOrders();
          break;
        case "6":
          changeOrderStatus();
          break;
        default:
          System.out.println("Invalid command");
      }
    }
  }

  private static void changeOrderStatus() {
    storage.printOrders();
    System.out.println("Please choose order id");
    String id = scanner.nextLine();
    Order orderId = storage.getOrderById(id);

    if (orderId != null) {
      System.out.println("Please enter new order status (NEW, DELIVERED, CANCELED)");
      String newOrderStatus = scanner.nextLine();
      OrderStatus orderStatus = OrderStatus.valueOf(newOrderStatus.toUpperCase());

      if (orderStatus == OrderStatus.DELIVERED) {
        Product product = orderId.getProduct();
        if (product.getQuantity() < orderId.getQuantity()) {
          System.out.println("Product quantity less then order's quantity");
          return;
        }
        product.setQuantity(product.getQuantity() - orderId.getQuantity());
        orderId.setStatus(OrderStatus.DELIVERED);
        System.out.println("Order status has been updated");
      } else {
        orderId.setStatus(orderStatus);
        System.out.println("Order status has been updated");
      }
    }
  }

  private static void removeProduct() {
  }

  private static void addProduct() {
    System.out.println("Please enter id, name, description, price, quantity, type (ELECTRONICS, BOOKS, CLOTHES)");
    String productData = scanner.nextLine();
    String[] productDataArray = productData.split(",");

    String id = productDataArray[0];
    String name = productDataArray[1];
    String description = productDataArray[2];
    double price = Double.parseDouble(productDataArray[3]);
    int quantity = Integer.parseInt(productDataArray[4]);
    ProductType type = ProductType.valueOf(productDataArray[5]);

    Product product = new Product(id, name, description, price, quantity, type);

    storage.addProduct(product);
    System.out.println("Product added successfully");

  }

  private static void registerUser() {
    System.out.println("Please enter user id, name, surname, email, password, role (USER / ADMIN)");
    String userData = scanner.nextLine();
    String[] userDataArray = userData.split(",");

    String email = userDataArray[3];

    if (storage.getUserByEmail(email) == null) {
      User user = new User(
          userDataArray[0],
          userDataArray[1],
          userDataArray[2],
          userDataArray[3],
          userDataArray[4],
          Role.valueOf(userDataArray[5])
      );
      storage.addUser(user);
      System.out.println("User added successfully");
    } else {
      System.out.println("User already exists with this email: " + email);
    }

  }

  private static void printAdminCommands() {
    System.out.println("Please enter 0 for logout");
    System.out.println("Please enter 1 for add product");
    System.out.println("Please enter 2 for remove product");
    System.out.println("Please enter 3 for print all products");
    System.out.println("Please enter 4 for print all users");
    System.out.println("Please enter 5 for print all orders");
    System.out.println("PLease enter 6 for change order status");
  }

  private static void printUserCommands() {
    System.out.println("Please enter 0 for logout");
    System.out.println("Please enter 1 for print all products");
    System.out.println("Please enter 2 for buy product");
    System.out.println("Please enter 4 for print my orders");
    System.out.println("Please enter 5 for cancel order by id");
  }

  private static void printCommands() {
    System.out.println("Please enter 0 for exit");
    System.out.println("Please enter 1 for login");
    System.out.println("Please enter 2 for register");
  }
}
