package org.espn.tests;

import org.espn.pages.HomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class EspnDeactivateAccountTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void EspnDeactivateAccountTest(String email, String password) {
        HomePage homePage = new HomePage(driver.getDriver());
        homePage.clickGlobalUserMenu();
        //UserPage userPage = new UserPage(driver.getDriver());
        homePage.clickLoginOption();
        //LoginPage loginPage = new LoginPage(driver.getDriver());
        homePage.changeToIframe();
        homePage.clickEmailInput();
        homePage.typeEmailInput(email);
        homePage.clickPasswordInput();
        homePage.typePasswordInput(password);
        homePage.clickLoginButton();
       // HomePage mainPage2 = new HomePage(driver.getDriver());
        homePage.hoverGlobalUserMenu();
        //UserPage userPage2 = new UserPage(driver.getDriver());
        homePage.clickEspnProfile();
        homePage.changeToSettingsIframe();
        homePage.clickDeactivateAccountButton();
        homePage.clickDeactivateAccountConfirmationButton();


        /** TO WORK ON **/
        /** userPage2.switchToConfirmationDeactivatePopUp();
        checkThat("Deactivate modal message window is present", userPage2.checkDeactivateModalMessageWindowIsPresent(), is(true));
        userPage2.clickDeactivateModalMessageWindowButtonConfirmation(); **/

    }
}