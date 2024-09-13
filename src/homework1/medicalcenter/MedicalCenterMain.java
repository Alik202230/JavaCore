package homework1.medicalcenter;

import homework1.medicalcenter.constant.MainCommands;
import homework1.medicalcenter.entity.Doctor;
import homework1.medicalcenter.entity.Patient;
import homework1.medicalcenter.storage.DoctorStorage;
import homework1.medicalcenter.storage.PatientStorage;

import java.util.Date;
import java.util.Scanner;

public class MedicalCenterMain implements MainCommands {

  private static final Scanner scanner = new Scanner(System.in);
  private static final DoctorStorage doctorStorage = new DoctorStorage();
  private static final PatientStorage patientStorage = new PatientStorage();

  public static void main(String[] args) {
    boolean process = true;
    while (process) {
      MainCommands.mainCommands();
      String command = scanner.nextLine();
      switch (command) {
        case EXIT_PROCESS -> process = false;
        case ADD_DOCTOR -> addDoctor();
        case PRINT_ALL_DOCTORS -> doctorStorage.display();
        case SEARCH_DOCTOR_BY_PROFESSION -> searchDoctorByProfession();
        case DELETE_DOCTOR_BY_ID -> deleteDoctorById();
        case UPDATE_DOCTOR_BY_ID -> updateDoctorById();
        case ADD_PATIENT -> addPatient();
        case PRINT_ALL_PATIENT_DOCTOR -> printAllPatientByDoctor();
        default -> System.out.println("Invalid command");
      }
    }

  }

  private static void printAllPatientByDoctor() {
    System.out.println("Enter doctor id");
    String doctorId = scanner.nextLine();
    Doctor doctor = doctorStorage.findById(doctorId);

    if (doctor != null) {
      patientStorage.findPatientByDoctor(doctor);
    }
  }

  private static void addPatient() {
    System.out.println("Enter Doctor id");
    String doctorId = scanner.nextLine();
    Doctor doctor = doctorStorage.findById(doctorId);

    if (doctor != null) {
      System.out.println("Enter Patient id, name, surname, phone, doctor");
      String patientData = scanner.nextLine();
      String[] patientDataArray = patientData.split(",");

      String patientId = patientDataArray[0];
      Patient patientById = patientStorage.findById(patientId);

      if (patientById != null) {
        String name = patientDataArray[1];
        String surname = patientDataArray[2];
        String phone = patientDataArray[3];

        Patient patient = new Patient(patientId, name, surname, phone, doctor, new Date());
        patientStorage.add(patient);
        System.out.println("Patient added successfully");
      } else {
        System.out.println("Patient not found");
      }
    } else {
      System.out.println("Patient not found");
    }
  }

  private static void updateDoctorById() {
    System.out.println("Enter doctor id");
    String id = scanner.nextLine();
    Doctor doctor = doctorStorage.findById(id);

    if (doctor != null) {
      System.out.println("Enter doctor name");
      String name = scanner.nextLine();

      System.out.println("Enter doctor surname");
      String surname = scanner.nextLine();

      System.out.println("Enter doctor phone");
      String phone = scanner.nextLine();

      System.out.println("Enter doctor profession");
      String profession = scanner.nextLine();

      if (name != null && !name.isEmpty()) doctor.setName(name);
      if (surname != null && !surname.isEmpty()) doctor.setSurname(surname);
      if (phone != null && !phone.isEmpty()) doctor.setPhone(phone);
      if (profession != null && !profession.isEmpty()) doctor.setProfession(profession);

    } else {
      System.out.println("Doctor not found");
    }

  }

  private static void deleteDoctorById() {
    System.out.println("Enter doctor id");
    String id = scanner.nextLine();
    doctorStorage.deleteById(id);
    System.out.println("Doctor deleted successfully");
  }

  private static void searchDoctorByProfession() {
    System.out.println("Please enter profession");
    String profession = scanner.nextLine();
    doctorStorage.findByProfession(profession);
  }

  private static void addDoctor() {
    System.out.println("Please enter doctor id, name, surname, phone, profession");
    String doctorData = scanner.nextLine();
    String[] doctorDataArray = doctorData.split(",");

    String id = doctorDataArray[0];
    Doctor doctorById = doctorStorage.findById(id);

    String name = doctorDataArray[1];
    String surname = doctorDataArray[2];
    String phone = doctorDataArray[3];
    String profession = doctorDataArray[4];

    if (doctorById == null) {
      Doctor doctor = new Doctor(id, name, surname, phone, profession);
      doctorStorage.add(doctor);
      System.out.println("Doctor added successfully");
    } else {
      System.out.println("Doctor already exists");
    }
  }
}
