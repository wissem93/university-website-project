package interfaceentity;

import java.util.List;

import metier.User;

public interface InterfaceUser {
 public void setUser(User u);
 public List<User> getAllUser();
 public User getUserById(int id);
 public void updateUser(User u);
 public void delateUser(User u);
}
