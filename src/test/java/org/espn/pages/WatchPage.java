package org.espn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class WatchPage extends HomePage {
String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    @FindBy(css = "section.Carousel")
    private List<WebElement> carousel;

    @FindBy(css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCarouselCard;

    @FindBy(css = "section.lightbox__contentBox")
    private WebElement CarouselPopUp;

    @FindBy(css = "#fittPortal_0  > div > div > section > header > button")
    private WebElement CloseButtonCarouselPopUp;
    @FindBy(css =".WatchListingsVideo__BackBtn")
    private WebElement closeVideoPopUp;


    public Boolean checkCarouselIsPresent() {
        return carousel.size() > 0;
    }

    public void clickSecondCarouselCard() {
        clickElement(secondCarouselCard);
    }

    public boolean checkCloseButtonCarouselPopUp() {
        waitForVisibility(CloseButtonCarouselPopUp);
        return CloseButtonCarouselPopUp.isDisplayed();
    }

    public void clickCloseButtonCarouselPopUp() {
        clickElement(CarouselPopUp);
    }
    public WatchPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getCarouselCards() {
        return carousel.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }
    public boolean verifyCardsTitle() {
        List<Boolean> title = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCarouselCards().stream().forEach(element -> {
            title.add(element.findElement(By.cssSelector("h2.WatchTile__Title")).isDisplayed() && !element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return !title.contains(false);
    }

    public boolean verifyCardsDescription() {
        List<Boolean> description = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCarouselCards().stream().forEach(element -> {
            description.add(element.findElement(By.cssSelector(".WatchTile__Meta")).isDisplayed() && !element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return !description.contains(false);
    }


    public HomePage returnToHomePage(){
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }


}

