package com.jowl.feign.controllers;

import com.jowl.feign.bootstrap.AppUserLoader;
import com.jowl.feign.clients.UserClient;
import com.jowl.feign.feignconfig.UserClientConfiguration;
import com.jowl.feign.models.User;
import com.jowl.feign.models.UserBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@SpringBootTest
public class UserClientConfigurationTest {
    private Logger LOGGER = LoggerFactory.getLogger(AppUserLoader.class);

    private UserClient userClient;

    @Before
    public void setup() {
        UserClientConfiguration feignClientBuilder = new UserClientConfiguration();
        userClient = feignClientBuilder.getUserClient();
    }

    @Test
    public void givenUserClientShouldRunSuccessfully() throws Exception {
        List<User> users = userClient.findAll();
        assertTrue(users.size() >= 2);
        LOGGER.info("{}", users);
    }

    @Test
    public void givenUserClientShouldFindOne() throws Exception {
        User user = userClient.findByEmail("john@gmail.com");
        assertThat(user.getFirstName(), containsString("John"));
        LOGGER.info("{}", user);
    }

    @Test
    public void givenUserClientShouldFindOneById() throws Exception {
        User user = userClient.findById(1);
        assertNotNull(user);
        LOGGER.info("{}", user);
    }


    /**
     * After first run same user creation fails ignore this test
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void givenUserClientShouldSaveUser() throws Exception {
        User user = new UserBuilder()
                .setFirstName("ibrahim")
                .setLastName("Karayel")
                .setDisplayName("ibrahim Karayel")
                .setEmail("ikarayel@gmail.com")
                .setPassword("$2a$10$RT09hYLCZTRTnqNpvhSm/.w5zkKkb9jlcckoL/gNTliWJuNgZznnK")
                .createUser();
        User created = userClient.create(user);
        assertEquals("ibrahim", created.getFirstName());
        assertNotNull(created.getUserId());
        LOGGER.info("{}", created);
    }
}
