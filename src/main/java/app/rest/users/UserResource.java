package app.rest.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Vladislav on 2/18/2016.
 */

@RestController
public class UserResource {
    @RequestMapping("/api/user")
    public Principal user(Principal user){
        return user;
    }
}
