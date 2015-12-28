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
public class SuggestionFactoryImpl implements SuggestionFactory {
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired CommentDAO commentDAO;

    @Override
    public void createSuggestion(Suggestion suggestion) {
        suggestionDAO.create(suggestion);
    }

    @Override
    public void createSuggestions(List<Suggestion> suggestions) {
        for (Suggestion suggestion: suggestions) suggestionDAO.create(suggestion);
    }
}
