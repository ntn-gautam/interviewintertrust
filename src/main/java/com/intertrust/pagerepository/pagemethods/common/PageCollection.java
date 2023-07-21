package com.intertrust.pagerepository.pagemethods.common;

import com.intertrust.pagerepository.pagemethods.landingpage.LandingPage;
import org.openqa.selenium.WebDriver;

public class PageCollection {

    private final WebDriver driver;

    public PageCollection(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        return new LandingPage(driver);
    }
}
