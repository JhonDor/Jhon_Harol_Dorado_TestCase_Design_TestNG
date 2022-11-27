package org.espn.tests;

import static java.lang.String.format;

import org.espn.pages.HomePage;
import org.espn.utils.DataProvider;
import org.hamcrest.Matcher;
import org.espn.pages.BasePage;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.espn.configuration.Driver;
import org.espn.reporting.Reporter;

public class BaseTest extends DataProvider {

    public static Driver driver;
    protected HomePage homePage;
    protected final String userName = "Test";
    protected final String WelcomeMessage = "Welcome" + userName + "!";

    @Parameters({"browser", "url"})
    @BeforeTest()
    public void testSetup(String browser, String url) {
        driver = new Driver(browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
        homePage.dismissBanner();

    }

    @AfterTest
    public void tearDown() {
        Reporter.info("Closing browser");
        driver.getDriver().quit();
    }

        protected <T> void checkThat (String description, T actualValue, Matcher<? super T>  expectedValue){
            Reporter.info(
                    format("Checking that " + description.toLowerCase() + "[Expectation: %s]", expectedValue));
            try {
                MatcherAssert.assertThat(actualValue, expectedValue);
            } catch (AssertionError e) {
                Reporter.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("/n", "")));
            }
        }

}
