package app.core.commands.users.checkpresence;

import app.core.commands.DomainCommandHandler;
import app.core.database.UserDAO;
import app.core.services.UserPresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 3/21/2016.
 */
public class CheckUserPresenceCommandHandler
        implements DomainCommandHandler<CheckUserPresenceCommand, CheckUserPresenceResult>{
    private @Autowired UserDAO userDAO;
    private @Autowired UserPresenceService userPresenceService;

    private final boolean USER_IS_PRESENT = true;
    private final boolean USER_IS_NOT_PRESENT = false;

    @Override
    public CheckUserPresenceResult execute(CheckUserPresenceCommand command) {
        String login = command.getLogin();
        if(userWithLoginAlreadyExists(login)) return new CheckUserPresenceResult(USER_IS_PRESENT);
        else return new CheckUserPresenceResult(USER_IS_NOT_PRESENT);
    }

    private boolean userWithLoginAlreadyExists(String login) {
        return userPresenceService.isPresent(login);
    }

    @Override
    public Class getCommandType() {
        return CheckUserPresenceCommand.class;
    }

}
