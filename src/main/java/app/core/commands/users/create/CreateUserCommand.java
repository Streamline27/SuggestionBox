package app.core.commands.users.create;

import app.core.commands.DomainCommand;
import app.core.commands.users.create.result.CreateUserCommandResult;

/**
 * Created by Vladislav on 2/8/2016.
 */
public class CreateUserCommand implements DomainCommand<CreateUserCommandResult> {
    private String login;
    private String password;
    private String firstname;
    private String lastname;

    public CreateUserCommand(String login,
                             String password,
                             String firstname,
                             String lastname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
