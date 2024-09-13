package homework1.medicalcenter.storage;

import homework1.medicalcenter.entity.Doctor;
import homework1.medicalcenter.entity.Patient;

public class PatientStorage {
  private Patient[] patients = new Patient[10];
  private int size;

  public void add(Patient patient) {
    if (size == patients.length) {
      extend();
    }
    patients[size++] = patient;
  }

  private void extend() {
    Patient[] newPatients = new Patient[size * 2];
    System.arraycopy(patients, 0, newPatients, 0, size);
    patients = newPatients;
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.println(patients[i]);
    }
  }

  public Patient findById(String id) {
    for (int i = 0; i < size; i++) {
      if (patients[i].getId().equals(id)) {
        return patients[i];
      }
    }
    return null;
  }

  public void findPatientByDoctor(Doctor doctor) {
    for (int i = 0; i < size; i++) {
      if (patients[i].getDoctor().equals(doctor)) {
        System.out.println(patients[i]);
      }
    }
  }
}
