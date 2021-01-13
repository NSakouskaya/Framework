package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BrowserTabManager;

public class GenerateEmailPage extends AbstractPage{

    public static final String GENERATE_EMAIL_URL = "https://10minutemail.com";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id='copy_address']")
    private WebElement copyAddressButton;

    @FindBy(xpath = "//*[@id='mail_messages_content']")
    private WebElement emailBox;

    @FindBy(xpath = "//*[@id='Email']/descendant-or-self::h3[2]")
    private WebElement emailPrice;

    public GenerateEmailPage(WebDriver driver) {
        super(driver);
    }

    public GenerateEmailPage openPage() {
        BrowserTabManager.openNewTab(GENERATE_EMAIL_URL);
        logger.info("Email page opened");
        return this;
    }

    public void copyEmailAddress() {
       waitForElementVisibilityOf(driver, copyAddressButton);
        copyAddressButton.click();
    }

    public void checkEmailBox() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(h -> h.findElement(By.xpath("//div[@class='mail_message']")) != null);
        emailBox.click();
    }

    public void scrollIntoEmailBox() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('mail_messages').scrollIntoView();");
    }

    public String getEmailPrice() {
        return emailPrice.getText();
    }

}

