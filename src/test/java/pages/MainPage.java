package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TopBarPage;

import java.util.List;

public class MainPage extends TopBarPage {

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    private List<WebElement> searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchButtonMainMenu() {

        return getTexts(searchButton);
    }

    public int amountButtonMainMenu() {

        return getListSize(searchButton);
    }


}
