package app.rest.demo;

import app.core.database.SuggestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Vladislav on 12/16/2015.
 */

@Component
@Path("/demo")
public class DemoResourceImpl {
    @Autowired
    SuggestionDAO sd;

    @GET
    @Produces("text/plain")
    public String Greeting()
    {
        return "Hello";
    }
}
