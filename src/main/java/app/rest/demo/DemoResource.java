package app.rest.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * Created by Vladislav on 12/16/2015.
 */
public interface DemoResource {
    @GET
    @Produces("text/plain")
    public String Greeting();
}
