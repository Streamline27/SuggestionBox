package app.config;

import app.rest.CORSResponseFilter;
import app.rest.RestResource;
import app.rest.comments.CommentResourceImpl;
import app.rest.demo.DemoResourceImpl;
import app.rest.suggestions.SuggestionResourceImpl;
import app.rest.CORSRequestFilter;
import app.rest.users.UserResource;
import app.rest.users.UserResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Vladislav on 12/16/2015.
 */
@Configuration
@ApplicationPath(RestResource.API_PATH)
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
//        register(CORSResponseFilter.class);
//        register(CORSRequestFilter.class);
        register(DemoResourceImpl.class);
        register(SuggestionResourceImpl.class);
        register(CommentResourceImpl.class);
        register(UserResourceImpl.class);
    }
}
