package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;

public abstract class TopBarPage extends MainMenuPage {
    @FindBy(xpath = "//ul[@id='menu-soc-seti']/li/a")
    private List<WebElement> socialMediaLinksTopBarMenu;

    public TopBarPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickSocialMediaElement(int socialMediaElement) {
        click10(socialMediaLinksTopBarMenu.get(socialMediaElement));

        return new MainPage(getDriver());
    }








}
