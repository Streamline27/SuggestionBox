package app.core.database;

import app.core.domain.Suggestion;

import java.util.List;

/**
 * Created by Vladislav on 12/20/2015.
 */
public interface SuggestionDAO {

    void create(Suggestion suggestion);
    void update(Suggestion suggestion);
    void delete(Suggestion suggestion);
    Suggestion getById(Long id);
    List<Suggestion> getAll();

}
