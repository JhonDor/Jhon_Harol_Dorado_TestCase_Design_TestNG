package com.globant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EspnLogout {
    public Logger log = LoggerFactory.getLogger(EspnLogout.class);

    @BeforeTest
    public void VerifyUserLogged() {
        log.info("Verify a user is logged in");
    }

    @Test
    public void logout() {
        log.info("Click on the person icon");
        log.info("Click exit");
        log.info("Ensure that the logout has been successful");
    }
}