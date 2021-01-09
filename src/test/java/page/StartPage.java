package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    public static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//form[@class = 'devsite-search-form']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchField;

    public StartPage(WebDriver driver)  {
        super(driver);
    }

    public StartPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public SearchResultsPage search (String text){
        searchButton.click();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

}

