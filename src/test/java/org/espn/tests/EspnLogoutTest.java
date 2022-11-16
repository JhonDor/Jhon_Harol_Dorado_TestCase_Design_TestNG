package org.espn.tests;

import org.espn.pages.HomePage;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;


public class EspnLogoutTest extends BaseTest {

    @Test(dataProvider = "loginCredentials")
    public void logOutTest(String email, String password) {
        HomePage homePage = new HomePage(driver.getDriver());
        homePage.clickGlobalUserMenu();
        homePage.clickLoginOption();
        homePage.changeToLoginIframe();
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
        homePage.mouseHoverUserIcon();
        homePage.clickLogOutButton();
        homePage.refreshPage();
        homePage.mouseHoverUserIcon();
        checkThat("Welcome text is correct", homePage.verifyWelcomeText(), CoreMatchers.is("Welcome!"));

    }
}