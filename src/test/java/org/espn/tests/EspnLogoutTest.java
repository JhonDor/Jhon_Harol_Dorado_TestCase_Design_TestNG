package org.espn.tests;

import org.espn.pages.HomePage;
import org.espn.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLogoutTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void logOutTest(String email, String password) {
        HomePage homePage = new HomePage(driver.getDriver());
        homePage.clickGlobalUserMenu();

        homePage.clickLoginOption();
        LoginPage loginPage = new LoginPage(driver.getDriver());
        homePage.changeToIframe();
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
        HomePage mainPage2 = new HomePage(driver.getDriver());
        mainPage2.hoverGlobalUserMenu();

        homePage.clickLogOutButton();
        HomePage mainPage3 = new HomePage(driver.getDriver());
        mainPage3.hoverGlobalUserMenu();

        checkThat("User Menu has a welcome message without the name of the user", homePage.checkNavUserMenuWelcomeText(WelcomeMessage), is(false));
        checkThat("Login Button Is Present And Visible", homePage.checkLogInButtonIsPresent(), is(true));
    }
}