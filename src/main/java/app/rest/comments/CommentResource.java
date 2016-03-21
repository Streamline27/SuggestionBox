package app.rest.comments;

import app.core.domain.Comment;
import app.dto.CommentDTO;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


/**
 * Created by Vladislav on 12/29/2015.
 */
public interface CommentResource {
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/suggestions/{suggestionId}/comments/")
    List<CommentDTO> getCommentsBySuggestionId(@PathParam("suggestionId") Long suggestionId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/suggestions/{suggestionId}/comments/")
    CommentDTO create(@PathParam("suggestionId") Long suggestionId, CommentDTO commentDTO);
}
