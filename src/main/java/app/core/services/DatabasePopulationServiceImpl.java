package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;
import app.core.domain.User;
import app.core.services.CommentingService;
import app.core.services.DatabasePopulationService;
import app.core.services.SuggestionFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladislav on 12/25/2015.
 */
@Component
@Transactional
public class DatabasePopulationServiceImpl implements DatabasePopulationService {

    @Autowired EntityManagerFactory entityManagerFactory;
    @Autowired SessionFactory sessionFactory;
    @Autowired
    CommentingService commentingService;
    @Autowired
    SuggestionFactory suggestionFactory;
    @Autowired UserFactory userFactory;

    @Override
    public void clearDatabase() {
        List<String> entityNames = getEntityClassNames();
        for (String entityName : entityNames){
            clearTableByEntityName(entityName);
        }
    }

    @Override
    public void populateDatabase() {
        createCommentedSuggestion();
        createUncommentedSuggestions();
    }


    /* Private helper methods */

    /* populateDatabase helper methods */
    private void createCommentedSuggestion() {
        Suggestion suggestion = new Suggestion("Retrofit water fountain with Gatorade", (long) 7);
        suggestionFactory.createSuggestion(suggestion);
        User user = getCommentingUser();
        List<Comment> commentList = getComments(user);
        commentingService.commentOnSuggestion(commentList, suggestion);

    }
    private List<Comment> getComments(User user) {

        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("Cool idea, I like that!", user, new Date()));
        comments.add(new Comment("Vodka Mishka Balalaika", user, new Date()));
        comments.add(new Comment("Nice one.", user, new Date()));
        return comments;
    }


    private void createUncommentedSuggestions() {
        List<Suggestion> uncommentedSuggestions = getUncommentedSuggestions();
        suggestionFactory.createSuggestions(uncommentedSuggestions);

    }
    public List<Suggestion> getUncommentedSuggestions() {
        List<Suggestion> uncommentedSuggestions = new ArrayList<>();
        uncommentedSuggestions.add(new Suggestion("End all club emails with Laffy Taffy jokes", (long) 9));
        uncommentedSuggestions.add(new Suggestion("Free pizza at club meetings", (long) 15));
        uncommentedSuggestions.add(new Suggestion("Sing Bon Jovi\'s \"Living on a Prayer\" halfway through meetings", (long) 3));
        return uncommentedSuggestions;
    }


    /* clearDatabase helper methods */
    private List<String> getEntityClassNames() {
        Set<EntityType<?>> entityTypes = entityManagerFactory.getMetamodel().getEntities();
        List<String> entityNames = new ArrayList<>();
        entityTypes.forEach(entityType -> entityNames.add(entityType.getName()));
        return entityNames;

    }
    private void clearTableByEntityName(String entityName) {
        sessionFactory.getCurrentSession().createQuery("delete from "+entityName).executeUpdate();
    }


    private User getCommentingUser() {
        return new User("Anonymous", "123", "Anonymous", "Anonymous");
    }
}
