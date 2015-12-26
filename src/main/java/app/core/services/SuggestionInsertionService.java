package app.core.services;

import app.core.domain.Suggestion;

import java.util.List;

/**
 * Created by Vladislav on 12/26/2015.
 */
public interface SuggestionInsertionService {
    void InsertSuggestionWithComments(Suggestion suggestion);
    void InsertSuggestionsWithComments(List<Suggestion> suggestion);
}
