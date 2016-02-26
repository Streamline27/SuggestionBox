package app.core.database;

import app.core.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Vladislav on 2/8/2016.
 */
@Component
public class UserDAOImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(User user)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getById(Long id) {
        return (User)sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByLogin(String login) {
        User user = (User)sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
        return user;
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
