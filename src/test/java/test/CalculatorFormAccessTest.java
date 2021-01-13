package test;

import model.CalculatorForm;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
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

        Assert.assertTrue(resultsPage.getClassVM().contains(form.getMachineClass().toLowerCase()));
        Assert.assertTrue(resultsPage.getCommittedTerm().contains(form.getCommittedUsage()));
    }

    @Test
    public void verifyThatBothFormsFilledCorrect() {

        CalculatorForm testForm = CalculatorFormCreator.withDataFromProperty();
        CalculatorPage page = new StartPage(driver)
                .openPage()
                .search(searchValue)
                .openPage()
                .fillFirstForm(testForm);
        page.clickAddToEstimateButton();
        EstimateResultsPage resultsPage = page.fillSecondForm(testForm).clickAddToEstimateButton();
        CalculatorForm form = page.getFilledCalculatorForm();

        //Assert.assertTrue(resultsPage.getColeTenantRegion().contains(form.getDataCenter()));
        Assert.assertTrue(resultsPage.getNodeCommittedTerm().contains(form.getCommittedUsage()));
//        Assert.assertTrue(resultsPage.getLocalSSD().contains(form.getLocalSSD()));

    }

}
