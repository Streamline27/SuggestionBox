package app.core.commands.suggestions.get;

import app.core.commands.DomainCommandHandler;
import app.core.services.converters.SuggestionConverter;
import app.core.database.SuggestionDAO;
import app.core.domain.Suggestion;
import app.dto.SuggestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/29/2015.
 */
@Component
public class GetSuggestionHandler implements DomainCommandHandler<GetSuggestionCommand, GetSuggestionResult> {
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired SuggestionConverter converter;
    @Override
    public GetSuggestionResult execute(GetSuggestionCommand command) {
        Long id = command.getSuggestionId();
        SuggestionDTO suggestion = getSuggestion(id);
        return new GetSuggestionResult(suggestion);
    }

    private SuggestionDTO getSuggestion(Long id) {
        Suggestion suggestion = suggestionDAO.getById(id);
        return converter.toDTO(suggestion);
    }

    @Override
    public Class getCommandType() {
        return GetSuggestionCommand.class;
    }
}
