package app.core.commands.users.register;

import app.core.commands.DomainCommand;

/**
 * Created by Vladislav on 2/8/2016.
 */
public class RegisterUserCommand implements DomainCommand<RegisterUserResult> {
    private String login;
    private String password;
    private String firstname;
    private String lastname;

    public RegisterUserCommand(String login,
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
