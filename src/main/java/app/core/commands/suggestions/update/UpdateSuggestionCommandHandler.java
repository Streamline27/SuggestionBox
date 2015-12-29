package app.core.commands.suggestions.update;

import app.core.commands.DomainCommandHandler;
import app.core.commands.DomainCommandResult;
import app.core.database.SuggestionDAO;
import app.core.domain.Suggestion;
import app.core.services.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/29/2015.
 */
@Component
public class UpdateSuggestionCommandHandler implements DomainCommandHandler<UpdateSuggestionCommand, UpdateSuggestionResult>{
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired DTOConverter converter;

    @Override
    public UpdateSuggestionResult execute(UpdateSuggestionCommand command) {
        Suggestion suggestion = getSuggestion(command);
        suggestionDAO.update(suggestion);
        return new UpdateSuggestionResult(converter.createSuggestionDTO(suggestion));
    }

    private Suggestion getSuggestion(UpdateSuggestionCommand command) {
        return converter.createSuggestionFromDTO(command.getSuggestion());
    }

    @Override
    public Class getCommandType() {
        return UpdateSuggestionCommand.class;
    }
}
