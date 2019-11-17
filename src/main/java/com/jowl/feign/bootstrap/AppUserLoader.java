package com.jowl.feign.bootstrap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
@Profile("dev")
public class AppUserLoader implements CommandLineRunner {

    private Logger LOGGER = LoggerFactory.getLogger(AppUserLoader.class);

    @Override
    public void run(String... args) throws Exception {

    }
}
