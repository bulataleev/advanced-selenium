package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private Logger log;

    public LoginPage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }
}
