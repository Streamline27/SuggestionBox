package app.rest.suggestions;

import app.core.commands.CommandExecutor;
import app.core.commands.suggestions.create.CreateSuggestionCommand;
import app.core.commands.suggestions.create.CreateSuggestionResult;
import app.core.commands.suggestions.get.GetSuggestionCommand;
import app.core.commands.suggestions.get.GetSuggestionResult;
import app.core.commands.suggestions.getall.GetAllSuggestionsCommand;
import app.core.commands.suggestions.getall.GetAllSuggestionsResult;
import app.core.commands.suggestions.update.UpdateSuggestionCommand;
import app.core.commands.suggestions.update.UpdateSuggestionResult;
import app.core.database.SuggestionDAO;
import app.core.domain.Suggestion;
import app.dto.SuggestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 12/24/2015.
 */
@Component
@Path("/suggestions")
public class SuggestionResourceImpl implements SuggestionResource {
    @Autowired CommandExecutor commandExecutor;

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<SuggestionDTO> getAll() {
        GetAllSuggestionsCommand command = new GetAllSuggestionsCommand();
        GetAllSuggestionsResult result = commandExecutor.execute(command);
        return result.getSuggestions();
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public SuggestionDTO create(SuggestionDTO suggestionDTO) {
        CreateSuggestionCommand command = new CreateSuggestionCommand(suggestionDTO.getTitle());
        CreateSuggestionResult result = commandExecutor.execute(command);
        return  result.getSuggestionDTO();
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{suggestionId}")
    public SuggestionDTO get(@PathParam("suggestionId") Long suggestionId) {
        GetSuggestionCommand command = new GetSuggestionCommand(suggestionId);
        GetSuggestionResult result = commandExecutor.execute(command);
        return result.getSuggestion();
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public SuggestionDTO updateSuggestion(SuggestionDTO suggestionDTO) {
        UpdateSuggestionCommand command = new UpdateSuggestionCommand(suggestionDTO);
        UpdateSuggestionResult result = commandExecutor.execute(command);
        return  result.getSuggestion();
    }
}
