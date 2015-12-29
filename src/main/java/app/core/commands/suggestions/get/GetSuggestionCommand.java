package app.core.commands.suggestions.get;

import app.core.commands.DomainCommand;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class GetSuggestionCommand implements DomainCommand<GetSuggestionResult> {
    private Long suggestionId;

    public GetSuggestionCommand(Long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public Long getSuggestionId() {
        return suggestionId;
    }
}
