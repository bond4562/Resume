package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import pages.base_abstract.TopBarPage;

public class LoginPage extends TopBarPage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//strong")
    private WebElement searchNameUser;

    private final String email = "bond4562+1@gmail.com";
    private final String password = "пароль_тест_аккаунта";
    private final String nameUser = "TesteR";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmitButton() {
        click10(buttonSubmit);
    }

    public LoginPage signInAsRegularUser() {
        switchToFrame();
        inputAfterClear(inputEmail,email);
        inputAfterClear(inputPassword,password);
        clickSubmitButton();
        switchToFrameDefaultContent();

        String getNameUser = getText(searchNameUser);
        Assert.assertEquals(getNameUser, nameUser);

        Reporter.log("Логин был успешно выполнен", true);

        return new LoginPage(getDriver());
    }


}
