package app.core.commands.users.checkpresence;

import app.core.commands.DomainCommandResult;

/**
 * Created by Vladislav on 2/26/2016.
 */
public class CheckUserPresenceResult implements DomainCommandResult {
    private boolean isPresent;

    public CheckUserPresenceResult(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public boolean isPresent() {
        return isPresent; //
    }
}
