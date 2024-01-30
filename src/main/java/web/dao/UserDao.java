package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);
    List<User> getAll();
    Optional<User> find(long id);
    void update(long id, User user);
    void remove(long id);
}
