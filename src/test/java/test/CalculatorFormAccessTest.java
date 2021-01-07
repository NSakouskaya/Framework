package test;
import model.CalculatorForm;
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
        CalculatorForm testCalculatorForm = CalculatorFormCreator.withValuesFromProperty();
        CalculatorPage page = new StartPage(driver)
                .openPage()
                .search(searchValue)
                .openPage()
                .fillFirstForm(testCalculatorForm);
        EstimateResultsPage resultsPage = page.clickAddToEstimateButton();

        resultsPage = page.fillSecondForm(testCalculatorForm).clickAddToEstimateButton();

        GenerateEmailPage emailPage = new GenerateEmailPage(driver).openPage();
        emailPage.copyEmailAddress();

        BrowserTabManager.switchTab();
        driver.switchTo().defaultContent();
        page.switchToFrame(driver);

        resultsPage.clickEmailEstimateButton();
        resultsPage.pasteEmailAddress();
        resultsPage.clickSendButton();

        BrowserTabManager.switchTab();
        emailPage.checkEmailBox();
    }

}
