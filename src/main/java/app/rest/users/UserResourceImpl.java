package app.rest.users;

import app.core.commands.CommandExecutor;
import app.core.commands.users.create.CreateUserCommand;
import app.core.commands.users.create.OperationUnsupportedForFailureResultException;
import app.core.commands.users.create.result.CreateUserCommandResult;
import app.dto.UserDTO;
import app.dto.UserInfoDTO;
import app.security.authentication.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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

        CreateUserCommand createUserCommand = getCreateUserCommand(userDTO);
        CreateUserCommandResult result = commandExecutor.execute(createUserCommand);

        try {
            return result.getUserInfoDTO();
        } catch (OperationUnsupportedForFailureResultException e) {
            throw new RegisterUserFailureException(Response.Status.FORBIDDEN);
        }
    }

    private CreateUserCommand getCreateUserCommand(UserDTO userDTO) {
        return new CreateUserCommand(
                userDTO.getLogin(),
                userDTO.getPassword(),
                userDTO.getFirstName(),
                userDTO.getLastName()
        );
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Override
    public UserInfoDTO getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return ((UserPrincipal)principal).getUserInfo();
    }
}
