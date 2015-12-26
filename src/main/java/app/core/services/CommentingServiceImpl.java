package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 12/26/2015.
 */
@Component
public class CommentingServiceImpl implements CommentingService {
    @Override
    public void commentOnSuggestion(Comment comment, Suggestion suggestion) {
        suggestion.addComment(comment);
    }

    @Override
    public void commentOnSuggestion(List<Comment> comments, Suggestion suggestion) {
        for (Comment comment : comments) suggestion.addComment(comment);
    }
}
