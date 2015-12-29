package app.rest.suggestions;

import app.dto.SuggestionDTO;

import javax.ws.rs.*;

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

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/suggestions/{suggestionId}")
    SuggestionDTO get(@PathParam("suggestionId") Long suggestionId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    SuggestionDTO create(SuggestionDTO suggestionDTO);

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    SuggestionDTO updateSuggestion(SuggestionDTO suggestionDTO);
}
