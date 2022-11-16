package org.espn.tests;

import org.espn.pages.HomePage;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class EspnDeactivateAccountTest extends BaseTest {

    @Test(dataProvider = "loginCredentials")
    public void EspnDeactivateAccountTest(String email, String password) {
        HomePage homePage = new HomePage(driver.getDriver());
        homePage.clickGlobalUserMenu();
        homePage.clickLoginOption();
        homePage.changeToLoginIframe();
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
        homePage.exitIframe();
        homePage.waitForMouseOverUserIcon();
        homePage.mouseHoverUserIcon();
        homePage.clickEspnProfile();
        homePage.changeToLoginIframe();
        homePage.clickDeactivateAccountLink();
        homePage.clickDeactivateAccountButton();
        homePage.clickDeactivateConfirmation();
        homePage.clickGlobalUserMenu();
        homePage.clickLoginOption();
        homePage.changeToLoginIframe();
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
        checkThat("Verify that deactivated text is correct", homePage.getDeleteAccountTitleText(), CoreMatchers.is("Account Deactivated"));

    }
}