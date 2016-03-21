package app.core.commands.users.create.result;

import app.core.commands.DomainCommandResult;
import app.core.commands.users.create.OperationUnsupportedForFailureResultException;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;

/**
 * Created by Vladislav on 2/8/2016.
 */
public abstract class CreateUserCommandResult implements DomainCommandResult {

    public abstract UserDTO getUserDTO() throws OperationUnsupportedForFailureResultException;
    public abstract UserInfoDTO getUserInfoDTO() throws OperationUnsupportedForFailureResultException;
    public abstract boolean isSuccessful();

}

