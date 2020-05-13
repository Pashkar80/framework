package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageCreateEmail;
import steps.CommonSteps;


public class ResultsTest extends CommonConditions {


    @Test
    public void checkAmountEmail()  {
            new PageCreateEmail().openPage();
            CommonSteps steps = new CommonSteps();
            String onGoogleForm = steps.getAmountFromGoogleForm();
            String onEmail = steps.getValueAmountEmail();
            Assert.assertEquals(onEmail, onGoogleForm);

    }


}
