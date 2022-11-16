package org.espn.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "global-header")
    private WebElement globalHeader;

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy(css = "body.index.desktop.page-context-top.qa:nth-child(2) div.hidden-print:nth-child(3) header.espn-en.user-account-management.has-search nav:nth-child(3) ul.espn-en li.pillar.watch:nth-child(11) > a:nth-child(1)")
    private WebElement watchButton;

    @FindBy(css = "input[type='email']")
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
    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginUserMenuOption;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogOutButton;

    @FindBy(css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeText;

    @FindBy(css = "li:nth-child(2) a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfile;

    String SettingsIframe = "oneid-iframe";

    @FindBy(id = "AccountDeleteLink")
    private WebElement DeactivateAccountLink;

    @FindBy(css = "#TextBlock + #BtnSubmit")
    private WebElement DeactivateAccountConfirmationButton;

    @FindBy(xpath = "root > div:nth-child(3) > div > div > div:nth-child(1)")
    private WebElement DeactivateModalMessageWindow;

    @FindBy(css = "section.PromoBanner")
    private WebElement promoBanner;

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement promoBannerIframe;
    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement promoBannerCloseButton;
    @FindBy(id = "#sideLogin-left-rail")
    private WebElement smallLoginFrame;
    @FindBy(css = "div.view-starry-night > div:first-child")
    private WebElement loginModalIframe;

    @FindBy (css = "li.user > div.global-user:last-child")
    private WebElement userOptionsForLogin;

    @FindBy(css = "#TextError + #BtnSubmit")
    private WebElement clickDeactivateConfirmation;
    @FindBy (css = ".account-deleted-gating + #Title")
    private  WebElement deleteAccountTitle;

    public HomePage(WebDriver driver) {
        super(driver);
        String home = this.getDriver().getCurrentUrl();
    }

    public void clickGlobalUserMenu() {
        clickElement(userIcon);
    }

    public void clickWatchButton() {
        clickElement(watchButton);
    }

    public WatchPage goToWatchPage() {
        clickWatchButton();
        return new WatchPage(getDriver());
    }

    public boolean isBannerVisible() {
        boolean bannerIsVisible = true;
        try {
            super.waitForVisibility(this.promoBanner);
        } catch (TimeoutException e) {
            bannerIsVisible = false;
        }
        return bannerIsVisible;
    }
    public void closeBanner() {
        if (this.isBannerVisible()) {
            super.clickElement(this.promoBannerCloseButton);
        }
    }
    public void switchToBannerIframe() {
        super.getDriver().switchTo().frame(this.promoBannerIframe);
    }

    public void exitBannerIframe() {
        super.getDriver().switchTo().defaultContent();
    }



    public void mouseHoverUserIcon() {
        super.mouseHover(this.userIcon);
        super.waitForVisibility(this.userOptionsForLogin);
    }

    public void changeToLoginIframe() {
        getDriver().switchTo().frame(loginIframe);
    }

    public boolean checkEspnLogoIsPresent() {
        return EspnLogo.isDisplayed();
    }

    public boolean checkSingUpButtonIsPresent() {
        return SingUpButton.isDisplayed();
    }

    public boolean checkLoginButtonIsPresent() {
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
    public void exitIframe() {
        super.getDriver().switchTo().defaultContent();
    }



    public void waitForMouseOverUserIcon() {
        if (waitForReload(this.userIcon)) {
            waitForVisibility(this.userIcon);
        }
    }

    public String verifyWelcomeText() {
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }

    public void clickLogOutButton() {
        clickElement(LogOutButton);
    }


    public void refreshPage() {
        getDriver().navigate().refresh();
    }


    public void clickEspnProfile() {
        clickElement(espnProfile);
    }

    public void clickDeactivateAccountLink() {
        clickElement(DeactivateAccountLink);
    }

    public void clickDeactivateAccountButton() {
        clickElement(DeactivateAccountConfirmationButton);
    }
    public void clickDeactivateConfirmation(){
        super.clickElement(this.clickDeactivateConfirmation);
    }

    public String getDeleteAccountTitleText() {
        super.waitForVisibility(deleteAccountTitle);
        return this.deleteAccountTitle.getText();
    }


}
