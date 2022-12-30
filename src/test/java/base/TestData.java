package base;

import org.testng.annotations.DataProvider;

import java.util.List;

public class TestData {

    private static final List<String> expButtonsTextDE = List.of(
           "Neuigkeiten",
            "Entwicklungsstand",
            "Alpha",
            "Spiel",
            "Entwicklung",
            "Medien",
            "Forum"
    );

    private static final List<String> expButtonsTextEN = List.of(
            "News",
            "Roadmap",
            "Alpha",
            "Game",
            "Development",
            "Media",
            "Forum"
    );

    private static final List<String> expButtonsTextRU = List.of(
            "Новости",
            "Дорожная карта",
            "Альфа",
            "Игра",
            "Разработка",
            "Медиа",
            "Форум"
    );

    @DataProvider(name = "localizationButton")
    public static Object[][] localizationButtonsTestDataProvider() {

        return new Object[][] {
                {0, "https://reignofguilds.com/de/", "Magisches mittelalterliches MMORPG", expButtonsTextDE},
                {1, "https://reignofguilds.com/en/", "Classic MMORPG in dark magical middle ages", expButtonsTextEN},
                {2, "https://reignofguilds.com/ru/", "Классическая MMORPG в мрачном средневековье", expButtonsTextRU}
        };
    }



}
