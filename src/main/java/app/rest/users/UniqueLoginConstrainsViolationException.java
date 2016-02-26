package app.rest.users;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by Vladislav on 2/26/2016.
 */
public class UniqueLoginConstrainsViolationException extends WebApplicationException {
    public UniqueLoginConstrainsViolationException(Response.Status status) {
        super(status);
    }
}
