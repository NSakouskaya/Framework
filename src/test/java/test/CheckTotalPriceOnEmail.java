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

public class CheckTotalPriceOnEmail extends CommonConditions {

    private final String searchValue = "Google Cloud Platform Pricing Calculator";

    @Test
    public void verifyThatBothFormsFilledCorrect() {

        CalculatorForm testForm = CalculatorFormCreator.withDataFromProperty();
        CalculatorPage page = new StartPage(driver)
                .openPage()
                .search(searchValue)
                .openPage()
                .fillFirstForm(testForm);
        EstimateResultsPage resultsPage = page.clickAddToEstimateButton();
        resultsPage = page.fillSecondForm(testForm).clickAddToEstimateButton();

        GenerateEmailPage emailPage = new GenerateEmailPage(driver).openPage();
        emailPage.copyEmailAddress();

        BrowserTabManager.switchTab();
        driver.switchTo().defaultContent();
        page.switchToFrame();

        String totalEstimate = resultsPage.getTotalEstimate();
        resultsPage.clickEmailEstimateButton();
        resultsPage.pasteEmailAddress();
        resultsPage.clickSendButton();

        BrowserTabManager.switchTab();

        emailPage.scrollIntoEmailBox();
        emailPage.checkEmailBox();

        Assert.assertTrue(totalEstimate.contains(emailPage.getEmailPrice()));
    }

}