package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CalculatorPage extends AbstractPage {

    public static final int firstButton = 0;
    public static final int secondButton = 1;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(visibilityOfElementLocated(By.id("gc-wrapper")));

        driver.switchTo().frame(0);
        WebElement frame1 = driver.findElement(By.id("myFrame"));
        driver = driver.switchTo().frame(frame1);
        return this;
    }

    @FindBy(xpath = "//*[@name='quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'VM Class')]/md-select-value")
    private WebElement machineClassDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Instance type')]/md-select-value")
    private WebElement machineTypeDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Datacenter location')]/md-select-value")
    private List<WebElement> dataCenterDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Committed usage')]/md-select-value")
    private List<WebElement> committedUsageDrp;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private List<WebElement> estimateButton;

    @FindBy(xpath = "//input[@name='nodesCount']")
    private WebElement numberOfNodesField;

    @FindBy(xpath = "//md-checkbox[contains(@aria-label, 'Add GPUs')]")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[starts-with(@aria-label, 'Number of GPUs')]/md-select-value")
    private WebElement numberOfGPUsDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'GPU type')]/md-select-value")
    private WebElement typeGPUDrp;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']/md-select-value")
    private WebElement localSSDDrp;

    public void fillInNumberOfInstancesField() { numberOfInstancesField.sendKeys();
    }

    public void setUpOperatingSystemDrp() {
        machineClassDrp.click();
        WebElement softwareList = driver.findElement(By.xpath("//div/descendant-or-self::md-option[@value='free']"));
        softwareList.click();
    }

    public void setUpMachineClassDrp() {
        machineTypeDrp.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement machineClassList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='regular']"));
        machineClassList.click();
    }

    public void setUpMachineTypeDrp() {
        machineTypeDrp.click();
        waitForElementLocated(driver, "//div/descendant-or-self::md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8']");
        WebElement machineTypeList = driver.findElement(By.xpath("//div/descendant-or-self::md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8']"));
        machineTypeList.click();
    }

    public void setUpDataCenterLocationDrp(int index) {
       dataCenterDrp.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']/descendant-or-self::md-option[@value='europe-west3']");
        WebElement dataCenterList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='europe-west3']"));
        dataCenterList.click();
    }

    public void setUpCommittedUsageDrp(int index) {
        committedUsageDrp.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement committedUsageList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='1']"));
        committedUsageList.click();
    }

    public void fillInNumberOfNodesField(String numberOfNodes) {
        numberOfNodesField.sendKeys(numberOfNodes);
    }

    public void checkAddGPUsCheckbox() {
        waitForElementLocated(driver, "//div['@aria-checked=false']");
        addGPUsCheckbox.click();
    }

    public void setUpNumberOfGPUsDrp() {
        waitForElementLocated(driver, "//div/md-input-container/md-select[@placeholder='Number of GPUs']");
        numberOfGPUsDrp.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement numberGPUsList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='4']"));
        numberGPUsList.click();
    }

    public void setUpTypeGPUDrp() {
        typeGPUDrp.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement typeGPUDList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='NVIDIA_TESLA_T4']"));
        typeGPUDList.click();
    }

    public void setUpLocalSSDDrp() {
        localSSDDrp.click();
        waitForElementLocated(driver, "//div[@aria-hidden='false']");
        WebElement localSSdList = driver.findElement(By.xpath("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='24']"));
        localSSdList.click();
    }

    public void clickAddToEstimateButton(int index) {
        estimateButton(index).isEnabled();
        try {
            estimateButton.click();
        } catch (Exception ex) {
            System.err.println("Button not found by index: " + index + "; exception message: " + ex.getMessage());
        }

//        public void setupDropdownValue(String cssClass, String value) {
//            String propDownXPath = String.format("//md-select[contains(@aria-label, '%s')]/md-select-value", cssClass);
//            WebElement mc = driver.findElement(By.xpath(propDownXPath));
//            mc.click();
//            WebElement selectedValue = getOptionByValue(value);
//            selectedValue.click();
//        }
//
//        private WebElement getOptionByValue(String value) {
//            return new WebDriverWait(driver, 5)
//                    .until(ExpectedConditions.elementToBeClickable(
//                            By.xpath(String.format("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='%s']", value))));
//        }

    }
}
