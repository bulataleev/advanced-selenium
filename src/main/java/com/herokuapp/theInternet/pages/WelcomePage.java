package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
    private WebDriver driver;
    private Logger log;

    private By authenticationLocator = By.linkText("Form Authentication");

    private String pageURL = "https://the-internet.herokuapp.com/";

    public WelcomePage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }

    public void openPage(){
        log.info("opening the page: " + pageURL);
        driver.get(pageURL);
        if(driver.getCurrentUrl() == pageURL){
            log.info("Page is opened! ");
        }
    }

    public LoginPage clickAuthenticationForm(){
        log.info("clicking authentication form button");
        driver.findElement(authenticationLocator).click();
        return new LoginPage(driver,log);
    }
}
