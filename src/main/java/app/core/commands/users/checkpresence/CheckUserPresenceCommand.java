package app.core.commands.users.checkpresence;

import app.core.commands.DomainCommand;

/**
 * Created by Vladislav on 2/26/2016.
 */
public class CheckUserPresenceCommand implements DomainCommand<CheckUserPresenceResult> {
    private String login;

    public CheckUserPresenceCommand(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

}
