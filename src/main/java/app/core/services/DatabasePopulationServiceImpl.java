package app.core.services;

import app.core.domain.Comment;
import app.core.domain.Suggestion;
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
    @Autowired CommentingService cs;
    @Autowired SuggestionInsertionService suggestionInsertionService;

    @Override
    public void clearDatabase() {
        List<String> entityNames = getEntityClassNames();
        for (String entityName : entityNames){
            clearTableByEntityName(entityName);
        }
    }

    @Override
    public void populateDatabase() {
        List<Suggestion> suggestionsToPopulate = new ArrayList<>();

        Suggestion commentedSuggestion = getCommentedSuggestion();;
        suggestionsToPopulate.add(commentedSuggestion);
        addUncommentedSuggestions(suggestionsToPopulate);

        suggestionInsertionService.InsertSuggestionsWithComments(suggestionsToPopulate);
    }
    /* Private helper methods */

    /* populateDatabase helper methods */
    private void addUncommentedSuggestions(List<Suggestion> suggestionsToPopulate) {
        suggestionsToPopulate.add(new Suggestion("End all club emails with Laffy Taffy jokes", (long) 9));
        suggestionsToPopulate.add(new Suggestion("Free pizza at club meetings", (long) 15));
        suggestionsToPopulate.add(new Suggestion("Sing Bon Jovi\\'s \"Living on a Prayer\" halfway through meetings", (long) 3));
    }

    private Suggestion getCommentedSuggestion() {
        Suggestion suggestion = new Suggestion("Retrofit water fountain with Gatorade", (long) 7);
        List<Comment> commentList;
        commentList = getComments();
        cs.commentOnSuggestion(commentList, suggestion);
        return suggestion;
    }

    private List<Comment> getComments() {
        List<Comment> commentList;
        commentList  = new ArrayList<>();
        addCommentsToCommentList(commentList);
        return commentList;
    }

    private void addCommentsToCommentList(List<Comment> comments) {
        comments.add(new Comment("Cool idea, I like that!", "Streamline27", new Date()));
        comments.add(new Comment("Vodka Mishka Balalaika", "Sharter", new Date()));
        comments.add(new Comment("Nice one.", "Nephius", new Date()));
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

}
