package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static org.testng.Assert.assertEquals;

public class MainTest extends BaseTest {

    @Test(
            testName = "проверка заголовка главной страницы")
    public void test01() {
        final String expTitle = "Классическая MMORPG в мрачном средневековье";

        String actTitle = openBaseURL()
                .getTitle();

        assertEquals(actTitle, expTitle);
    }

    @Test(
            testName = "проверка количества кнопок Main menu")
    public void test02() {
        final int expAmountButton = 7;

        int actAmountButton = openBaseURL()
                .amountButtonsMainMenu();

        assertEquals(actAmountButton, expAmountButton);
    }

    @Test(
            testName = "проверка текста кнопок Main menu")
    public void test03() {
        final List<String> expButtonTexts = List.of(
                "Новости",
                "Дорожная карта",
                "Альфа",
                "Игра",
                "Разработка",
                "Медиа",
                "Форум"
        );

        List<String> actButtonTexts = openBaseURL()
                .getButtonsTextsMainMenu();

        assertEquals(actButtonTexts, expButtonTexts);
    }

    @Test(
            testName = "проверка текста кнопок выпадающего списка \"Игра\"")
    public void test04() {
        final List<String> expButtonTexts = List.of(
                "Об игре",
                "F.A.Q.",
                "Словарь"
        );

        List<String> actButtonTexts = openBaseURL()
                .locateAndMoveToGameDropDownMainMenu()
                .getLinksGameDropDown();

        assertEquals(actButtonTexts, expButtonTexts);
    }

    @Test(
            testName = "проверка перехода кнопок соц.сети")
    public void test05() {
        final String expURL = "https://vk.com/reignofguilds";

        String actURL = openBaseURL()
                .clickSocialMediaElement(0)
                .getCurrentURL();

        assertEquals(actURL, expURL);
    }

}
