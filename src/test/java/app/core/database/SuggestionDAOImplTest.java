package app.core.database;

import app.core.DatabaseHibernateTest;
import app.core.domain.Suggestion;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 12/20/2015.
 */

public class SuggestionDAOImplTest extends DatabaseHibernateTest {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    SuggestionDAO suggestionDAO;


    @Test
    public void testCreate() throws Exception {
        Suggestion suggestionToAdd = getTestSuggestion();
        suggestionDAO.create(suggestionToAdd);
        Suggestion suggestionRecieved = suggestionDAO.getById(suggestionToAdd.getId());
        assertEquals(suggestionRecieved, suggestionToAdd);
    }

    @Test
    public void testUpdate() throws Exception {
        String updatetTitle = "UpdatetTitle";

        Suggestion suggestion = getTestSuggestion();
        suggestionDAO.create(suggestion);
        suggestion.setTitle(updatetTitle);
        suggestionDAO.update(suggestion);
        suggestion = suggestionDAO.getById(suggestion.getId());
        assertEquals(suggestion.getTitle(), updatetTitle);
    }

    @Test
    public void testDelete() throws Exception {
        Suggestion suggestion = getTestSuggestion();
        suggestionDAO.create(suggestion);
        suggestionDAO.delete(suggestion);
        suggestion = suggestionDAO.getById(suggestion.getId());
        assertEquals(suggestion, null);
    }

    private Suggestion getTestSuggestion() {
        return new Suggestion("Test", new Long(0));
    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        int numSuggestions = 4;

        AddTestSuggestionsToDB(numSuggestions);
        List<Suggestion> suggestions = suggestionDAO.getAll();

        assertEquals(numSuggestions, suggestions.size());

        Suggestion a = new Suggestion();

    }

    private void AddTestSuggestionsToDB(int numSuggestions) {
        for (int i = 0; i < numSuggestions; i++){
            Suggestion sug = new Suggestion("Test", new Long(i));
            suggestionDAO.create(sug);
        }
    }

}