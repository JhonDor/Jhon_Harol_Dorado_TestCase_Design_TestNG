package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

public class HomePage extends BasePage{

    @FindBy(id = "global-header")
    private WebElement globalHeader;

    @FindBy(id = "global-user-trigger")
    private WebElement globalUserMenu;

    @FindBy(css = "body.index.desktop.page-context-top.qa:nth-child(2) div.hidden-print:nth-child(3) header.espn-en.user-account-management.has-search nav:nth-child(3) ul.espn-en li.pillar.watch:nth-child(11) > a:nth-child(1)")
    private WebElement watchButton;

    @FindBy(css="input[type='email']")
    private WebElement EmailInput;

    @FindBy(id = "InputPassword")
    private WebElement PasswordInput;

    @FindBy(id = "BtnSubmit")
    private WebElement LoginButton;

    @FindBy(id = "logo")
    private WebElement EspnLogo;

    @FindBy(id = "BtnCreateAccount")
    private WebElement SingUpButton;

    String loginIframe = "oneid-iframe";
    @FindBy(css="div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuOption;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy (css = "#global-viewport > div.global-user > div > ul.account-management > li.display-user")
    private WebElement NavUserMenuWelcomeText;

    @FindBy(css="li:nth-child(2) a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfile;

    String SettingsIframe = "oneid-iframe";

    @FindBy(id="AccountDeleteLink")
    private WebElement DeactivateAccountButton;

    @FindBy(id="BtnSubmit")
    private WebElement DeactivateAccountConfirmationButton;

    @FindBy(xpath = "root > div:nth-child(3) > div > div > div:nth-child(1)")
    private WebElement DeactivateModalMessageWindow;

    @FindBy(id = "BtnSubmit")
    private WebElement DeactivateModalMessageWindowButtonConfirmation;


    public HomePage(WebDriver driver) {
        super(driver);
        String home = this.getDriver().getCurrentUrl();
    }

    public void clickGlobalUserMenu() {
        clickElement(globalUserMenu);
    }

    public void clickWatchButton() {
        clickElement(watchButton);
    }

    public WatchPage goToWatchPage() {
        clickWatchButton();
        return new WatchPage(getDriver());
    }

    public void hoverGlobalUserMenu() {
        waitForVisibility(globalUserMenu);
        hoverElement(globalUserMenu);
    }
    public void changeToIframe(){
        getDriver().switchTo().frame(loginIframe);
    }

    public boolean checkEspnLogoIsPresent(){
        return EspnLogo.isDisplayed();
    }

    public boolean checkSingUpButtonIsPresent(){
        return SingUpButton.isDisplayed();
    }

    public boolean checkLoginButtonIsPresent(){
        return LoginButton.isDisplayed();
    }

    public void clickEmailInput() {
        clickElement(EmailInput);
    }

    public void clickPasswordInput() {
        clickElement(PasswordInput);
    }

    public void typeEmailInput(String text) {
        typeOnInput(EmailInput, text);
    }

    public void typePasswordInput(String text) {
        typeOnInput(PasswordInput, text);
    }

    public void clickLoginButton() {
        clickElement(LoginButton);
    }

    public void clickLoginOption() {
        clickElement(loginUserMenuOption);
    }

    public boolean checkNavUserMenuWelcomeText(String text) {
        return NavUserMenuWelcomeText.getText().contains(text);
    }

    public void clickLogOutButton() {
        clickElement(LogOutButton);
    }

    public boolean checkLogInButtonIsPresent(){
        return loginUserMenuOption.isEnabled();
    }

    public void clickEspnProfile() {
        clickElement(espnProfile);
    }

    public void changeToSettingsIframe(){
        getDriver().switchTo().frame(SettingsIframe);
    }

    public void clickDeactivateAccountButton() {
        clickElement(DeactivateAccountButton);
    }

    public void clickDeactivateAccountConfirmationButton() {
        clickElement(DeactivateAccountConfirmationButton);
    }
    String PrincipalWindow = getDriver().getWindowHandle();
    public void switchToConfirmationDeactivatePopUp(){
        waitForVisibility(DeactivateModalMessageWindow);

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!PrincipalWindow.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);

                getDriver().close();
            }
        }
        getDriver().switchTo().window(PrincipalWindow);
    }

    public boolean checkDeactivateModalMessageWindowIsPresent(){
        return DeactivateModalMessageWindow.isDisplayed();
    }

    public void clickDeactivateModalMessageWindowButtonConfirmation() {
        clickElement(DeactivateModalMessageWindowButtonConfirmation);
    }






}
