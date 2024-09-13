package homework1.medicalcenter.constant;

public interface MainCommands {
  String EXIT_PROCESS = "0";
  String ADD_DOCTOR = "1";
  String PRINT_ALL_DOCTORS = "2";
  String SEARCH_DOCTOR_BY_PROFESSION = "3";
  String DELETE_DOCTOR_BY_ID = "4";
  String UPDATE_DOCTOR_BY_ID = "5";
  String ADD_PATIENT = "6";
  String PRINT_ALL_PATIENT_DOCTOR = "7";
  String PRINT_ALL_PATIENT = "8";

  static void mainCommands() {
    System.out.println("Please enter " + EXIT_PROCESS + " to exit");
    System.out.println("Please enter " + ADD_DOCTOR + " to add doctor");
    System.out.println("Please enter " + PRINT_ALL_DOCTORS + " to print all doctors");
    System.out.println("Please enter " + SEARCH_DOCTOR_BY_PROFESSION + " to search doctor by profession");
    System.out.println("Please enter " + DELETE_DOCTOR_BY_ID + " to delete doctor");
    System.out.println("Please enter " + UPDATE_DOCTOR_BY_ID + " to update doctor");
    System.out.println("Please enter " + ADD_PATIENT + " to add patient");
    System.out.println("Please enter " + PRINT_ALL_PATIENT_DOCTOR + " to print all patient");
    System.out.println("Please enter " + PRINT_ALL_PATIENT + " to print all patient");
  }

}
