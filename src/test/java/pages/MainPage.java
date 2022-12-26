package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopBarPage;

import java.util.List;

public class MainPage extends TopBarPage {

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    private List<WebElement> searchButtons;
    @FindBy(xpath = "//li[@class='has_submenu dropdown']//a[text()='Игра']")
    private WebElement searchButtonGame;
    @FindBy(xpath = "//li[@class='has_submenu dropdown'][1]//li")
    private List<WebElement> searchButtonsGame;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public List<String> getButtonsMainMenuTexts() {

        return getTexts(searchButtons);
    }
    public int amountButtonsMainMenu() {

        return getListSize(searchButtons);
    }

    public List<String> getButtonsGameTexts() {

        return getTexts(searchButtonsGame);
    }

    public MainPage locateAndMoveDropDownGame() {
        int xCord = getPoint(searchButtonGame).getX();
        int yCord = getPoint(searchButtonGame).getY();

       locateAndMoveElement(searchButtonGame, xCord,yCord);
       return this;
    }

}
