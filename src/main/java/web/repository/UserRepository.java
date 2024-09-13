package web.repository;

import web.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User getUser(Long id);

    void addUser(User user);

    void update(User user);

    void remove(Long id);
}
