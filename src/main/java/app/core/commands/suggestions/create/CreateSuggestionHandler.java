package app.core.commands.suggestions.create;

import app.core.commands.DomainCommandHandler;
import app.core.domain.Suggestion;
import app.core.services.SuggestionFactory;
import app.core.services.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/28/2015.
 */
@Component
public class CreateSuggestionHandler implements DomainCommandHandler<CreateSuggestionCommand, CreateSuggestionResult> {
    @Autowired SuggestionFactory suggestionFactory;
    @Autowired DTOConverter converter;

    @Override
    public CreateSuggestionResult execute(CreateSuggestionCommand command) {
        Suggestion suggestion = getSuggestion(command);
        createSuggestion(suggestion);
        return getCreationResult(suggestion);
    }

    private CreateSuggestionResult getCreationResult(Suggestion suggestion) {
        return new CreateSuggestionResult(converter.createSuggestionDTO(suggestion));
    }

    private void createSuggestion(Suggestion suggestion) {
        suggestionFactory.createSuggestion(suggestion);
    }

    private Suggestion getSuggestion(CreateSuggestionCommand command) {
        return new Suggestion(command.getTitle(), (long) 0);
    }

    @Override
    public Class getCommandType() {
        return CreateSuggestionCommand.class;

    }
}
