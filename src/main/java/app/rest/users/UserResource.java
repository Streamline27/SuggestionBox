package app.rest.users;

import app.dto.UserDTO;
import app.dto.UserInfoDTO;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 2/22/2016.
 */
public interface UserResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("user/get")
    UserInfoDTO register(UserDTO userDTO);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("user")
    UserInfoDTO getUser();

}
