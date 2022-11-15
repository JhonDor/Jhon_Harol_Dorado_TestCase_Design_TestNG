package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WatchPage extends HomePage {

    @FindBy(css = "section.Carousel")
    private List<WebElement> carousel;

    @FindBy(css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCarouselCard;

    @FindBy(css = "section.lightbox__contentBox")
    private WebElement CarouselPopUp;

    @FindBy(css = "#fittPortal_0  > div > div > section > header > button")
    private WebElement CloseButtonCarouselPopUp;

    public Boolean checkCarouselIsPresent() {
        return carousel.size() > 0;
    }

    public void clickSecondCarouselCard() {
        clickElement(secondCarouselCard);
    }

    public boolean checkCarouselCloseBottomPopUpIsPresent() {
        waitForVisibility(CloseButtonCarouselPopUp);
        return CloseButtonCarouselPopUp.isDisplayed();
    }

    public void clickCloseButtonCarouselPopUp() {
        clickElement(CloseButtonCarouselPopUp);
    }
    public WatchPage(WebDriver driver) {
        super(driver);
    }
    public void goToHomePage() {
        super.goToPreviousPage();
    }

    public void returnToMainPage() throws InterruptedException {

        getDriver().navigate().back();

    }
    public HomePage returnToMainPage2() {
        getDriver().navigate().back();
        return new HomePage(getDriver());
    }

    public void returnToMainPage3() {
        super.goToPreviousPage();
    }

    public HomePage returnToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }



    public void switchToCarouselPopUp(){
        String MainWindow = getDriver().getWindowHandle();
        waitForVisibility(CarouselPopUp);

        Set<String> windowHandles = getDriver().getWindowHandles();
        Iterator<String> i = windowHandles.iterator();

        while (i.hasNext()) {
            String ChildWindow = i.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);

                getDriver().close();
            }
        }
        getDriver().switchTo().window(MainWindow);
    }
}

