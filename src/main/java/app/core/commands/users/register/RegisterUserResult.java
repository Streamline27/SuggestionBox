package app.core.commands.users.register;

import app.core.commands.DomainCommandResult;
import app.dto.UserInfoDTO;

/**
 * Created by Vladislav on 2/8/2016.
 */
public class RegisterUserResult implements DomainCommandResult {
    UserInfoDTO userInfoDTO;

    public RegisterUserResult(UserInfoDTO userDTO) {
        this.userInfoDTO = userInfoDTO;
    }

    public UserInfoDTO getUser() {
        return userInfoDTO;
    }
}

