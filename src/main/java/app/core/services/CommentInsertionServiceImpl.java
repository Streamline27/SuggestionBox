package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 12/24/2015.
 */
@Component
public class CommentInsertionServiceImpl implements CommentInsertionService {
    public CommentInsertionServiceImpl() {
    }

    @Override
    public void commentOnSuggestion(Comment comment, Suggestion suggestion) {
        suggestion.getComments().add(comment);
        comment.setSuggestion(suggestion);
    }
}
