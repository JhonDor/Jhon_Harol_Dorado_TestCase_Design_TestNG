package resources;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "loginInfo")
    public static Object[][] inputData() {
        return new Object[][]{{"email1@gmail.com", "password1"}};
    }
}
