package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.MainPage;

import java.util.List;

public abstract class HeaderPage extends BasePage {
    private static final String SUBMENU_DROPDOWN = "//li[@class='has_submenu dropdown']";
    @FindBy(xpath = SUBMENU_DROPDOWN + "//a[text()='Игра']")
    private WebElement searchButtonGameMainMenu;
    @FindBy(xpath = SUBMENU_DROPDOWN +"[1]//li")
    private List<WebElement> gameLinksDropDownMainMenu;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    private List<WebElement> searchButtonsMainMenu;
    @FindBy(xpath = "//ul[@id='menu-soc-seti']/li/a")
    private List<WebElement> socialMediaLinksTopBarMenu;
    @FindBy(xpath = "//ul[@data-menu]//a")
    private List<WebElement> buttonsLocalizationTopBarMenu;
    @FindBy(xpath = "//div[@class='pull-right']//a[@class='nav-link go_auth']")
    private WebElement searchButtonLogInTopBarMenu;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getButtonsTextsMainMenu() {

        return getTexts(searchButtonsMainMenu);
    }

    public int amountButtonsMainMenu() {

        return getListSize(searchButtonsMainMenu);
    }

    public List<String> getLinksGameDropDown() {

        return getTexts(gameLinksDropDownMainMenu);
    }

    public MainPage locateAndMoveToGameDropDownMainMenu() {
        int xCord = getPoint(searchButtonGameMainMenu).getX();
        int yCord = getPoint(searchButtonGameMainMenu).getY();

        locateAndMoveElement(searchButtonGameMainMenu,xCord,yCord);

        return new MainPage(getDriver());
    }

    public MainPage clickSocialMediaElement(int socialMediaElement) {
        click10(socialMediaLinksTopBarMenu.get(socialMediaElement));

        return new MainPage(getDriver());
    }

    public MainPage clickButtonLocalization(int numberButton) {
        click10(buttonsLocalizationTopBarMenu.get(numberButton));

        return new MainPage(getDriver());
    }

    public LoginPage clickButtonLogin() {
        click10(searchButtonLogInTopBarMenu);

        return new LoginPage(getDriver());
    }


}
