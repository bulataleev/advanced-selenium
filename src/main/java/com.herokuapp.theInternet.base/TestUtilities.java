package com.herokuapp.theInternet.base;

public class TestUtilities extends BaseTest {

    protected void sleep(long msec){
        try{
            Thread.sleep(msec);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
