package web.DAO;

import java.util.List;
import web.model.User;

public interface UserDao {

  void add(User user);

  void delete (int id);

  void update (int id, User user);

  List<User> showUsers();

}
