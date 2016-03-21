package app.core.commands.users.create.result;

import app.dto.UserDTO;
import app.dto.UserInfoDTO;

/**
 * Created by Vladislav on 3/21/2016.
 */
public class CreateUserCommandSuccessResult extends CreateUserCommandResult{
    private UserDTO userDTO;

    public CreateUserCommandSuccessResult(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public UserInfoDTO getUserInfoDTO(){
        return new UserInfoDTO(
                userDTO.getLogin(),
                userDTO.getFirstName(),
                userDTO.getLastName());
    }

    @Override
    public boolean isSuccessful() {
        return true;
    }
}
