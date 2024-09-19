package homework.ecommerce.entity;

import homework.ecommerce.entity.enums.Role;

import java.util.Objects;

public class User extends BaseEntity {

  private String email;
  private String password;
  private Role role;

  public User() {}

  public User(String id, String name, String email, String password, Role role) {
    super(id, name);
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    User user = (User) object;
    return Objects.equals(email, user.email)
        && Objects.equals(password, user.password)
        && role == user.role;
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(email);
    result = 31 * result + Objects.hashCode(password);
    result = 31 * result + Objects.hashCode(role);
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", role=" + role +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
