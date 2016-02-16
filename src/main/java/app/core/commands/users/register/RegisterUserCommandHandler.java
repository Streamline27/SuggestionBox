package app.core.commands.users.register;

import app.core.commands.DomainCommandHandler;
import app.core.database.UserDAO;
import app.core.domain.User;
import app.core.services.DTOConverter;
import app.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 2/8/2016.
 */
@Component
public class RegisterUserCommandHandler
        implements DomainCommandHandler<RegisterUserCommand, RegisterUserResult> {
    @Autowired
    UserDAO userDAO;

    @Autowired
    DTOConverter converter;

    @Override
    public RegisterUserResult execute(RegisterUserCommand command) {
        User user = new User(
                command.getLogin(),
                command.getPassword(),
                command.getFirstname(),
                command.getLastname()
        );

        userDAO.create(user);

        UserInfoDTO userDTO = converter.createUserInfoDTO(user);
        return new RegisterUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return RegisterUserCommand.class;
    }
}