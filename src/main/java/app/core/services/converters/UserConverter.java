package app.core.services.converters;

import app.core.database.UserDAO;
import app.core.domain.User;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 2/18/2016.
 */
@Component
public class UserConverter {
    @Autowired
    UserDAO userDAO;

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    public UserInfoDTO toUserInfoDTO(User user) {
        return new UserInfoDTO(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
