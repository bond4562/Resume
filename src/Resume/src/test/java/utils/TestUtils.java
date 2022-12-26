package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class TestUtils {

    private final static By MAIN_MENU = By.xpath("//div[@class='mainmenu']");
    private final static By ON_LOAD_CONTAINER = By.id("before-load");

    public static void loadBaseUrlPage(WebDriver driver, WebDriverWait wait) {
        driver.get(BaseTest.getBaseUrl());
        waitForPageLoaded(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ON_LOAD_CONTAINER));
    }

    public static void reLoadBaseUrlPage(WebDriver driver, WebDriverWait wait) {
        int count = 0;
        while (count <= 3 && !(isMAIN_MENUExists(driver))) {
            loadBaseUrlPage(driver, wait);
            count++;
        }

        if (count == 3 && !isMAIN_MENUExists(driver)) {
            Reporter.log("!!!!! Error !!!!! BaseURL page was NOT loaded. Re-Run jobs\n", true);
        }
    }

    public static boolean isMAIN_MENUExists(WebDriver driver) {
        boolean isExists = true;
        try {
            driver.findElement(MAIN_MENU);
        } catch (NoSuchElementException e) {
            isExists = false;
        }

        return isExists;
    }

    public static void waitForPageLoaded(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

}
