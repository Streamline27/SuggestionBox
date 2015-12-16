package app.rest.demo;

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
    @GET
    @Produces("text/plain")
    public String Greeting(){
        return "Hello";
    }
}
