package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;

import java.util.List;

/**
 * Created by Vladislav on 12/26/2015.
 */
public interface CommentingService {
    void commentOnSuggestion(Comment comment, Suggestion suggestion);
    void commentOnSuggestion(List<Comment> comments, Suggestion suggestion);
}
