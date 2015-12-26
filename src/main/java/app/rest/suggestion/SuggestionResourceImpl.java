package app.rest.suggestion;

import app.core.database.SuggestionDAO;
import app.core.database.SuggestionDAOImpl;
import app.core.domain.Suggestion;
import app.core.services.SuggestionInsertionService;
import app.dto.SuggestionDTO;
import app.dto.converter.DTOConverter;
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
@Path("/suggestions/")
public class SuggestionResourceImpl implements SuggestionResource {
    @Autowired SuggestionDAOImpl suggestionDAO;
    @Autowired TransactionTemplate transactionTemplate;
    @Autowired DTOConverter dtoConverter;
    @Autowired SuggestionInsertionService suggestionInsertionService;


    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<SuggestionDTO> getAll() {
        List<Suggestion> suggestions = getSuggestionsFromDAO();
        return dtoConverter.convertSuggestionsToDto(suggestions);
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public SuggestionDTO create(SuggestionDTO suggestionDTO) {
        Suggestion suggestion = dtoConverter.convertDtoToSuggestion(suggestionDTO);
        suggestionInsertionService.InsertSuggestionWithComments(suggestion);
        return suggestionDTO;
    }

    private List<Suggestion> getSuggestionsFromDAO() {
        return transactionTemplate.execute((TransactionStatus) -> suggestionDAO.getAll());
    }

}
