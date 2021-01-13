package page;

import model.CalculatorForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CalculatorPage extends AbstractPage {

    private EstimateResultsPage resultsPage = null;
    private CalculatorForm filledCalculatorForm;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@name='quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Operating System')]/md-select-value")
    private WebElement operatingSystemDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'VM Class')]/md-select-value")
    private WebElement machineClassDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Instance type')]/md-select-value")
    private WebElement machineTypeDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Datacenter location')]/md-select-value")
    private List<WebElement> dataCenterDrp;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Committed usage')]/md-select-value")
    private List<WebElement> committedUsageDrp;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate' and not(@disabled)]")
    private WebElement estimateButton;

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

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
        switchToFrame();
    }

    public void switchToFrame() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("myFrame")));
    }

    public CalculatorPage fillFirstForm(CalculatorForm calculatorForm) {
        numberOfInstancesField.sendKeys(calculatorForm.getNumberOfInstances());
        fillDropdown(operatingSystemDrp, calculatorForm.getOperatingSystem());
        fillDropdown(machineClassDrp, calculatorForm.getMachineClass());
        fillDropdown(machineTypeDrp, calculatorForm.getMachineType());
        fillDropdown(dataCenterDrp.get(0), calculatorForm.getDataCenter());
        fillDropdown(committedUsageDrp.get(0), calculatorForm.getCommittedUsage());
        logger.info("First form filled successful");

        if (filledCalculatorForm == null)
            filledCalculatorForm = new CalculatorForm();
        filledCalculatorForm.setMachineClass(machineClassDrp.getText());
        filledCalculatorForm.setMachineType(machineTypeDrp.getText());
        return this;
    }

    public CalculatorPage fillSecondForm(CalculatorForm calculatorForm) {
        numberOfNodesField.sendKeys(calculatorForm.getNumberOfNodes());
        addGPUsCheckbox.click();
        fillDropdown(numberOfGPUsDrp, calculatorForm.getNumberOfGPUs());
        fillDropdown(typeGPUDrp, calculatorForm.getTypeGPU());
        fillDropdown(localSSDDrp, calculatorForm.getLocalSSD());
        fillDropdown(dataCenterDrp.get(1), calculatorForm.getDataCenter());
        fillDropdown(committedUsageDrp.get(1), calculatorForm.getCommittedUsage());
        logger.info("Second form filled successful");

        if (filledCalculatorForm == null)
            filledCalculatorForm = new CalculatorForm();
        filledCalculatorForm.setTypeGPU(typeGPUDrp.getText());
        filledCalculatorForm.setLocalSSD(localSSDDrp.getText());
        return this;
    }

    public CalculatorForm getFilledCalculatorForm() {
        return this.filledCalculatorForm;
    }

    public EstimateResultsPage clickAddToEstimateButton() {
        waitElementToBeClickableBy(driver, estimateButton);
            estimateButton.click();

        if (resultsPage == null) {
            return new EstimateResultsPage(driver);
        }
        return resultsPage;
    }

    public void fillDropdown(WebElement dropDown, String value) {
            dropDown.click();
            By xpath = By.xpath(String.format("//div[@aria-hidden='false']/descendant-or-self::md-option[@value='%s']", value));
            WebElement selectedValue = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(xpath));
            selectedValue.click();
    }

 }
