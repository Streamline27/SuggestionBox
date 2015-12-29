package app.core.commands.comments.get;

import app.core.commands.DomainCommand;

/**
 * Created by Vladislav on 12/29/2015.
 */
public class GetSuggestionCommentsCommand implements DomainCommand<GetSuggestionCommentsResult> {
    private Long suggestionId;

    public GetSuggestionCommentsCommand(Long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public Long getSuggestionId() {
        return suggestionId;
    }
}
