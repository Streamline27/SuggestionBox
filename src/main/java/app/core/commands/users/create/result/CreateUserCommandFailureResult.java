package app.core.commands.users.create.result;

import app.core.commands.users.create.OperationUnsupportedForFailureResultException;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;

/**
 * Created by Vladislav on 3/21/2016.
 */
public class CreateUserCommandFailureResult extends CreateUserCommandResult
{
    @Override
    public UserDTO getUserDTO() throws OperationUnsupportedForFailureResultException {
        throw new OperationUnsupportedForFailureResultException();
    }

    @Override
    public UserInfoDTO getUserInfoDTO() throws OperationUnsupportedForFailureResultException {
        throw new OperationUnsupportedForFailureResultException();
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }
}
