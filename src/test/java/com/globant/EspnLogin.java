package com.globant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import resources.DataProvider;

public class EspnLogin extends DataProvider {
    public Logger log = LoggerFactory.getLogger(EspnLogin.class);

    @Test(dataProvider = "loginInfo")
    public void login(String email, String password){
        log.info("Click the person icon");
        log.info("Click in sig in");
        log.info("Type " + email + " in the user name or email field");
        log.info("Type " +password + " in the password field");
        log.info("Click on the connect button");
        log.info("Verify the credentials provided match with a existing user");
        log.info("Ensure that the login has been successful");
        System.out.println();
    }
}
