package com.example;

import app.config.SuggestionBoxApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SuggestionBoxApplication.class)
@WebAppConfiguration
public class SuggestionBoxApplicationTests {

	@Test
	public void contextLoads() {
	}

}
