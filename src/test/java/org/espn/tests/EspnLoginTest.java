package org.espn.tests;

import org.espn.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnLoginTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void EspnLoginTest(String email, String password) throws InterruptedException {
        HomePage homePage = new HomePage(driver.getDriver());
        homePage.clickGlobalUserMenu();
        homePage.clickLoginOption();
        homePage.changeToIframe();
        checkThat("ESPN Logo Is Present And Visible", homePage.checkEspnLogoIsPresent(), is(true));
        checkThat("Sing Up Button Is Present And Visible", homePage.checkSingUpButtonIsPresent(), is(true));
        checkThat("Login Button Is Present And Visible", homePage.checkLoginButtonIsPresent(), is(true));
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
        homePage.goToWatchPage();
        WatchPage watchPage = new WatchPage(driver.getDriver());
        checkThat("There is at least one carousel displayed", watchPage.checkCarouselIsPresent(), is(true));
        watchPage.clickSecondCarouselCard();
       // watchPage.switchToCarouselPopUp();
        checkThat("The close button in the carousel pop up is present and visible", watchPage.checkCarouselCloseBottomPopUpIsPresent(), is(true));
        watchPage.clickCloseButtonCarouselPopUp();
        //watchPage.goToBasePage();

        watchPage.returnToMainPage();
       // watchPage.returnToHomePage();
        HomePage homePage2 = new HomePage(driver.getDriver());
        homePage2.hoverGlobalUserMenu();
        checkThat("User Menu has a welcome message with the name of the user", homePage2.checkNavUserMenuWelcomeText(WelcomeMessage), is(true));
        homePage2.clickLogOutButton();
        //HomePage homePage3 = new HomePage(driver.getDriver());
        //homePage3.hoverGlobalUserMenu();
        //checkThat("User Menu has a welcome message without the name of the user", homePage2.checkNavUserMenuWelcomeText(WelcomeMessage), is(false));

    }
}
