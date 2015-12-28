package app.core.services;

import app.core.database.CommentDAO;
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
public class CommentingServiceImpl implements CommentingService {
    @Autowired
    CommentDAO commentDAO;

    @Override
    public void commentOnSuggestion(Comment comment, Suggestion suggestion)
    {
        suggestion.addComment(comment);
        commentDAO.create(comment);
    }

    @Override
    public void commentOnSuggestion(List<Comment> comments, Suggestion suggestion) {
        for (Comment comment : comments){
            suggestion.addComment(comment);
            commentDAO.create(comment);
        }
    }
}
