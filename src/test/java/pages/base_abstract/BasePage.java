package pages.base_abstract;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait10;
    private Actions actions;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(driver);
        }

        return actions;
    }

    public String getTitle() {

        return getDriver().getTitle();
    }

    public String getCurrentURL() {

        return getDriver().getCurrentUrl();
    }

    protected String getText(WebElement element) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getText();
    }

    protected List<String> getTexts(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> textList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    textList.add(element.getText());
                }
            }

            return textList;
        }

        return new ArrayList<>();
    }

    protected List<String> getTrimmedTexts(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(getText(element).trim());
        }

        return texts;
    }

    protected List<WebElement> getListOfVisibleElements(List<WebElement> list, int listSize) {
        List<WebElement> visibleElements = new ArrayList<>();

        if (!(list.size() > 0)) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            for (WebElement element : list) {
                if (!element.isDisplayed() && !element.isEnabled()) {
                    getWait20().until(ExpectedConditions.visibilityOf(element));
                    visibleElements.add(element);
                }
            }
        } else if (list.size() == listSize) {

            return list;
        }

        return visibleElements;
    }

    public String getAttribute(WebElement element, String attribute) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getAttribute(attribute);
    }

    protected String getBackgroundColor(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("background-color");
    }

    protected String getBackgroundColorInHEX(WebElement element) {

        return Color.fromString(getBackgroundColor(element)).asHex();
    }

    protected String getFontSize(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("font-size");
    }

    public int getListSize(List<WebElement> list) {

        return list.size();
    }

    protected void click10(WebElement element) {
        wait10ElementToBeVisible(element);
        wait10ElementToBeClickable(element).click();
    }

    protected void click20(WebElement element) {
        wait20ElementToBeVisible(element);
        wait20ElementToBeClickable(element).click();
    }

    protected void clickEnter(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ENTER);
    }

    protected void clickArrowUp(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ARROW_UP);
    }

    protected void clickAllElementsInList(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);

        for (WebElement element : allElements) {
            if (element.isEnabled() && element.isDisplayed()) {
                wait10ElementToBeVisible(element);
                wait10ElementToBeClickable(element).click();
            } else {
                Reporter.log("Element " + element + " is not visible or not clickable ", true);
            }
        }
    }

    protected void clear(WebElement element) {

        element.clear();
    }

    protected void input(String text, WebElement element) {

        element.sendKeys(text);
    }

    protected void inputAndEnter(WebElement element, String text) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text, Keys.ENTER);
    }

    protected void inputAfterClear(WebElement element, String text) {
        click10(element);
        clear(element);
        input(text, element);
    }

    protected void setWindowDimensions(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    protected void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    protected void goBack() {
        getDriver().navigate().back();
    }

    protected void selectOption(WebElement element, String text) {
        Select option = new Select(element);
        option.selectByValue(text);
    }

    protected void waitForTextNotToBeEmpty(WebElement element) {
        while (element.getText() == null || element.getText().length() < 1) {
            getWait20().until(ExpectedConditions
                    .not(ExpectedConditions.textToBePresentInElement(element, "")));
        }
    }

    protected void wait10ElementToBeVisible(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    protected void wait20ElementToBeVisible(WebElement element) {
        getWait20().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement wait10ElementToBeClickable(WebElement element) {

        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement wait20ElementToBeClickable(WebElement element) {

        return getWait20().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForUrlContains(String text) {
        getWait10().until(ExpectedConditions.urlContains(text));
    }

    protected void waitTextToBeChanged(WebElement element, String text) {
        getWait20().until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    protected boolean isElementDisplayed(WebElement element) {

        return element.isDisplayed();
    }

    protected boolean areElementsInListDisplayed(List<WebElement> list) {
        boolean result = false;

        for (WebElement element : list) {
            if (element.isDisplayed()) {
                result = true;
            } else {

                return false;
            }
        }

        return result;
    }

    protected boolean areAllElementsVisibleAndClickable(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);
        int elementsSize = elements.size();
        int count = 0;

        for (WebElement checkedElement : allElements) {
            if (checkedElement.isEnabled() && checkedElement.isDisplayed()) {
                wait10ElementToBeClickable(checkedElement);
                count++;
            }
        }

        return elementsSize == count;
    }

    protected Point getPoint(WebElement webElement) {
        return webElement.getLocation();
    }

    protected void locateAndMoveElement(WebElement webElement, int xCord, int yCord) {
        getActions().scrollByAmount(xCord, yCord).moveToElement(webElement).build().perform();
    }

    protected void switchToFrame() {
        getDriver().switchTo().frame(0);
    }
    protected void switchToFrame(int indexFrame) {
        getDriver().switchTo().frame(indexFrame);
    }

    protected void switchToFrameDefaultContent() {
        getDriver().switchTo().defaultContent();
    }


}
