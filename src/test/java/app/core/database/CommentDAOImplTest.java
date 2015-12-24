package app.core.database;

import app.config.SuggestionBoxApplication;
import app.core.domain.Comment;
import app.core.domain.CommentBuilder;
import app.core.domain.Suggestion;
import app.core.services.CommentInsertionService;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 12/22/2015.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SuggestionBoxApplication.class})
@Transactional
@Rollback(false)
public class CommentDAOImplTest {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    SuggestionDAO suggestionDAO;
    @Autowired
    CommentDAO commentDAO;
    @Autowired
    CommentInsertionService commentInsertionService;

    @Before
    public void ClearDatabase(){
        sessionFactory.getCurrentSession().createQuery("delete from Suggestion").executeUpdate();
        sessionFactory.getCurrentSession().createQuery("delete from Comment").executeUpdate();
    }


    @Test
    public void afterInsertCommentSuggestionShouldBeReturnedWithThatComment() throws Exception {
        // Creating suggestion
        String suggestionTitile = "TestTitle";
        Long suggestionUpvotes = (long) 0;


        // Creating comment
        String author = "TestAuthor";
        Date date = new Date();
        String text = "TestText";

        Suggestion testSuggesion = new Suggestion(suggestionTitile, suggestionUpvotes);
        Comment commentToInsert = new Comment(text, author, date, testSuggesion);
        commentInsertionService.commentOnSuggestion(commentToInsert, testSuggesion);

        // Database stuff
        suggestionDAO.create(testSuggesion);
        commentDAO.create(commentToInsert);

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
        // Creating suggestion
        String suggestionTitile = "TestTitle";
        Long suggestionUpvotes = (long) 0;

        Suggestion testSuggesion = new Suggestion(suggestionTitile, suggestionUpvotes);
        suggestionDAO.create(testSuggesion);

        int numComments= 5;
        for (int i = 0; i < numComments; i++) {
            Comment comment = CommentBuilder.createComment().withAuthor(new Long(i).toString()).withDate(new Date())
                    .withText("Text").withSuggestion(testSuggesion).Build();
            commentDAO.create(comment);
        }

        testSuggesion.setComments(commentDAO.getBySuggestion(testSuggesion));
        assertEquals(numComments, testSuggesion.getComments().size());
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