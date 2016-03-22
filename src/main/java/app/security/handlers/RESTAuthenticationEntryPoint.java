package app.security.handlers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vladislav on 2/23/2016.
 */
//@Component
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia, Authorization"  );

        if ( request.getMethod().equals( "OPTIONS" ) ) {
            System.out.println("HTTP Method (OPTIONS) - Detected at EntryPoint!");
            // Just send a OK signal back to the browser (Abort the filter chain with a response.)
            response.sendError(HttpServletResponse.SC_OK, "Options fetched");
        }
        else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access denied");
        }

    }


}
