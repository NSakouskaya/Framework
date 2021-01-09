package test;
import model.CalculatorForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.EstimateResultsPage;
import page.GenerateEmailPage;
import page.StartPage;
import service.CalculatorFormCreator;
import util.BrowserTabManager;

public class CalculatorFormAccessTest extends CommonConditions {

    private final String searchValue = "Google Cloud Platform Pricing Calculator";

    @Test
    public void verifyThatFirstFormFilledCorrect() {

        CalculatorForm testForm = CalculatorFormCreator.withDataFromProperty();
        CalculatorPage page = new StartPage(driver)
                .openPage()
                .search(searchValue)
                .openPage()
                .fillFirstForm(testForm);
        EstimateResultsPage resultsPage = page.clickAddToEstimateButton();
        Assert.assertEquals("VM class: regular", resultsPage.getClassVM());
        Assert.assertEquals("Instance type: e2-standard-8", resultsPage.getInstanceType());
        Assert.assertEquals("Region: Frankfurt", resultsPage.getComputeRegion());



//
//        resultsPage = page.fillSecondForm(testForm).clickAddToEstimateButton();
//
//        GenerateEmailPage emailPage = new GenerateEmailPage(driver).openPage();
//        emailPage.copyEmailAddress();
//
//        BrowserTabManager.switchTab();
//        driver.switchTo().defaultContent();
//        page.switchToFrame(driver);
//
//        resultsPage.clickEmailEstimateButton();
//        resultsPage.pasteEmailAddress();
//        resultsPage.clickSendButton();
//
//        BrowserTabManager.switchTab();
//        emailPage.checkEmailBox();
    }

}
