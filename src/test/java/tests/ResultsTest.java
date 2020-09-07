package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CommonSteps;


public class ResultsTest extends CommonConditions {
    private String request = "Google Cloud Platform Pricing Calculator";


    @Test
    public void checkAmountEmail()  {
            CommonSteps steps = new CommonSteps();
            String onGoogleForm = steps.getAmountFromGoogleForm(request);
            String onEmail = steps.getValueAmountEmail();
            Assert.assertEquals(onEmail, onGoogleForm);

    }


}
