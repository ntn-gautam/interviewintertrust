package api;

import com.intertrust.commonutils.model.response.VisualCrossingWebServices;
import com.intertrust.driver.Driver;
import org.testng.annotations.Test;

public class VisualCrossingAPITest extends Driver {

    private static final String CITY_NAME = "Gurgaon";
    private static final String WRONG_CITY_NAME = "TEST";
    private static final String LATITUDE = "28.4774";
    private static final String LONGITUDE = "77.0691";
    private static final String RESOLVED_ADDRESS = "Gurugram, HR, India";


    @Test(priority = 1)
    public void testVisualCrossingAPI() {
        try {
            VisualCrossingWebServices crossingWebServices = api.getCrossingWebServices(CITY_NAME, 200);
            String address = crossingWebServices.address;
            double latitude = crossingWebServices.latitude;
            double longitude = crossingWebServices.longitude;
            String resolvedAddress = crossingWebServices.resolvedAddress;
            assertCheck.append(actions.assertEqualsString(address, CITY_NAME, "Address Parameter Matched", "Address Parameter NOT Matched"));
            assertCheck.append(actions.assertEqualsString(String.valueOf(latitude), LATITUDE, "Latitude Parameter Matched", "Latitude Parameter NOT Matched"));
            assertCheck.append(actions.assertEqualsString(String.valueOf(longitude), LONGITUDE, "Longitude Parameter Matched", "Longitude Parameter NOT Matched"));
            assertCheck.append(actions.assertEqualsString(resolvedAddress, RESOLVED_ADDRESS, "Resolved Address Parameter Matched", "Resolved Address Parameter NOT Matched"));
            actions.assertAllFoundFailedAssert(assertCheck);
        } catch (Exception e) {
            commonLib.error("Exception in method testVisualCrossingAPI " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testVisualCorssingAPIWithWrongData() {
        try {
            VisualCrossingWebServices crossingWebServices = api.getCrossingWebServices(WRONG_CITY_NAME, 400);
        } catch (Exception e) {
            commonLib.error("Exception in method testVisualCorssingAPIWithWrongData " + e.getMessage());
        }
    }

}
