package homework.ecommerce.constant;

public interface AdminCommand {
  String LOGOUT = "0";
  String ADD_PRODUCT = "1";
  String REMOVE_PRODUCT_BY_ID = "2";
  String PRINT_PRODUCTS = "3";
  String PRINT_USERS = "4";
  String PRINT_ORDERS = "5";
  String CHANGE_ORDER_STATUS = "6";


  static void adminCommand() {
    System.out.println("Please enter " + LOGOUT + " to log out");
    System.out.println("Please enter " + ADD_PRODUCT + " to add product");
    System.out.println("Please enter " + REMOVE_PRODUCT_BY_ID + " to remove product");
    System.out.println("Please enter " + PRINT_PRODUCTS + " to print products");
    System.out.println("Please enter " + PRINT_USERS + " to print users");
    System.out.println("Please enter " + PRINT_ORDERS + " to print orders");
    System.out.println("Please enter " + CHANGE_ORDER_STATUS + " to change order status");
  }

}
