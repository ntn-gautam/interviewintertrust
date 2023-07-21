package com.intertrust.commonutils.restutils;

import com.intertrust.driver.Driver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestCommonUtils extends Driver {

    public static Response response;
    private static RequestSpecification request;
    private static final String CALLING_API = "Calling API";
    private static final String APPLICATION_JSON = "application/json";

    /**
     * This method is used to hit CS Portal API which are using GET Method with Query Params and status Code
     *
     * @param endPoint   the endpoint
     * @param queryParam the query param
     */
    public static void commonGetMethodWithQueryParam(String endPoint, Map<String, Object> queryParam, int statusCode) {
        commonGetMethodWithQueryParam(endPoint, queryParam, baseAPIUrl, statusCode);
    }

    /**
     * This Method is used to hit the SR API which are using GET Method with Query Params and status Code
     *
     * @param endPoint   send the endPoint
     * @param queryParam send query param used for API
     */
    public static void commonGetMethodWithQueryParam(String endPoint, Map<String, Object> queryParam, String url,int statusCode) {
        try {
            commonLib.info(CALLING_API + " " + endPoint);
            baseURI = url;
            request = given()
                    .contentType(APPLICATION_JSON);
            commonLib.info("Query Param Map:-" + queryParam.toString());

            StringBuilder stringBuilder = new StringBuilder("?");
            queryParam.forEach((k, v) -> stringBuilder.append(k).append("=").append(v).append("&"));
            endPoint += stringBuilder.toString();
            endPoint.substring(0, endPoint.length() - 1);
            System.out.println(endPoint);
            response = request.get(endPoint);
            System.out.println(response.toString());
            int statusCode1 = response.getStatusCode();
            Assert.assertEquals(statusCode1, statusCode , "Correct status code returned");
        } catch (Exception | AssertionError e) {
            commonLib.error("Caught exception in Testcase - commonGetMethodWithQueryParam " + e.getMessage());
        }
    }
}
