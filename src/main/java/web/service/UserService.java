package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUser(Long id);

    void addUser(User user);

    void update(User user);

    void remove(Long id);
}
