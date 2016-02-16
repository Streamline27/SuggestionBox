package app.rest.users;

import app.core.commands.CommandExecutor;
import app.core.commands.users.register.RegisterUserCommand;
import app.core.commands.users.register.RegisterUserResult;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;




/**
 * Created by Vladislav on 2/8/2016.
 */
@Component
@Path("/register")
public class RegisterResourceImpl implements RegisterResource {
    @Autowired
    CommandExecutor commandExecutor;


    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
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
}
