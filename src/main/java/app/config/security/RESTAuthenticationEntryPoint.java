package app.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

/**
 * Created by Vladislav on 2/23/2016.
 */
@Component
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia, Authorization"  );


        if ( request.getMethod().equals( "OPTIONS" ) ) {
            System.out.println("HTTP Method (OPTIONS) - Detected at EntryPoint!");
            // Just send a OK signal back to the browser (Abort the filter chain with a response.)
            response.sendError(HttpServletResponse.SC_OK, "Hello From entry");
        }
        else{


            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Hello from entry");
            System.out.print("Entry runs at url: ");
            System.out.println(request.getRequestURL());

        }

    }


}
