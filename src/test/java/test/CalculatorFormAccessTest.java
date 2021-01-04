package test;

import model.CalculatorForm;
import org.testng.annotations.Test;
import page.CalculatorPage;
import service.CalculatorFormCreator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorFormAccessTest extends CommonConditions {

    @Test
    public void oneFormCanBeCreated() {
        CalculatorForm testCalculatorForm = CalculatorFormCreator.withValuesFromProperty();
        String fillInNumberOfInstancesField = new CalculatorPage(driver)
                .openPage()
                .fillInCalculatorForm(testCalculatorForm)
                .getFillInNumberOfInstancesField();
        assertThat(fillInNumberOfInstancesField, is(equalTo(testCalculatorForm.getNumberOfInstances())));
    }


}
