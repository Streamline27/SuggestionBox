package app.config;

import app.core.services.DatabasePopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/26/2015.
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    DatabasePopulationService dbPopulationService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        dbPopulationService.clearDatabase();
        dbPopulationService.populateDatabase();
    }
}
