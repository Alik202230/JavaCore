package homework1.employee.constant;

public interface AppCommand {

  String INPUT = "Please enter";
  String EXIT = "exit";
  String ADD_EMPLOYEE = "Add Employee";
  String GET_ALL_EMPLOYEE = "Get All Employee";
  String GET_EMPLOYEE_BY_ID = "Get Employee by ID";
  String GET_EMPLOYEE_BY_COMPANY_NAME = "Get Employee by company name";

  String ZERO = "0";
  String ONE = "1";
  String TWO = "2";
  String THREE = "3";
  String FOUR = "4";

  static void printCommand() {
    System.out.println(INPUT + " " + ZERO + " for " + EXIT);
    System.out.println(INPUT + " " + ONE + " for " + ADD_EMPLOYEE);
    System.out.println(INPUT + " " + TWO + " for " + GET_ALL_EMPLOYEE);
    System.out.println(INPUT + " " + THREE + " for " + GET_EMPLOYEE_BY_ID);
    System.out.println(INPUT + " " + FOUR + " for " + GET_EMPLOYEE_BY_COMPANY_NAME);

  }

}
