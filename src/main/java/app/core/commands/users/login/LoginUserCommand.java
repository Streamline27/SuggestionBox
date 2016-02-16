package app.core.commands.users.login;

import app.core.commands.DomainCommand;
import app.core.commands.DomainCommandResult;

/**
 * Created by Vladislav on 2/16/2016.
 */
public class LoginUserCommand implements DomainCommand<LoginUserResult>{
    String login;
    String password;

    public LoginUserCommand(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
