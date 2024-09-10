package homework1.shop.constant;

public interface CommandConstant {

  String STOP_PROCESS = "0";
  String ADD_USER = "1";
  String ADD_PRODUCT = "2";
  String DISPLAY_ALL_USERS = "3";
  String DISPLAY_ALL_PRODUCTS = "4";
  String PLACE_ORDER = "5";
  String DISPLAY_ORDER = "6";

  static void command() {
    System.out.println("Please enter " + STOP_PROCESS + " to stop process");
    System.out.println("Please enter " + ADD_USER + " to add user");
    System.out.println("Please enter " + ADD_PRODUCT + " to add product");
    System.out.println("Please enter " + DISPLAY_ALL_USERS + " to display all users");
    System.out.println("Please enter " + DISPLAY_ALL_PRODUCTS + " to display all products");
    System.out.println("Please enter " + PLACE_ORDER + " to place order");
    System.out.println("Please enter " + DISPLAY_ORDER + " to display order");
  }

}
