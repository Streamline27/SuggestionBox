package app.core.commands.users.login;

import app.core.commands.DomainCommandResult;
import app.dto.UserInfoDTO;

/**
 * Created by Vladislav on 2/16/2016.
 */
public class LoginUserResult implements DomainCommandResult {
    private boolean userAuthorizedSuccessfully;
    private UserInfoDTO userInfoDTO;

    public LoginUserResult() {
    }

    public UserInfoDTO getUserInfoDTO() {
        return userInfoDTO;
    }

    public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
        this.userInfoDTO = userInfoDTO;
    }

    public boolean isUserAuthorizedSuccessfully() {
        return userAuthorizedSuccessfully;
    }

    public void setUserAuthorizedSuccessfully(boolean userAuthorizedSuccessfully) {
        this.userAuthorizedSuccessfully = userAuthorizedSuccessfully;
    }
}
