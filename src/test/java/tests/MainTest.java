package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class MainTest extends BaseTest {

    @Test(
            testName = "проверка заголовка главной страницы")
    public void test01() {
        final String expTitle = "Classic MMORPG in dark magical middle ages";

        String actTitle = openBaseURL()
                .getTitle();

        assertEquals(actTitle, expTitle);
    }

    @Test(
            testName = "проверка количества кнопок Main menu")
    public void test02() {
        final int expAmountButton = 7;

        int actAmountButton = openBaseURL()
                .amountButtonMainMenu();

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
                .searchButtonMainMenu();

        assertEquals(actButtonTexts, expButtonTexts);
    }

}
