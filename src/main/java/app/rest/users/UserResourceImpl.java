package app.rest.users;

import app.core.commands.CommandExecutor;
import app.core.commands.users.create.CreateUserCommand;
import app.core.commands.users.create.CreateUserResult;
import app.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;




/**
 * Created by Vladislav on 2/8/2016.
 */
@Component
@Path("/register")
public class UserResourceImpl implements UserResource {
    @Autowired
    CommandExecutor commandExecutor;


    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Override
    public UserDTO create(UserDTO userDTO) {
        String login = userDTO.getLogin();
        String pass = userDTO.getPassword();
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();

        CreateUserCommand command = new CreateUserCommand(login, pass, firstName, lastName);
        CreateUserResult result = commandExecutor.execute(command);
        return result.getUser();
    }
}
