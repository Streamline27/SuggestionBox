package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;

/**
 * Created by Vladislav on 12/24/2015.
 */
public interface CommentInsertionService {
    void commentOnSuggestion(Comment comment, Suggestion suggestion);
}
