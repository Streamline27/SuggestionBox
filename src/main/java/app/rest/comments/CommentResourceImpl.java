package app.rest.comments;

import app.core.commands.CommandExecutor;
import app.core.commands.comments.create.CreateCommentCommand;
import app.core.commands.comments.create.CreateCommentResult;
import app.core.commands.comments.get.GetSuggestionCommentsCommand;
import app.core.commands.comments.get.GetSuggestionCommentsResult;
import app.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 12/29/2015.
 */

@Component
@Path("/suggestions/{suggestionId}/comments/")
public class CommentResourceImpl implements CommentResource{

    @Autowired CommandExecutor commandExecutor;

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<CommentDTO> getCommentsBySuggestionId(@PathParam("suggestionId") Long suggestionId) {
        GetSuggestionCommentsCommand command = new GetSuggestionCommentsCommand(suggestionId);
        GetSuggestionCommentsResult result = commandExecutor.execute(command);
        return result.getCommets();
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public CommentDTO create(@PathParam("suggestionId") Long suggestionId, CommentDTO commentDTO)
    {
        CreateCommentCommand command = new CreateCommentCommand(commentDTO, suggestionId);
        CreateCommentResult result = commandExecutor.execute(command);
        return result.getCommentDTO();
    }
}
