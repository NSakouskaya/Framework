package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='gs-title']/a[1]")
    private WebElement searchResultLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() { return null; }

    public void clickOnLink(){
        waitForElementLocated(driver, "//div[@class='gs-title']/a[1]");
        searchResultLink.click();
    }


}
