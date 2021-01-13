package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateResultsPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[2]")
    private WebElement classVM;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[3]")
    private WebElement instanceType;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[4]")
    private WebElement computeRegion;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::md-list-item[5]")
    private WebElement tenantCommittedTerm;

    @FindBy(xpath = "//*[@id='soleTenant']/descendant-or-self::md-list-item[3]")
    private WebElement coleTenantRegion;

    @FindBy(xpath = "//*[@id='soleTenant']/descendant-or-self::md-list-item[4]")
    private WebElement nodeCommittedTerm;

    @FindBy(xpath = "//*[@id='soleTenant']/descendant-or-self::md-list-item[7]")
    private WebElement localSSD;

    @FindBy(xpath = "//*[@id='resultBlock']/descendant-or-self::h2[4]")
    private WebElement totalEstimate;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@name='emailForm']/descendant-or-self::h2")
    private WebElement pop_Up;

    public EstimateResultsPage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage openPage() {
        return null;
    }

    public String getClassVM() { return classVM.getText(); }

    public String getInstanceType() { return instanceType.getText(); }

    public String getColeTenantRegion() {
        return coleTenantRegion.getText();
    }

    public String getNodeCommittedTerm() {
        return nodeCommittedTerm.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getTotalEstimate() {
        return totalEstimate.getText();
    }

    public void clickEmailEstimateButton(){
        waitElementToBeClickableBy(driver, emailEstimateButton);
        emailEstimateButton.click();
    }

    public void pasteEmailAddress(){
        waitForElementVisibilityOf(driver, pop_Up);
        emailInput.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v"));}

    public void clickSendButton(){ sendButton.click(); }
}



