package app.core.commands;

/**
 * Created by Vladislav on 12/28/2015.
 */
public interface CommandExecutor {
    <T extends DomainCommandResult> T execute(DomainCommand<T> command);

}
