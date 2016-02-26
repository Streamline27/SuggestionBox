package app.core.commands.suggestions.getall;

import app.core.commands.DomainCommandHandler;
import app.core.services.converters.SuggestionConverter;
import app.core.database.SuggestionDAO;
import app.core.domain.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 12/28/2015.
 */
@Component
public class GetAllSuggestionsHandler implements DomainCommandHandler<GetAllSuggestionsCommand, GetAllSuggestionsResult> {
    @Autowired
    SuggestionDAO suggestionDAO;
    @Autowired SuggestionConverter converter;

    @Override
    public GetAllSuggestionsResult execute(GetAllSuggestionsCommand command) {
        List<Suggestion> suggestions = suggestionDAO.getAll();
        return new GetAllSuggestionsResult(converter.toDTOs(suggestions));
    }

    @Override
    public Class getCommandType() {
        return GetAllSuggestionsCommand.class;
    }
}
