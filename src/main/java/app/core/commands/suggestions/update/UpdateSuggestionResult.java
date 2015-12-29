package app.core.commands.suggestions.update;

import app.core.commands.DomainCommandResult;
import app.dto.SuggestionDTO;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class UpdateSuggestionResult implements DomainCommandResult {
    SuggestionDTO suggestion;

    public UpdateSuggestionResult(SuggestionDTO suggestion) {
        this.suggestion = suggestion;
    }

    public SuggestionDTO getSuggestion() {
        return suggestion;
    }
}
