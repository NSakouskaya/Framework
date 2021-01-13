package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 20;

    protected AbstractPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static WebElement waitForElementVisibilityOf(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, 20)
                .until(visibilityOf(webElement));
    }

    static WebElement waitElementToBeClickableBy(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, 20)
                .until(elementToBeClickable(webElement));
    }

}

