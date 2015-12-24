package app.rest.suggestion;

import app.dto.SuggestionDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 12/24/2015.
 */
public interface SuggestionResource {
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/suggestions/")
    List<SuggestionDTO> getAll();
}
