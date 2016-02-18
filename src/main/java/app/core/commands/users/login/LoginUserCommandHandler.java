package app.core.commands.users.login;

import app.core.commands.DomainCommandHandler;
import app.core.commands.users.UserConverter;
import app.core.database.UserDAO;
import app.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 2/16/2016.
 */
@Component
public class LoginUserCommandHandler
        implements DomainCommandHandler<LoginUserCommand, LoginUserResult> {

    @Autowired UserDAO userDAO;
    @Autowired UserConverter converter;

    @Override
    public LoginUserResult execute(LoginUserCommand command) {

        String login = command.getLogin();
        String password = command.getPassword();

        User user = userDAO.getByLogin(login);

        if (ifNotNull(user)) return getUnsuccessfulLoginUserResult();
        if (credentialsAreAppropriate(login, password, user))
             return getSuccessfulLoginUserResult(user);
        else return getUnsuccessfulLoginUserResult();
    }

    private boolean ifNotNull(User user){
        return user == null;
    }


    private LoginUserResult getUnsuccessfulLoginUserResult() {
        LoginUserResult result = new LoginUserResult();
        result.setUserAuthorizedSuccessfully(false);
        return result;
    }

    private LoginUserResult getSuccessfulLoginUserResult(User user) {
        LoginUserResult result = new LoginUserResult();
        result.setUserAuthorizedSuccessfully(true);
        result.setUserInfoDTO(converter.toUserInfoDTO(user));
        return result;
    }

    private boolean credentialsAreAppropriate(String login, String password, User user) {
        return (login.equals(user.getUsername())&&(password.equals(user.getPassword())));
    }

    @Override
    public Class getCommandType() {
        return LoginUserCommand.class;
    }
}
