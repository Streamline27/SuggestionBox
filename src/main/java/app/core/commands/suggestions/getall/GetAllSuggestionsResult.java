package app.core.commands.suggestions.getall;

import app.core.commands.DomainCommandResult;
import app.dto.SuggestionDTO;

import java.util.List;

/**
 * Created by Vladislav on 12/28/2015.
 */
public class GetAllSuggestionsResult implements DomainCommandResult {
    List<SuggestionDTO> suggestions;

    public GetAllSuggestionsResult(List<SuggestionDTO> suggestions) {
        this.suggestions = suggestions;
    }

    public List<SuggestionDTO> getSuggestions() {
        return suggestions;
    }
}
