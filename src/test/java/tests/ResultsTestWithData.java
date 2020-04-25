package tests;

import entity.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.OrderCreator;
import steps.CommonSteps;


public class ResultsTestWithData extends CommonConditions {

    Order order = OrderCreator.withDataFromTask();
    private String request = "Google Cloud Platform Pricing Calculator";


    @Test
    public void checkValueVirtualMachineClass() {
        CommonSteps steps = new CommonSteps();
        steps.pageSearching(request);
        steps.getSearchingResult();
        steps.fillOrderForm(order.getCountInstance());
        String value = steps.getTitleVirtualMachineClass();
        Assert.assertEquals(value, order.getClassVM().toLowerCase());

    }

    @Test
    public void checkValueInstanceType() {
        CommonSteps steps = new CommonSteps();
        String value = steps.getTitleInstanceType();
        Assert.assertEquals(value, order.getTypeInstance());
    }

    @Test
    public void checkValueRegion() {
        CommonSteps steps = new CommonSteps();
        String value = steps.getTitleRegion();
        Assert.assertEquals(value, order.getRegion());
    }

    @Test
    public void checkValueLocalSSD() {
        CommonSteps steps = new CommonSteps();
        String value = steps.getTitleLocalSSD();
        Assert.assertEquals(value, order.getLocalSSD());
    }

    @Test
    public void checkValueCommitmentTerm() {
        CommonSteps steps = new CommonSteps();
        String value = steps.getTitleCommitmentTerm();
        Assert.assertEquals(value, order.getCommitmentTerm());
    }

    @Test
    public void checkValueAmountPrice() {
        CommonSteps steps = new CommonSteps();
        String value = steps.getTitleValueAmount();
        Assert.assertEquals(value, order.getAmountRent());
    }


}
