package app.core.database;

import app.core.domain.Comment;
import app.core.domain.Suggestion;

import java.util.List;

/**
 * Created by Vladislav on 12/22/2015.
 */
public interface CommentDAO {
    void create(Comment suggestion);
    void update(Comment suggestion);
    void delete(Comment suggestion);
    Comment getById(Long id);
    List<Comment> getAll();
    List<Comment> getBySuggestion(Suggestion suggestion);
}
