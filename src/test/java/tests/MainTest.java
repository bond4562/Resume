package tests;

import base.BaseTest;
import base.TestData;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.MainPage;

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

    @Test(
            testName = "проверка кнопок локализации",
            dataProvider = "localizationButton", dataProviderClass = TestData.class
    )
    public void test06(int index, String expURL, String expTitle, List<String> getTextButtonsMainMenu) {

        MainPage mainPage = openBaseURL()
                .clickButtonLocalization(index);

        final String actURL = mainPage
                .getCurrentURL();
        final String actTitle = mainPage
                .getTitle();

        List<String> actTextButtons = mainPage
                .getButtonsTextsMainMenu();

        Reporter.log("\n локализация: " + expURL + "\n текст меню: " + actTextButtons,true);

        assertEquals(actTextButtons, getTextButtonsMainMenu);
        assertEquals(actURL, expURL);
        assertEquals(actTitle, expTitle);
    }



}
