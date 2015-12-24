package app.core.database;


import app.core.domain.Comment;
import app.core.domain.Suggestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 12/22/2015.
 */

@Component
public class CommentDAOImpl implements CommentDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Comment> getBySuggestion(Suggestion suggestion) {
        return getCurrentSession().createCriteria(Comment.class).add(Restrictions.eq("suggestion", suggestion)).list();
    }

    @Override
    public void create(Comment comment) {
        getCurrentSession().saveOrUpdate(comment);
    }

    @Override
    public void update(Comment comment) {
        getCurrentSession().saveOrUpdate(comment);
    }

    @Override
    public void delete(Comment comment) {
        getCurrentSession().delete(comment);
    }

    @Override
    public Comment getById(Long id) {
        return (Comment)getCurrentSession().get(Comment.class, id);
    }

    @Override
    public List<Comment> getAll() {
        return getCurrentSession().createCriteria(Comment.class).list();
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


}
