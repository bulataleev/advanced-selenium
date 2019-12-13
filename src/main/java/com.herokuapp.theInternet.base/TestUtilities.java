package com.herokuapp.theInternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

    protected void sleep(long msec){
        try{
            Thread.sleep(msec);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    @DataProvider(name="files")
    protected static Object[][] files() {
        return new Object[][] {
                {1,"index.html"},
                {2,"logo.png"},
                {3,"text.txt"}
        };
    }
}
