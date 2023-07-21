package com.intertrust.pagerepository.pagemethods.landingpage;

import com.intertrust.pagerepository.pagelocators.LandingPageElements;
import com.intertrust.pagerepository.pagemethods.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    LandingPageElements elements;

    public LandingPage(WebDriver driver) {
        super(driver);
        elements = PageFactory.initElements(driver, LandingPageElements.class);
    }

    /**
     * This method is used to accept cookies modal
     */
    public void acceptCookies() {
        try {
            click(elements.cookiesModal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will select the wether data from the nav bar
     */
    public void selectWeatherDataTab() throws InterruptedException {
        click(elements.weatherDataTab);
    }

    /**
     * This method will return you the current url
     *
     * @return the url
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * This method will be used to enter text in search box under weather data tab
     */
    public void enterText(String text) throws InterruptedException {
        enterText(elements.searchBox, text);
    }

    /**
     * This method is used to click on search icon
     */
    public void clickSearchIcon() {
        try {
            click(elements.searchBtn);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * THis method is used to click on 15 days forecast btn
     */
    public void click15DaysForecast() {
        try {
            click(elements.fifteenDayForecast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to return header text
     *
     * @return the text
     */
    public String getHeaderText1() {
        return getText(elements.heading1);
    }

    /**
     * This method is used to return header text
     *
     * @return the text
     */
    public String getHeaderText2() {
        return getText(elements.heading2);
    }

    /**
     * This method is used is currently section visible or not
     *
     * @return return true or false
     */
    public boolean isCurrentlySection() {
        return isDisplayed(elements.currentlySection);
    }

    /**
     * This method is used is three days outlook visible or not
     *
     * @return return true or false
     */
    public boolean isThreeDaysOutlook() {
        return isDisplayed(elements.threeDaysOutlook);
    }

    /**
     * This method is used is hourly forecast visible or not
     *
     * @return return true or false
     */
    public boolean isHourlyForecast() {
        return isDisplayed(elements.threeDaysOutlook);
    }

    /**
     * This method is used is long term outlook visible or not
     *
     * @return return true or false
     */
    public boolean isLongTermOutlook() {
        return isDisplayed(elements.longTermOutlook);
    }
}
