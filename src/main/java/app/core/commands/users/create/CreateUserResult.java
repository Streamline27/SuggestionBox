package app.core.commands.users.create;

import app.core.commands.DomainCommandResult;
import app.dto.UserDTO;

/**
 * Created by Vladislav on 2/8/2016.
 */
public class CreateUserResult implements DomainCommandResult {
    UserDTO userDTO;

    public CreateUserResult(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUser() {
        return userDTO;
    }
}

