package com.intertrust.driver;

import com.intertrust.api.RequestSource;
import com.intertrust.commonutils.action.AssertActions;
import com.intertrust.commonutils.applicationutils.constants.ApplicationConstant;
import com.intertrust.commonutils.applicationutils.constants.ConstantUtils;
import com.intertrust.commonutils.commonlib.CommonLib;
import com.intertrust.pagerepository.pagemethods.common.PageCollection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * 1. Open VisualCrossing URL: https://www.visualcrossing.com
 */

public class Driver {

    public static WebDriver driver;
    private static String browser = null;
    private static String baseUrl;
    public static StringBuilder assertCheck;
    public static PageCollection pages;
    public static ConstantUtils constants = ConstantUtils.getInstance();
    public static final CommonLib commonLib = new CommonLib();
    public static final AssertActions actions = new AssertActions();
    public static final RequestSource api = new RequestSource();
    public static String baseAPIUrl;


    @BeforeSuite(alwaysRun = true)
    public static void setup(ITestContext tr) {
        urlSetup();
        if (!(getClassName(tr).contains("api"))) {
            startBrowser(browser);
        }
    }

    @BeforeClass(alwaysRun = true)
    public static void pageSetup() {
        initializePage();
    }

    @BeforeMethod(alwaysRun = true)
    public static void methodSetup() {
        assertCheck = new StringBuilder();
    }

    @AfterSuite(alwaysRun = true)
    public void closeReport(ITestContext tr) {
        if (!(getClassName(tr).contains("api"))) {
            driver.close();
            if (driver != null) {
                driver.quit();
            }
        }
    }

    /**
     * This method is used to set up the urls
     */
    private static void urlSetup() {
        browser = constants.getValue(ApplicationConstant.WEB_BROWSER);
        baseUrl = constants.getValue(ApplicationConstant.BASE_URL);
        baseAPIUrl = constants.getValue(ApplicationConstant.API_BASE);
    }

    /**
     * @param browser the browser
     */
    private static void startBrowser(String browser) {

        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    browserCapabilities();
                    openBaseUrl(baseUrl);
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method is used to set or customize the Chrome browser
     */
    private static void browserCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * This method is used to open your browser
     *
     * @param baseUrl the url
     */
    private static void openBaseUrl(String baseUrl) {
        driver.get(baseUrl);
    }

    /**
     * This method is used to initialize all the pages
     */
    private static void initializePage() {
        try {
            pages = new PageCollection(driver);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method will give the class name
     *
     * @param tr
     * @return
     */
    public static String getClassName(ITestContext tr) {
        return tr.getAllTestMethods()[0].getInstance().toString();
    }

}
