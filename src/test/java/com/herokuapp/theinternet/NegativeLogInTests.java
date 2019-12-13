package com.herokuapp.theinternet;

import java.util.Map;

import com.herokuapp.theInternet.base.CsvDataProviders;
import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.LoginPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeLogInTests extends TestUtilities {


    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLogInTest(Map<String, String> testData) {
        // Data
        String no = testData.get("no");
        String username  = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting negativeLogInTest #" + no + " for " + description);

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // execute negative login
        loginPage.negativeLogIn(username, password);

        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
    }
}
