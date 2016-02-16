package app.core.database;

import app.core.DatabaseHibernateTest;
import app.core.domain.Comment;
import app.core.domain.Suggestion;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 12/22/2015.
 */


public class CommentDAOImplTest extends DatabaseHibernateTest {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    SuggestionDAO suggestionDAO;
    @Autowired
    CommentDAO commentDAO;

    @Test
    public void afterInsertCommentSuggestionShouldBeReturnedWithThatComment() throws Exception {
        // Creating suggestions
            String suggestionTitile = "TestTitle";
            Long suggestionUpvotes = (long) 0;
            Suggestion testSuggesion = new Suggestion(suggestionTitile, suggestionUpvotes);

        // Creating comment
            String author = "TestAuthor";
            Date date = new Date();
            String text = "TestText";
            Comment commentToInsert = new Comment(text, author, date);
            commentToInsert.setSuggestion(testSuggesion);



        // Database stuff
        getTransactionalTemplate().execute((txStatus)->{

            suggestionDAO.create(testSuggesion);
            return null;
        });

        getTransactionalTemplate().execute((txStatus)->{


            commentDAO.create(commentToInsert);
            return null;
        });

        //Comment recievedComment = commentDAO.getById(commentToInsert.getId());
//        Suggestion recievedSuggestion = suggestionDAO.getById(testSuggesion.getId());
//        assertEquals(commentToInsert.getId(), recievedSuggestion.getComments().get(0).getId());
    }

    private TransactionTemplate getTransactionalTemplate(){
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(Propagation.REQUIRES_NEW.value());
        return transactionTemplate;
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