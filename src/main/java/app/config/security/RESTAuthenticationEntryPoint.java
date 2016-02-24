package app.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by Vladislav on 2/23/2016.
 */
@Component
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if ( request.getMethod().equals( "OPTIONS" ) ) {
            System.out.println("HTTP Method (OPTIONS) - Detected!");
            // Just send a OK signal back to the browser (Abort the filter chain with a response.)
            response.sendError(HttpServletResponse.SC_OK);
        }
        else{
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");


            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("Entry runs at url:");
            System.out.println(request.getRequestURL());
            System.out.println(".......");

        }

    }


}
