package com.herokuapp.theinternet;

import com.herokuapp.theInternet.base.BaseTest;
import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.LoginPage;
import com.herokuapp.theInternet.pages.SecureAreaPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		// Verifications
		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
