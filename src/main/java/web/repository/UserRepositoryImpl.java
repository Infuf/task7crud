package web.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<User> getAll() {
        String jpql = "SELECT u FROM User u";
        return manager.createQuery(jpql, User.class).getResultList();
    }

    public User getUser(Long id) {
        return manager.find(User.class, id);
    }

    public void addUser(User user) {
        if (user.id != null) {
            throw new RuntimeException("user id must be null");
        }
        manager.persist(user);
    }

    public void update(User user) {
        if (user.id == null) {
            throw new RuntimeException("user id is NULL");
        }
        manager.merge(user);
    }

    public void remove(Long id) {
        User user = manager.find(User.class, id);
        if (user != null) {
            manager.remove(user);
        }
    }
}
