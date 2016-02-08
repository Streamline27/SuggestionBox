package app.rest.users;

import app.dto.UserDTO;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 2/8/2016.
 */
public interface UserResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    UserDTO create(UserDTO userDTO);
}
