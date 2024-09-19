package homework1.ecommerce.storage;

import homework1.ecommerce.entity.User;

public class UserStorage {
  private User[] users = new User[10];
  private int size;

  public void add(User user) {
    if (size == users.length) {
      extend();
    }
    users[size++] = user;
  }

  private void extend() {
    User[] newUsers = new User[users.length * 2];
    System.arraycopy(users, 0, newUsers, 0, users.length);
    users = newUsers;
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.println(users[i]);
    }
  }

  public User getUserById(String id) {
    for (int i = 0; i < size; i++) {
      if (users[i].getId().equals(id)) {
        return users[i];
      }
    }
    return null;
  }

  public User getUserByEmail(String email) {
    for (int i = 0; i < size; i++) {
      if (users[i].getEmail().equals(email)) {
        return users[i];
      }
    }
    return null;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
