package web.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public class UserDaoImpl implements UserDao{

  @PersistenceContext
  private EntityManager entityManager;


  @Override
  public void add(User user) {
    entityManager.persist(user);
  }

  @Override
  public void delete(int id) {
    entityManager.remove(entityManager.find(User.class, id));
  }

  @Override
  public void update(int id, User user) {
    entityManager.detach(entityManager.find(User.class, id));
    entityManager.merge(user);
  }

  public User getUserById (int id) {
    return entityManager.find(User.class , id);
  }

  @Override
  public List<User> getAllUsers() {
    return entityManager.createQuery("select user from User user", User.class).getResultList();
  }
}
