package app.core.commands.users.create;

import app.core.commands.DomainCommandHandler;
import app.core.commands.users.create.result.CreateUserCommandResult;
import app.core.database.UserDAO;
import app.core.domain.User;
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

    @Override
    public CreateUserCommandResult execute(CreateUserCommand command) {
        User user = new User(
                command.getLogin(),
                command.getPassword(),
                command.getFirstname(),
                command.getLastname()
        );

        userDAO.create(user);

        UserDTO userDTO = converter.toDTO(user);
        return new CreateUserCommandResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateUserCommand.class;
    }
}
