package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {


    @FindBy(xpath = "//div[@class='gs-title']/a[1]")
    private WebElement searchResultLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(searchResultLink));
        searchResultLink.click();
        return new CalculatorPage(driver);
    }

}
