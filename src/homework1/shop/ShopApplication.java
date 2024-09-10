package homework1.shop;

import homework1.shop.constant.CommandConstant;
import homework1.shop.entity.Order;
import homework1.shop.entity.Product;
import homework1.shop.entity.User;
import homework1.shop.enums.Category;
import homework1.shop.enums.Role;
import homework1.shop.storage.OrderStorage;
import homework1.shop.storage.ProductStorage;
import homework1.shop.storage.UserStorage;

import java.util.Scanner;

public class ShopApplication implements CommandConstant {

  private static final Scanner scanner = new Scanner(System.in);
  private static final UserStorage userStorage = new UserStorage();
  private static final ProductStorage productStorage = new ProductStorage();
  private static final OrderStorage orderStorage = new OrderStorage();

  public static void main(String[] args) {
    boolean run = true;
    while (run) {
      CommandConstant.command();
      String command = scanner.nextLine();
      switch (command) {
        case STOP_PROCESS:
          run = false;
          break;
        case ADD_USER:
          addUser();
          break;
        case ADD_PRODUCT:
          addProduct();
          break;
        case DISPLAY_ALL_USERS:
          userStorage.display();
          break;
        case DISPLAY_ALL_PRODUCTS:
          displayAllProducts();
          break;
        case PLACE_ORDER:
          placeOrder();
          break;
        case DISPLAY_ORDER:
          orderStorage.display();
          break;
        default:
          System.out.println("Invalid command");
      }
    }
  }

  private static void placeOrder() {
    displayAllProducts();
    System.out.println("Please enter user id");
    try {
      int userId = Integer.parseInt(scanner.nextLine());
      User userById = userStorage.getUserById(userId);

      if (userById == null) {
        System.out.println("User not found");
        return;
      }

      System.out.println("Please enter product id");
      String productData = scanner.nextLine();
      String[] productDataArray = productData.split(",");
      Product[] products = new Product[productDataArray.length];
      for (int i = 0; i < productDataArray.length; i++) {
        int productId = Integer.parseInt(productDataArray[i]);
        Product product = productStorage.getProductById(productId);

        if (product == null) {
          System.out.println("Product with ID " + productId + " not found");
          return;
        }
        products[i] = product;
      }

      System.out.println("Please enter order id");
      int orderId = scanner.nextInt();
      Order orderById = orderStorage.getOrderById(orderId);
      if (orderById == null) {
        Order order = new Order(orderId, userById, products, 0);
        orderStorage.add(order);
        userById.setOrder(order);
        System.out.println("Successfully added order");
      } else {
        System.out.println("Order with ID " + orderId + " already exists");
      }

    } catch (NumberFormatException e) {
      System.out.println("Please enter user id");
    }

  }

  private static void displayAllProducts() {
    if (productStorage.isEmpty()) {
      System.out.println("No products found");
    } else {
      productStorage.display();
    }
  }

  private static void addProduct() {
    System.out.println("Please enter user id");
    try {
      int id = Integer.parseInt(scanner.nextLine());
      User userId = userStorage.getUserById(id);

      if (userId == null) {
        System.out.println("User not found");
        return;
      }

      if (userId.getRole() != Role.ADMIN) {
        System.out.println("You are not allowed to add product");
        return;
      }
      System.out.println("Please enter product id, name, price, category");
      String productData = scanner.nextLine();
      String[] productDataArr = productData.split(",");
      int productId = Integer.parseInt(productDataArr[0]);
      Product productById = productStorage.getProductById(id);
      if (productDataArr.length == 4) {
        String productName = productDataArr[1];
        double productPrice = Double.parseDouble(productDataArr[2]);
        Category category = Category.valueOf(productDataArr[3]);
        if (productById == null) {
          Product product = new Product(productId, productName, productPrice, category);
          productStorage.add(product);
          System.out.println("Product added successfully");
        } else {
          System.out.println("Product with id " + productId + " already exists");
        }
      } else {
        System.out.println("All field arr required: Please try again");
      }

    } catch (NumberFormatException e) {
      System.out.println("Please enter a number");
    }
  }

  private static void addUser() {
    System.out.println("Please enter user id, firsName, lastName, age, role");
    String userData = scanner.nextLine();
    String[] userDataArray = userData.split(",");
    try {
      int id = Integer.parseInt(userDataArray[0]);
      User userId = userStorage.getUserById(id);
      if (userDataArray.length == 5) {
        String firsName = userDataArray[1];
        String lastName = userDataArray[2];
        int age = Integer.parseInt(userDataArray[3]);
        Role role = Role.valueOf(userDataArray[4]);
        if (userId == null) {
          User user = new User(id, firsName, lastName, age, role, new Order());
          userStorage.add(user);
          System.out.println("User added successfully");
        } else {
          System.out.println("User already exists");
        }
      } else {
        System.out.println("All field are required: Please try again!");
      }
    } catch (NumberFormatException e) {
      System.out.println("Please enter a number");
    }
  }
}
