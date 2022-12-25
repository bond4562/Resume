package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
            (testName = "-тест-")
    public void test() {

        openBaseURL();
        WebElement click = getDriver().findElement(
                By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a[@href=\"/ru/alpha/\"]")
        );
        click.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://reignofguilds.com/ru/alpha/");



    }

}
