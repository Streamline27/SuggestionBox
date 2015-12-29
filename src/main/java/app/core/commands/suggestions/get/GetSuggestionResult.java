package app.core.commands.suggestions.get;

import app.core.commands.DomainCommandResult;
import app.dto.SuggestionDTO;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class GetSuggestionResult implements DomainCommandResult{
    SuggestionDTO suggestion;

    public GetSuggestionResult(SuggestionDTO suggestion) {
        this.suggestion = suggestion;
    }

    public SuggestionDTO getSuggestion() {
        return suggestion;
    }
}
