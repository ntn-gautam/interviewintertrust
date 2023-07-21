package com.intertrust.pagerepository.pagelocators;

import org.openqa.selenium.By;

public class LandingPageElements {

    public final By cookiesModal = By.xpath("//button[text()='Accept all cookies']");
    public final By weatherDataTab = By.xpath("//*[@id='navbarNav']//a[text()='Weather Data']");
    public final By searchBox = By.xpath("//*[@id='wxlocation']");
    public final By searchBtn = By.xpath("//*[contains(text(),'Search')]");
    public final By fifteenDayForecast = By.xpath("//*[text()='15-Day Forecast']");
    public final By heading1 = By.xpath("//*[text()='Weather Forecast for ']");
    public final By heading2 = By.xpath("//*[text()='Weather Forecast for ']/a");
    public final By currentlySection = By.xpath("//*[text()='Currently']");
    public final By threeDaysOutlook = By.xpath("//*[text()='3 Day outlook']");
    public final By hourlyForecast = By.xpath("//*[text()='Hourly forecast']");
    public final By longTermOutlook = By.xpath("//*[text()='Long term outlook']");

}
