package ui;

import com.intertrust.driver.Driver;
import org.testng.annotations.Test;

public class LandingPageTest extends Driver {

    private String cityName = "Gurgaon";
    private String headerText = "Weather Forecast for ";


    @Test(priority = 1, description = "To verify weather forecast for your city is shown")
    public void testLandingPage() {
        try {
            pages.getLandingPage().acceptCookies();
            pages.getLandingPage().selectWeatherDataTab();
            String url = pages.getLandingPage().getUrl();
            assertCheck.append(actions.assertEqualsBoolean(url.contains("/weather-data"), true, "Landing page url Matched", "Landing page url NOT Matched"));
            pages.getLandingPage().enterText(cityName);
            pages.getLandingPage().clickSearchIcon();
            String url1 = pages.getLandingPage().getUrl();
            assertCheck.append(actions.assertEqualsBoolean(url1.contains(cityName), true, "Landing page url Matched", "Landing page url NOT Matched"));
            pages.getLandingPage().click15DaysForecast();
            String headerText1 = pages.getLandingPage().getHeaderText1();
            String headerText2 = pages.getLandingPage().getHeaderText2();
            assertCheck.append(actions.assertEqualsString(headerText1, headerText + cityName, "", ""));
            assertCheck.append(actions.assertEqualsBoolean(pages.getLandingPage().isCurrentlySection(), true, "Currently Section is Visible", "Currently Section is NOT Visible"));
            assertCheck.append(actions.assertEqualsBoolean(pages.getLandingPage().isThreeDaysOutlook(), true, "Three Days Outlook is Visible", "Three Days Outlook is NOT Visible"));
            assertCheck.append(actions.assertEqualsBoolean(pages.getLandingPage().isHourlyForecast(), true, "Hourly Forecast Section is Visible", "Hourly Forecast is NOT Visible"));
            assertCheck.append(actions.assertEqualsBoolean(pages.getLandingPage().isLongTermOutlook(), true, "Long Term Outlook is Visible", "Long Term Outlook is NOT Visible"));
            actions.assertAllFoundFailedAssert(assertCheck);
        } catch (Exception e) {
            commonLib.error("Error in Method name testLandingPage " + e.getMessage());
        }

    }

}
