package homework1.ecommerce.constant;

public interface AppCommand {
  String EXIT = "0";
  String LOGIN = "1";
  String REGISTER = "2";
  String INVALID_COMMAND = "Invalid command";

  static void appCommand() {
    System.out.println("Please enter " + EXIT + " to exit");
    System.out.println("Please enter " + LOGIN + " to login");
    System.out.println("Please enter " + REGISTER + " to register");
  }

}
