package app.core.database;

import app.config.SuggestionBoxApplication;
import app.core.domain.Suggestion;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 12/20/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SuggestionBoxApplication.class})
@Transactional
public class SuggestionDAOImplTest {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    SuggestionDAO suggestionDAO;

    @Before
    public void ClearDatabase(){
        sessionFactory.getCurrentSession().createQuery("delete from Suggestion").executeUpdate();
    }


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