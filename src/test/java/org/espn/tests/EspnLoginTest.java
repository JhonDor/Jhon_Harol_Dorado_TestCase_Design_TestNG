package org.espn.tests;

import org.espn.pages.*;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLoginTest extends BaseTest{

    @Test(dataProvider = "loginCredentials")
    public void EspnLoginTest(String email, String password) {
        HomePage homePage = new HomePage(driver.getDriver());

        homePage.clickGlobalUserMenu();
        homePage.clickLoginOption();
        homePage.changeToLoginIframe();
        checkThat("ESPN Logo Is Present And Visible", homePage.checkEspnLogoIsPresent(), is(true));
        checkThat("Sing Up Button Is Present And Visible", homePage.checkSingUpButtonIsPresent(), is(true));
        checkThat("Login Button Is Present And Visible", homePage.checkLoginButtonIsPresent(), is(true));
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
        homePage.exitIframe();
        homePage.refreshPage();
        WatchPage watchPage = homePage.goToWatchPage();
        checkThat("Check that there is at least one carousel displayed", watchPage.checkCarouselIsPresent(), is(true));
        checkThat("Check that all the cards in the carousel have a title", watchPage.verifyCardsTitle(), CoreMatchers.is(true));
        checkThat("Check that all the cards in the carousel have a description", watchPage.verifyCardsDescription(), CoreMatchers.is(true));
        watchPage.clickSecondCarouselCard();
        checkThat("The close button in the carousel pop up is present and visible", watchPage.checkCloseButtonCarouselPopUp(), is(true));
        watchPage.clickCloseButtonCarouselPopUp();
        homePage.refreshPage();
        watchPage.returnToHomePage();
        homePage.mouseHoverUserIcon();
        checkThat("Welcome text is correct", homePage.verifyWelcomeText(), is(WelcomeMessage));
        homePage.clickLogOutButton();
        homePage.refreshPage();
        homePage.mouseHoverUserIcon();
        checkThat("User Menu has a welcome message without the name of the user", homePage.verifyWelcomeText(), is("Welcome!"));
    }
}
