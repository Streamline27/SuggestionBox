package app.core.services;

import app.core.database.UserDAO;
import app.core.domain.User;
import app.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 2/17/2016.
 */
@Component
public class UserFactoryImpl implements UserFactory {
    @Autowired
    UserDAO userDAO;

    @Override
    public void createUser(User user) {
        userDAO.create(user);
    }


}
