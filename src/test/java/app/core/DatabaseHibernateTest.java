package app.core;

import app.config.SuggestionBoxApplication;
import app.core.services.DatabasePopulationService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vladislav on 12/25/2015.
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SuggestionBoxApplication.class})
@Transactional
@ActiveProfiles("test")
public abstract class DatabaseHibernateTest {
//    @Autowired protected DatabasePopulationService dbPopulationService;

//    @Before
//    public void cleanDatabase(){
//        dbPopulationService.clearDatabase();
//    }

}
