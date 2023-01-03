package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.MainPage;

import java.util.List;

public abstract class TopBarPage extends MainMenuPage {
    @FindBy(xpath = "//ul[@id='menu-soc-seti']/li/a")
    private List<WebElement> socialMediaLinksTopBarMenu;
    @FindBy(xpath = "//ul[@data-menu]//a")
    private List<WebElement> buttonsLocalizationTopBarMenu;
    @FindBy(xpath = "//div[@class='pull-right']//a[@class='nav-link go_auth']")
    private WebElement searchButtonLogInTopBarMenu;

    public TopBarPage(WebDriver driver) {
        super(driver);
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
