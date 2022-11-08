package com.globant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    public void OpenBrowser() {
        log.info("open the browser before starting the tests");
        System.out.println();
    }

    @BeforeSuite
    public void cleanCookies() {
        log.info("Click the lock icon on the left side of the search bar");
        log.info("Click cookies");
        log.info("Confirm that esp.com.co is selected");
        log.info("Click confirm");
        log.info("Click done");
        System.out.println();
    }

    @BeforeSuite
    public void clearCache() {
        log.info("Navigate to chrome://settings/clearBrowserData’");
        log.info("Clear Data button to clear the cache");
        System.out.println();
    }
    @BeforeSuite
    public void goToWebsite(){
        log.info("Navigate to https://www.espnqa.com/?_adbock=true&src=com&espn=cloud");
        System.out.println();
    }

    @AfterSuite
    public void closeBrowser() {
        log.info("Close the browser after finishing the suit");
    }

}
