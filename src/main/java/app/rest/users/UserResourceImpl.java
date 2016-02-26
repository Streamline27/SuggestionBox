package app.rest.users;

import app.core.commands.CommandExecutor;
import app.core.commands.users.checkpresence.CheckUserPresenceCommand;
import app.core.commands.users.checkpresence.CheckUserPresenceResult;
import app.core.commands.users.register.RegisterUserCommand;
import app.core.commands.users.register.RegisterUserResult;
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
        if (!isDuplicate(userDTO)){
            RegisterUserResult result = registerUser(userDTO);
            return result.getUser();
        }
        else throw new UniqueLoginConstrainsViolationException(Response.Status.FORBIDDEN);
    }

    private boolean isDuplicate(UserDTO userDTO) {
        CheckUserPresenceCommand checkUserPresenceCommand = new CheckUserPresenceCommand(userDTO.getLogin());
        CheckUserPresenceResult userPresenceResult = commandExecutor.execute(checkUserPresenceCommand);
        return userPresenceResult.isPresent();
    }

    private RegisterUserResult registerUser(UserDTO userDTO) {
        RegisterUserCommand registerUserCommand = new RegisterUserCommand(
                userDTO.getLogin(),
                userDTO.getPassword(),
                userDTO.getFirstName(),
                userDTO.getLastName()
        );
        return commandExecutor.execute(registerUserCommand);
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
