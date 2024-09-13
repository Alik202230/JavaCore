package homework1.medicalcenter.storage;

import homework1.medicalcenter.entity.Doctor;

public class DoctorStorage {

  private Doctor[] doctors = new Doctor[10];
  private int size;


  public void add(Doctor doctor) {
    if (size == doctors.length) {
      extend();
    }
    doctors[size++] = doctor;
  }

  public Doctor findById(String id) {
    for (int i = 0; i < size; i++) {
      if (doctors[i].getId().equals(id)) {
        return doctors[i];
      }
    }
    return null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void extend() {
    Doctor[] newDoctor = new Doctor[doctors.length * 2];
    if (size >= 0) System.arraycopy(doctors, 0, newDoctor, 0, size);
    doctors = newDoctor;
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.println(doctors[i]);
    }
  }

  public void findByProfession(String profession) {
    for (int i = 0; i < size; i++) {
      if (doctors[i].getProfession().equals(profession)) {
        System.out.println(doctors[i]);
      }
    }
  }


  public void deleteById(String id) {
    int index = getIndex(id);
    for (int i = index + 1; i < size; i++) {
      if (doctors[i].getId().equals(id)) {
        doctors[i - 1] = doctors[i];
      }
    }
    size--;
  }

  private int getIndex(String id) {
    for (int i = 0; i < size; i++) {
      if (doctors[i].getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }

}
