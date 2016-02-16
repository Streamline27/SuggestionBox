package app.rest.users;

import app.core.commands.CommandExecutor;
import app.core.commands.users.login.LoginUserCommand;
import app.core.commands.users.login.LoginUserResult;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 2/16/2016.
 */

@Component
@Path("/login")
public class LoginResourceImpl implements LoginResource {
    @Autowired
    CommandExecutor commandExecutor;


    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Override
    public UserInfoDTO login(UserDTO userDTO) {
        String login = userDTO.getLogin();
        String pass = userDTO.getPassword();

        LoginUserCommand command = new LoginUserCommand(login, pass);
        LoginUserResult result = commandExecutor.execute(command);

        /* TODO: Understand how to return error message instead of null */
        if (result.isUserAuthorizedSuccessfully()) return result.getUserInfoDTO();
        else throw new IllegalCredentialsException("Wrong login or password.");
    }

    public class IllegalCredentialsException extends WebApplicationException {
        public IllegalCredentialsException(String message) {
            super(Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity(message).type(MediaType.TEXT_PLAIN).build());
        }
    }
}
