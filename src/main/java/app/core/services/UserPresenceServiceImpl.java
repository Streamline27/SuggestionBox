package app.core.services;

import app.core.database.UserDAO;
import app.core.services.UserPresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 3/21/2016.
 */
@Component
public class UserPresenceServiceImpl implements UserPresenceService {
    @Autowired UserDAO userDAO;

    @Override
    public boolean isPresent(String login) {
        return (userDAO.getByLogin(login)!=null);
    }
}
