package app.rest.suggestion;

import app.core.database.SuggestionDAOImpl;
import app.core.domain.Suggestion;
import app.dto.SuggestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Vladislav on 12/24/2015.
 */
@Component
@Path("/suggestions/")
public class SuggestionResourceImpl implements SuggestionResource {
    @Autowired
    SuggestionDAOImpl suggestionDAO;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<SuggestionDTO> getAll() {
        List<Suggestion> suggestions = getSuggestionsFromDAO();
        return ConvertToDto(suggestions);
    }

    private List<Suggestion> getSuggestionsFromDAO() {
        return transactionTemplate.execute((TransactionStatus) -> suggestionDAO.getAll());
    }

    private List<SuggestionDTO> ConvertToDto(List<Suggestion> suggestions) {
        List<SuggestionDTO>  suggestionDTOs= new ArrayList<>();
        for (Suggestion suggestion : suggestions){
            suggestionDTOs.add(new SuggestionDTO(suggestion));
        }
        return suggestionDTOs;
    }
}
