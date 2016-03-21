package app.core.commands.users.create;

import app.core.commands.DomainCommandHandler;
import app.core.commands.users.create.result.CreateUserCommandFailureResult;
import app.core.commands.users.create.result.CreateUserCommandResult;
import app.core.commands.users.create.result.CreateUserCommandSuccessResult;
import app.core.database.UserDAO;
import app.core.domain.User;
import app.core.services.UserPresenceService;
import app.core.services.converters.UserConverter;
import app.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 2/8/2016.
 */
@Component
public class CreateUserCommandHandler
        implements DomainCommandHandler<CreateUserCommand, CreateUserCommandResult> {
    private @Autowired UserDAO userDAO;
    private @Autowired UserConverter converter;
    private @Autowired UserPresenceService userPresenceService;

    @Override
    public CreateUserCommandResult execute(CreateUserCommand command) {
        if (!userWithLoginAlreadyExists(command.getLogin())){
            UserDTO userDTO = createUser(command);
            return new CreateUserCommandSuccessResult(userDTO);
        }
        else return new CreateUserCommandFailureResult();
    }

    private UserDTO createUser(CreateUserCommand command) {
        User user = getUserFromCommand(command);
        userDAO.create(user);
        return converter.toDTO(user);
    }

    private boolean userWithLoginAlreadyExists(String login) {
        return userPresenceService.isPresent(login);
    }

    private User getUserFromCommand(CreateUserCommand command) {
        return new User(
                command.getLogin(),
                command.getPassword(),
                command.getFirstname(),
                command.getLastname()
        );
    }

    @Override
    public Class getCommandType() {
        return CreateUserCommand.class;
    }
}
