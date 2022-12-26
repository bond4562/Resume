package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class MainMenuPage extends BasePage {
    private static final String SUBMENU_DROPDOWN = "//li[@class='has_submenu dropdown']";
    @FindBy(xpath = SUBMENU_DROPDOWN + "//a[text()='Игра']")
    private WebElement searchButtonGameMainMenu;
    @FindBy(xpath = SUBMENU_DROPDOWN +"[1]//li")
    private List<WebElement> gameLinksGameDropDownMainMenu;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    private List<WebElement> searchButtonsMainMenu;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getButtonsTextsMainMenu() {

        return getTexts(searchButtonsMainMenu);
    }
    public int amountButtonsMainMenu() {

        return getListSize(searchButtonsMainMenu);
    }

    public List<String> getLinksGameDropDown() {

        return getTexts(gameLinksGameDropDownMainMenu);
    }

    public MainMenuPage locateAndMoveToGameDropDownMainMenu() {
        int xCord = getPoint(searchButtonGameMainMenu).getX();
        int yCord = getPoint(searchButtonGameMainMenu).getY();

        locateAndMoveElement(searchButtonGameMainMenu,xCord,yCord);
        return this;
    }


}
