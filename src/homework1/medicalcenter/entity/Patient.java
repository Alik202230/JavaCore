package homework1.medicalcenter.entity;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person{
  private Doctor doctor;
  private Date registerDate;

  public Patient(String id, String name, String surname, String phone, Doctor doctor, Date registerDate) {
    super(id, name, surname, phone);
    this.doctor = doctor;
    this.registerDate = registerDate;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Date getRegusterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date regusterDate) {
    this.registerDate = registerDate;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    Patient patient = (Patient) object;
    return Objects.equals(doctor, patient.doctor) && Objects.equals(registerDate, patient.registerDate);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(doctor);
    result = 31 * result + Objects.hashCode(registerDate);
    return result;
  }

  @Override
  public String toString() {
    return "Patient{" +
        "doctor=" + doctor +
        ", registerDate=" + registerDate +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
