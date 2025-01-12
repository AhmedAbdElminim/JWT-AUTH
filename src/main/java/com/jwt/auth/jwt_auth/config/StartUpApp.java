package com.jwt.auth.jwt_auth.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class StartUpApp implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //log.error("The error occeue here");
    }

}
