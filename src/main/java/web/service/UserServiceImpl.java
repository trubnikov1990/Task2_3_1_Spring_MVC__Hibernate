package web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.DAO.UserDaoImpl;
import web.model.User;

@Service
public class UserServiceImpl implements UserService{


  private final UserDao userDao;

  public UserServiceImpl(UserDaoImpl userDao) {
    this.userDao = userDao;
  }

  @Transactional
  @Override
  public void addUser(User user) {
    userDao.add(user);
  }

  @Transactional
  @Override
  public void deleteUser(int id) {
    userDao.delete(id);
  }

  @Transactional
  @Override
  public void updateUser(int id, User user) {
    userDao.update(id, user);
  }

  @Transactional
  @Override
  public User showUser(int id) {
      return userDao.getUserById(id);
  }

  @Transactional(readOnly = true)
  @Override
  public List<User> listUsers() {
    return userDao.getAllUsers();
  }
}
