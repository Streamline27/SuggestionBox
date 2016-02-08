package app.core.database;

import app.core.domain.User;

import java.util.List;

/**
 * Created by Vladislav on 2/8/2016.
 */
public interface UserDAO {
    void create(User user);
    void update(User user);
    void delete(User user);
    User getById(Long id);
    User getByLogin(String login);

    List<User> getAll();

}
