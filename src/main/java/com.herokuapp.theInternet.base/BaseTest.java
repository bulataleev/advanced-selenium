package com.herokuapp.theInternet.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String baseTestParam;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        String testName = testContext.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        // Create driver
        log.info("Create driver: " + browser);

        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser, log);
        driver=driverFactory.createDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
