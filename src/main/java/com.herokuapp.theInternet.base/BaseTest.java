package com.herokuapp.theInternet.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTest {


    protected WebDriver driver;
    protected Logger log;
    protected String baseTestParam;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext testContext) {
        String testName = testContext.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        // Create driver
        log.info("Create driver: " + browser);

        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser, log);
        driver=driverFactory.createDriver();

        driver.manage().window().maximize();
        this.testSuiteName = testContext.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
