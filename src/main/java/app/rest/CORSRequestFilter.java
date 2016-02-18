package app.rest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Vladislav on 2/18/2016.
 */
@PreMatching
@Provider
public class CORSRequestFilter implements ContainerRequestFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if ( requestContext.getRequest().getMethod().equals( "OPTIONS" ) ) {
            System.out.println("HTTP Method (OPTIONS) - Detected!");

            // Just send a OK signal back to the browser (Abort the filter chain with a response.)
            Response response = Response.status(Response.Status.OK).build();

            requestContext.abortWith(response);
        }
    }
}
