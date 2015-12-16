package app.config;

import app.rest.RestResource;
import app.rest.demo.DemoResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Vladislav on 12/16/2015.
 */
@Configuration
@ApplicationPath(RestResource.API_PATH)
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(DemoResourceImpl.class);
    }
}
