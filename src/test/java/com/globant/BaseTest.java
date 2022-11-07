package com.globant;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

public class BaseTest {
    public  Logger log = LoggerFactory.getLogger(BaseTest.class);

    @DataProvider(name ="loginInfo")
    public static Object [][] inputData(){
        return new Object[][] {{"email1@gmail.com", "password1"}, {"email2@gmail.com", "password2"}};
    }
    @BeforeSuite
    public void OpenBrowser(){
        log.info("open the browser before starting the tests");
        log.info("Go to https://www.espn.com.co/");
        System.out.println();
    }
    @AfterSuite
    public void cleanCookies(){
        log.info("Click the lock icon on the left side of the search bar");
        log.info("Click cookies");
        log.info("Confirm that esp.com.co is selected");
        log.info("Click confirm");
        log.info("Click done");
    }
    @AfterSuite
    public void closeBrowser(){
        log.info("Close the browser after finishing the test");
    }

}
