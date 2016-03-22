package app.core.database;

import app.core.DatabaseHibernateTest;
import app.core.domain.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Vladislav on 2/8/2016.
 */
public class UserDAOImplTest extends DatabaseHibernateTest{
    @Autowired UserDAO userDAO;

    @Test
    @Ignore
    public void testGetByLogin() throws Exception {
        User userToCreate = new User("Login", "123", "Vasja", "Pupkin");
        userDAO.create(userToCreate);

        User userToRecieve = userDAO.getByLogin("Login");
        assertEquals(userToCreate, userToRecieve);
    }

    @Test
    public void testCreate() throws Exception {
        User userToCreate = new User("Login", "123", "Vasja", "Pupkin");
        userDAO.create(userToCreate);

        User userToRecieve = userDAO.getById(userToCreate.getId());
        assertEquals(userToCreate, userToRecieve);
    }
}