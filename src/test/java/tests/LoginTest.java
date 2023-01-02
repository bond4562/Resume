package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(
            testName = "проверка логина")
    public void test07() {
        final String expURL = "https://reignofguilds.com/";

        LoginPage loginPage = openBaseURL()
                .clickButtonLogin()
                .signInAsRegularUser();

        String actURL = loginPage.getCurrentURL();

        assertEquals(actURL, expURL);
    }


}
