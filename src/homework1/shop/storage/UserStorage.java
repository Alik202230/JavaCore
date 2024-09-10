package homework1.shop.storage;

import homework1.shop.entity.User;

public class UserStorage {

  private User[] users = new User[10];
  private int size;

  public void add(User user) {
    if(size == users.length) {
      extend();
    }
    users[size++] = user;
  }

  private void extend() {
    User[] newUsers = new User[size * 2];
    if (size >= 0) System.arraycopy(users, 0, newUsers, 0, size);
    users = newUsers;
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.println(users[i]);
    }
  }
  
  public User getUserById(int id) {
    for (int i = 0; i < size; i++) {
      User user = users[i];
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }

}
