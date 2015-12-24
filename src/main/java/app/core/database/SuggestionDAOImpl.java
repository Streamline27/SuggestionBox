package app.core.database;

import app.core.domain.Suggestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 12/20/2015.
 */

@Component
public class SuggestionDAOImpl implements SuggestionDAO{

    @Autowired
    SessionFactory sessionFactory;

    protected Session getCurrectSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Suggestion suggestion) {
        getCurrectSession().saveOrUpdate(suggestion);
    }

    @Override
    public void update(Suggestion suggestion) {
        getCurrectSession().update(suggestion);
    }

    @Override
    public void delete(Suggestion suggestion) {
        getCurrectSession().delete(suggestion);
    }

    @Override
    public Suggestion getById(Long id) {
        return (Suggestion)getCurrectSession().get(Suggestion.class, id);
    }



    @Override
    public List<Suggestion> getAll()
    {
        return getCurrectSession().createCriteria(Suggestion.class).list();
    }
}
