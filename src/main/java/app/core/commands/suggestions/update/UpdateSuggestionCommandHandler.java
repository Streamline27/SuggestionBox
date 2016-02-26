package app.core.commands.suggestions.update;

import app.core.commands.DomainCommandHandler;
import app.core.services.converters.SuggestionConverter;
import app.core.database.SuggestionDAO;
import app.core.domain.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/29/2015.
 */
@Component
public class UpdateSuggestionCommandHandler implements DomainCommandHandler<UpdateSuggestionCommand, UpdateSuggestionResult>{
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired SuggestionConverter converter;

    @Override
    public UpdateSuggestionResult execute(UpdateSuggestionCommand command) {
        Suggestion suggestion = getSuggestion(command);
        suggestionDAO.update(suggestion);
        return new UpdateSuggestionResult(converter.toDTO(suggestion));
    }

    private Suggestion getSuggestion(UpdateSuggestionCommand command) {
        return converter.fromDTO(command.getSuggestion());
    }

    @Override
    public Class getCommandType() {
        return UpdateSuggestionCommand.class;
    }
}
