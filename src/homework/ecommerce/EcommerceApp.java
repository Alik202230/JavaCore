package homework.ecommerce;

import homework.ecommerce.constant.AdminCommand;
import homework.ecommerce.constant.AppCommand;
import homework.ecommerce.constant.UserCommand;
import homework.ecommerce.entity.Order;
import homework.ecommerce.entity.Product;
import homework.ecommerce.entity.User;
import homework.ecommerce.entity.enums.Card;
import homework.ecommerce.entity.enums.OrderStatus;
import homework.ecommerce.entity.enums.Role;
import homework.ecommerce.entity.enums.Type;
import homework.ecommerce.exception.*;
import homework.ecommerce.storage.OrderStorage;
import homework.ecommerce.storage.ProductStorage;
import homework.ecommerce.storage.UserStorage;

import java.util.Date;
import java.util.Scanner;

public class EcommerceApp implements AppCommand, UserCommand, AdminCommand {

  private static final Scanner scanner = new Scanner(System.in);
  private static final UserStorage userStorage = new UserStorage();
  private static final ProductStorage productStorage = new ProductStorage();
  private static final OrderStorage orderStorage = new OrderStorage();

  public static void main(String[] args) {
    boolean isRunning = true;
    while (isRunning) {
      AppCommand.appCommand();
      String command = scanner.nextLine();
      switch (command) {
        case EXIT -> isRunning = false;
        case LOGIN -> login();
        case REGISTER -> register();
        default -> System.out.println(INVALID_COMMAND);
      }
    }

  }


  //                          REGISTRATION SECTION

  /****************************************************************************/

  private static void register() {
    System.out.println("Please enter user id, name, email, password, role");
    String userData = scanner.nextLine();
    String[] userDataArray = userData.split(",");

    if (userDataArray.length == 5) {
      String userId = userDataArray[0];
      User id = userStorage.getUserById(userId);
      if (id == null) {
        String name = userDataArray[1];
        String email = userDataArray[2];
        String password = userDataArray[3];
        Role role = Role.valueOf(userDataArray[4]);
        User user = new User(userId, name, email, password, role);
        userStorage.add(user);
        System.out.println("User " + userId + " registered successfully");
      } else {
        throw new UserAlreadyExistsException("User " + userId + " already exists");
      }
    } else {
      throw new FormValidationException("Error: All fields are required");
    }

  }

  private static void login() {
    System.out.println("Please enter email and password");
    String loginAndPassword = scanner.nextLine();
    String[] loginAndPasswordArray = loginAndPassword.split(",");

    if (loginAndPasswordArray.length == 2) {
      String email = loginAndPasswordArray[0];
      User user = userStorage.getUserByEmail(email);
      if (user != null) {
        if (user.getRole() == Role.ADMIN) {
          adminDashBoard();
        } else {
          userDashBoard(user);
        }
      } else {
        throw new UserNotFoundException("User not found");
      }
    } else {
      throw new FormValidationException("Error: All fields are required");
    }
  }



  //                            USER SECTION

  /****************************************************************************/


  private static void userDashBoard(User user) {
    System.out.println("Welcome " + user.getName() + " to our website");
    boolean isUser = true;
    while (isUser) {
      UserCommand.userCommand();
      String command = scanner.nextLine();
      switch (command) {
        case UserCommand.LOGOUT -> {
          isUser = false;
          System.out.println("You are logged out");
        }
        case PRINT_ALL_PRODUCTS -> printAllProducts();
        case BUY_PRODUCT -> buyProduct(user);
        case PRINT_MY_ORDERS -> printOrders(user);
        case CANCEL_ORDER_BY_ID -> cancelOrderById(user);
        default -> System.out.println(INVALID_COMMAND);
      }
    }
  }

  private static void cancelOrderById(User user) {
    printAllOrders();
    System.out.println("Please enter order id");
    String id = scanner.nextLine();
    Order orderId = orderStorage.getOrderById(id);

    if (orderId == null) {
      throw new OrderNotFoundException("Order not found");
    }

    if (orderStorage.getOrderByUser(user)) {
      throw new AccessDeniedException("You are not allowed to cancelled this order");
    }

    orderId.setStatus(OrderStatus.CANCELLED);
    System.out.println("Order cancelled successfully");
  }

  private static void printOrders(User user) {
    orderStorage.getOrderByUser(user);
  }

  private static void buyProduct(User user) {
    System.out.println("Please enter product id");
    String productId = scanner.nextLine();
    Product product = productStorage.getProductById(productId);

    if (product.getQuantity() == 0) {
      throw new OutOfStockException("Out of stock");
    }

    System.out.println("Please enter order id");
    String id = scanner.nextLine();
    Order orderId = orderStorage.getOrderById(id);


    System.out.println("Please enter quantity");
    int quantity = Integer.parseInt(scanner.nextLine());
    int totalPrice = (int) (quantity * product.getPrice());

    System.out.println("Please chose card type");
    Card cardType = Card.valueOf(scanner.nextLine());

    System.out.println("Do you want to buy product " +
        product.getName() + " with quantity is " +
        product.getQuantity() + " by card " +
        cardType + " ? (Y/N)"
    );
    String question = scanner.nextLine().toLowerCase();

    if (question.equals("y")) {
      if (orderId == null) {
        Order order = new Order(id, user, new Date(), product, OrderStatus.NEW, totalPrice, quantity, cardType);
        product.setQuantity(product.getQuantity() - 1);
        orderStorage.add(order);
        System.out.println("Order placed successfully");
      }
    }

  }


  //                            ADMIN SECTION

  /****************************************************************************/


  private static void adminDashBoard() {
    System.out.println("Welcome to admin dashboard");
    boolean isAdmin = true;
    while (isAdmin) {
      AdminCommand.adminCommand();
      String command = scanner.nextLine();
      switch (command) {
        case AdminCommand.LOGOUT -> {
          isAdmin = false;
          System.out.println("You are logged out");
        }
        case ADD_PRODUCT -> addProduct();
        case REMOVE_PRODUCT_BY_ID -> removeProductById();
        case PRINT_PRODUCTS -> printAllProducts();
        case PRINT_USERS -> printAllUsers();
        case PRINT_ORDERS -> printAllOrders();
        case CHANGE_ORDER_STATUS -> changeOrderStatus();
        default -> System.out.println(INVALID_COMMAND);
      }
    }
  }


  private static void changeOrderStatus() {
    printAllOrders();
    System.out.println("Please enter order id");
    String orderId = scanner.nextLine();
    Order order = orderStorage.getOrderById(orderId);
    if (order == null) {
      System.out.println("Order not found");
      return;
    }

    System.out.println("Please enter order status");
    OrderStatus orderStatus = OrderStatus.valueOf(scanner.nextLine());

    if (order.getStatus() == OrderStatus.NEW) {
      order.setStatus(orderStatus);
    }
  }

  private static void printAllOrders() {
    if (!orderStorage.isEmpty()) {
      throw new OrderNotFoundException("Order not found");
    } else {
      orderStorage.print();
    }
  }

  private static void printAllUsers() {
    if (userStorage.isEmpty()) {
      throw new UserNotFoundException("User not found");
    } else {
      userStorage.print();
    }
  }

  private static void printAllProducts() {
    if (!productStorage.isEmpty()) {
      productStorage.print();
    } else {
      throw new ProductNotFoundException("Product not found");
    }
  }

  private static void removeProductById() {
    System.out.println("Please enter product id for removal");
    String productId = scanner.nextLine();
    productStorage.removeProductById(productId);
  }

  private static void addProduct() {
    System.out.println("Please enter product id, name, description, price, quantity, cart type");
    String productData = scanner.nextLine();
    String[] productDataArray = productData.split(",");

    if (productDataArray.length == 6) {
      String productId = productDataArray[0];
      Product id = productStorage.getProductById(productId);

      if (id == null) {
        String name = productDataArray[1];
        String description = productDataArray[2];
        Double price = Double.parseDouble(productDataArray[3]);
        int quantity = Integer.parseInt(productDataArray[4]);
        Type type = Type.valueOf(productDataArray[5]);
        Product product = new Product(productId, name, description, price, quantity, type);
        productStorage.add(product);
        System.out.println("Product " + productId + " added successfully");
      } else {
        throw new ProductAlreadyExistsException("Product " + productId + " already exists");
      }
    } else {
      throw new FormValidationException("Error: All fields are required");
    }
  }
}
