package app.core.database;

import app.core.DatabaseHibernateTest;
import app.core.domain.Comment;
import app.core.domain.Suggestion;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 12/22/2015.
 */


public class CommentDAOImplTest extends DatabaseHibernateTest {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    SuggestionDAO suggestionDAO;
    @Autowired
    CommentDAO commentDAO;

    @Test
    public void afterInsertCommentSuggestionShouldBeReturnedWithThatComment() throws Exception {
        // Creating suggestions
        String suggestionTitile = "TestTitle";
        Long suggestionUpvotes = (long) 0;


        // Creating comment
        String author = "TestAuthor";
        Date date = new Date();
        String text = "TestText";

        Suggestion testSuggesion = new Suggestion(suggestionTitile, suggestionUpvotes);
        Comment commentToInsert = new Comment(text, author, date);
        testSuggesion.addComment(commentToInsert);

        // Database stuff
        suggestionDAO.create(testSuggesion);
        //commentDAO.create(commentToInsert);

        //Comment recievedComment = commentDAO.getById(commentToInsert.getId());
        Suggestion recievedSuggestion = suggestionDAO.getById(testSuggesion.getId());
        assertEquals(commentToInsert.getId(), recievedSuggestion.getComments().get(0).getId());
    }

    private void assertCommentEquals(Comment commentToInsert, Comment recievedComment) {
        assertEquals(recievedComment.getId(), commentToInsert.getId());
        assertEquals(recievedComment.getText(), commentToInsert.getText());
        assertEquals(recievedComment.getAuthor(), commentToInsert.getAuthor());
    }


    @Test
    public void getBySuggestionShouldReturnListOfComentsRelatedToSuggestion() throws Exception {
        // Creating suggestions
        String suggestionTitile = "TestTitle";
        Long suggestionUpvotes = (long) 0;

        Suggestion testSuggesion = new Suggestion(suggestionTitile, suggestionUpvotes);
        suggestionDAO.create(testSuggesion);

        int numComments= 5;

        createComments(testSuggesion, numComments);

        List<Comment> commentList = commentDAO.getBySuggestion(testSuggesion);
        assertEquals(numComments, commentList.size());
    }

    private void createComments(Suggestion testSuggesion, int numComments) {
        for (int i = 0; i < numComments; i++) {
            Comment comment = new Comment("Text", "Author", new Date());

            testSuggesion.addComment(comment);
            commentDAO.create(comment);
        }
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

    }

}