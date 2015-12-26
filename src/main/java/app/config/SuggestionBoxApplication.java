package app.config;

import app.core.services.DatabasePopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"app"})
public class SuggestionBoxApplication {
    public static void main(String[] args)

    {
        SpringApplication.run(SuggestionBoxApplication.class, args);
    }
}
