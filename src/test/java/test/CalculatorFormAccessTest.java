package test;

import model.CalculatorForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.EstimateResultsPage;
import page.StartPage;
import service.CalculatorFormCreator;

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
        CalculatorForm form = page.getFilledCalculatorForm();

        Assert.assertEquals(resultsPage.getClassVM(),form.getMachineClass());
        Assert.assertEquals(resultsPage.getInstanceType(),form.getMachineType());
    }

    @Test
    public void verifyThatBothFormsFilledCorrect() {

        CalculatorForm testForm = CalculatorFormCreator.withDataFromProperty();
        CalculatorPage page = new StartPage(driver)
                .openPage()
                .search(searchValue)
                .openPage()
                .fillFirstForm(testForm);
        EstimateResultsPage resultsPage = page.clickAddToEstimateButton();
        CalculatorForm form = page.getFilledCalculatorForm();

        Assert.assertEquals(resultsPage.getColeTenantRegion(),form.getDataCenter());
        Assert.assertEquals(resultsPage.getNodeCommittedTerm(),form.getCommittedUsage());
        Assert.assertEquals(resultsPage.getLocalSSD(),form.getLocalSSD());

    }

}
