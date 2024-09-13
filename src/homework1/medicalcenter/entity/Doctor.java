package homework1.medicalcenter.entity;

import java.util.Objects;

public class Doctor extends Person {
  private String profession;

  public Doctor(String id, String name, String surname, String phone, String profession) {
    super(id, name, surname, phone);
    this.profession = profession;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Doctor doctor = (Doctor) o;
    return Objects.equals(profession, doctor.profession);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(profession);
  }

  @Override
  public String toString() {
    return "Doctor{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", phone='" + phone + '\'' +
        ", profession='" + profession + '\'' +
        '}';
  }
}
