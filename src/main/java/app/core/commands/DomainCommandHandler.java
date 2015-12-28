package app.core.commands;

/**
 * Created by Vladislav on 12/28/2015.
 */
public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
