package app.core.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav on 12/28/2015.
 */
@Component
public class CommandExecutorImpl implements CommandExecutor {
    @Autowired
    private List<DomainCommandHandler> services;

    private Map<Class, DomainCommandHandler> commandServiceMap;

    @PostConstruct
    private void init(){
        commandServiceMap = new HashMap<>();
        if (services!=null){
            for (DomainCommandHandler service : services){
                Class domainCommandClass = service.getCommandType();
                commandServiceMap.put(domainCommandClass, service);
            }
        }
    }

    @Override
    @Transactional
    public <T extends DomainCommandResult> T execute(DomainCommand<T> command) {
        DomainCommandHandler service = commandServiceMap.get(command.getClass());
        if (service!=null){
            return (T)service.execute(command);
        }
        else{
            throw new IllegalArgumentException("Unsupported command: "+command.toString());
        }
    }
}
