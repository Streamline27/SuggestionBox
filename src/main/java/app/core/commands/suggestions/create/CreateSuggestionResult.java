package app.core.commands.suggestions.create;

import app.core.commands.DomainCommandResult;
import app.dto.SuggestionDTO;

/**
 * Created by Vladislav on 12/28/2015.
 */
public class CreateSuggestionResult implements DomainCommandResult {

    private SuggestionDTO suggestionDTO;

    public CreateSuggestionResult(SuggestionDTO suggestionDTO) {
        this.suggestionDTO = suggestionDTO;
    }

    public SuggestionDTO getSuggestionDTO() {
        return suggestionDTO;
    }
}
