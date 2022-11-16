package org.espn.utils;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "loginCredentials")
    public static Object[][] inputData() {
        return new Object[][]{{"test1037@gmail.com", "123espn"}};
    }
}
