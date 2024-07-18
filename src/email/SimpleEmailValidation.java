package email;

import java.util.Scanner;

public class SimpleEmailValidation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    User user = new User(1, "Johndoe", "johndoe@gmail.com", "johndoe123", 3);
    boolean isRunning = true;
    while (isRunning) {
      System.out.println("Please enter your email");
      String email = scanner.nextLine();
      System.out.println("Enter your password");
      String password = scanner.nextLine();

      if (email.length() < 3) {
        user.setAttempt(user.getAttempt() - 1);
        if (user.getAttempt() == 0) {
          System.out.println("Your limit is expired please try after 15 minutes");
          break;
        }
        System.out.println("Please enter at least 3 characters");
      } else {
        if (!email.contains("@")) {
          user.setAttempt(user.getAttempt() - 1);
          if (user.getAttempt() == 0) {
            System.out.println("Your limit is expired please try after 15 minutes");
            break;
          }
          System.out.println("Missing @ character");
        } else {
          if (!email.equals(user.getEmail()) || !password.equals(user.getPassword())) {
            user.setAttempt(user.getAttempt() - 1);
            if (user.getAttempt() == 0) {
              System.out.println("Your limit is expired please try after 15 minutes");
              break;
            }
            System.out.println("Invalid email or password");
          } else {
            System.out.println("Welcome " + user.getName() + " to our application");
            isRunning = false;
          }
        }
      }
    }
  }
}
