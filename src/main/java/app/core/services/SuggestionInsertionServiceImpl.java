package app.core.services;

import app.core.database.CommentDAO;
import app.core.database.SuggestionDAO;
import app.core.domain.Comment;
import app.core.domain.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 12/26/2015.
 */
@Component
public class SuggestionInsertionServiceImpl implements SuggestionInsertionService {
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired CommentDAO commentDAO;

    @Override
    @Transactional
    public void InsertSuggestionWithComments(Suggestion suggestion) {
        suggestionDAO.create(suggestion);
        for (Comment comment : suggestion.getComments()) commentDAO.create(comment);
    }

    @Override
    public void InsertSuggestionsWithComments(List<Suggestion> suggestions) {
        for (Suggestion suggestion: suggestions){
            InsertSuggestionWithComments(suggestion);
        }
    }
}
