package app.core.commands.suggestions.update;

import app.core.commands.DomainCommand;
import app.core.commands.DomainCommandResult;
import app.dto.SuggestionDTO;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class UpdateSuggestionCommand implements DomainCommand<UpdateSuggestionResult>{
    SuggestionDTO suggestion;

    public UpdateSuggestionCommand(SuggestionDTO suggestion) {
        this.suggestion = suggestion;
    }

    public SuggestionDTO getSuggestion() {
        return suggestion;
    }
}
