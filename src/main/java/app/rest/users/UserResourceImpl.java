package app.rest.users;

import app.core.commands.CommandExecutor;
import app.core.commands.users.login.LoginUserCommand;
import app.core.commands.users.login.LoginUserResult;
import app.core.commands.users.register.RegisterUserCommand;
import app.core.commands.users.register.RegisterUserResult;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 2/22/2016.
 */
@Component
@Path("/user")
public class UserResourceImpl implements UserResource {
    @Autowired
    CommandExecutor commandExecutor;


    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/register")
    @Override
    public UserInfoDTO register(UserDTO userDTO) {
        String login = userDTO.getLogin();
        String pass = userDTO.getPassword();
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();

        RegisterUserCommand command = new RegisterUserCommand(login, pass, firstName, lastName);
        RegisterUserResult result = commandExecutor.execute(command);
        return result.getUser();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Override
    public UserInfoDTO getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();


        if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
            System.out.println("User Is not authenticated! Throwing error");
            throw new WebApplicationException(HttpServletResponse.SC_CONFLICT);
        }
        UserDetails userDetails = (UserDetails) principal;
        System.out.println(userDetails.getUsername());
        return new UserInfoDTO(userDetails.getUsername(), "123", "123");
    }
}
