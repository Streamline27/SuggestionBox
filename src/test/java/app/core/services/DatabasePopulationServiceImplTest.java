package app.core.services;

import app.core.DatabaseHibernateTest;
import app.core.database.CommentDAO;
import app.core.database.SuggestionDAO;
import app.core.domain.Comment;
import app.core.domain.Suggestion;
import app.core.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 12/25/2015.
 */
public class DatabasePopulationServiceImplTest extends DatabaseHibernateTest {
    @Autowired
    DatabasePopulationService dbPopulationService;
    @Autowired SuggestionDAO suggestionDAO;
    @Autowired CommentDAO commentDAO;
    @Autowired UserFactory userFactory;

    @Test
    public void testClearDatabase() throws Exception {
        User user = new User("test", "test", "test", "test");
        userFactory.createUser(user);

        Suggestion testSuggestion = new Suggestion("Test", (long) 0);
        Comment comment1 = new Comment("TestComment1", user, new Date());
        Comment comment2 = new Comment("TestComment2", user, new Date());

        testSuggestion.addComment(comment1);
        testSuggestion.addComment(comment2);

        suggestionDAO.create(testSuggestion);
        commentDAO.create(comment1);
        commentDAO.create(comment2);

        dbPopulationService.clearDatabase();

        int numRecords = suggestionDAO.getAll().size() + commentDAO.getAll().size();
        assertEquals(numRecords, 0);
    }
}