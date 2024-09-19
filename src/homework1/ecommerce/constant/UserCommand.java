package homework1.ecommerce.constant;

public interface UserCommand {
  String LOGOUT = "0";
  String PRINT_ALL_PRODUCTS = "1";
  String BUY_PRODUCT = "2";
  String PRINT_MY_ORDERS = "3";
  String CANCEL_ORDER_BY_ID = "4";

  static void userCommand() {
    System.out.println("Please enter " + LOGOUT + " to log out");
    System.out.println("Please enter " + PRINT_ALL_PRODUCTS + " to print all products");
    System.out.println("Please enter " + BUY_PRODUCT + " to buy");
    System.out.println("Please enter " + PRINT_MY_ORDERS + " to print my orders");
    System.out.println("Please enter " + CANCEL_ORDER_BY_ID + " to cancel order");
  }

}
