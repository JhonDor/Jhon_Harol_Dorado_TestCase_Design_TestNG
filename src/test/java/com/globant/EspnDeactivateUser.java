package com.globant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EspnDeactivateUser {
    public Logger log = LoggerFactory.getLogger(EspnDeactivateUser.class);

    @BeforeMethod
    public void verifyUser() {
        log.info("Verify the user exist");
    }

    @Test
    public void deactivateUser() {
        log.info("Go to the users control panel");
        log.info("Search the user you want to deactivate");
        log.info("Select the correct user to deactivate");
        log.info("Confirm the deactivation");
        log.info("Click done");
    }
}
