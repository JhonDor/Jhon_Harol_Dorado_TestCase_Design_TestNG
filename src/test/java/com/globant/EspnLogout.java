package com.globant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EspnLogout {
    public Logger log = LoggerFactory.getLogger(EspnLogout.class);

    @BeforeMethod
    public void VerifyUserLogged() {
        log.info("Verify a user is logged in");
        System.out.println();
    }

    @Test
    public void logout() {
        log.info("Click on the person icon");
        log.info("Click exit");
        log.info("Ensure that the logout has been successful");
        System.out.println();
    }
}