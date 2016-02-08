package app.core.commands.users.create;

import app.core.commands.DomainCommandHandler;
import app.core.database.UserDAO;
import app.core.domain.User;
import app.core.services.DTOConverter;
import app.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 2/8/2016.
 */
@Component
public class CreateUserCommandHandler
        implements DomainCommandHandler<CreateUserCommand, CreateUserResult> {
    @Autowired
    UserDAO userDAO;

    @Autowired
    DTOConverter converter;

    @Override
    public CreateUserResult execute(CreateUserCommand command) {
        User user = new User(command.getLogin(), command.getPassword(), command.getFirstname(), command.getLastname());
        userDAO.create(user);

        UserDTO userDTO = converter.createUserDTO(user);
        return new CreateUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateUserCommand.class;
    }
}
