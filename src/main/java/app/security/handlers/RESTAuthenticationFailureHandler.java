package app.security.handlers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vladislav on 2/24/2016.
 */
@Component
public class RESTAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        super.onAuthenticationFailure(request, response, exception);
        System.out.println("FAILURE");
        System.out.println("FAILURE");

//        if (request.getMethod().equals("OPTIONS")) {
//            response.setStatus(HttpServletResponse.SC_ACCEPTED);
//            return;
//        }
    }
}
