package web.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import web.entity.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getUser(Long id) {
        return repository.getUser(id);
    }

    @Override
    public void addUser(User user) {
        repository.addUser(user);
    }

    @Override
    public void update(User user) {
        repository.update(user);
    }

    @Override
    public void remove(Long id) {
        repository.remove(id);

    }
}
