package steps;

import entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import pages.*;
import service.OrderCreator;
import util.ParseString;
import util.TabSwitcher;

import javax.naming.OperationNotSupportedException;


public class CommonSteps extends  PageObject {
    Order order = OrderCreator.withDataFromTask();

    @Override
    public void openPage() throws OperationNotSupportedException {

    }

    public CommonSteps() {

    }
    private final Logger logger = LogManager.getRootLogger();


    public MainPage pageSearching(String request) {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.searchingPage(request);
        logger.info("Enter ("+request +")");
        return mainPage;
    }

    public PageResultsOfSearch getSearchingResult() {
        PageResultsOfSearch pageResultsOfSearch = new PageResultsOfSearch();
        pageResultsOfSearch.getResultOfSearch();
        return pageResultsOfSearch;
    }

    public  void sendEmail(String email){
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        pageOfResultsEnterData.pushButtonEmail();
        pageOfResultsEnterData.setEmail(email);
        pageOfResultsEnterData.sendResult();

    }

    public  String produceEmailName(){
        PageCreateEmail pageCreateEmail = new PageCreateEmail();
        String emailName= pageCreateEmail.getNameEmail();
        logger.info("Get email (" + emailName + ") for sending amount");
        return  emailName;

    }

    public  void openEmail(){
        PageCreateEmail pageCreateEmail = new PageCreateEmail();
        pageCreateEmail.pushButtonOpenEmail();

    }

    public PageOfCalculator fillOrderForm() {
        PageOfCalculator pageOfCalculator = new PageOfCalculator();
        pageOfCalculator.setValueOfInstance(order.getCountInstance());
        pageOfCalculator.selectOperationSystem();
        pageOfCalculator.selectMachineClass(order.getClassVM().toLowerCase());
        pageOfCalculator.selectMachineType(order.getTypeInstance());
        pageOfCalculator.addGPU();
        pageOfCalculator.selectSelectLocalSSD(order.getLocalSSD());
        pageOfCalculator.selectDataCenterLocation(order.getRegion());
        pageOfCalculator.selectValueCommitedUsage(order.getCommitmentTerm());
        pageOfCalculator.submitAddEstimate();
        return pageOfCalculator;
    }






    public String getAmountFromGoogleForm(String request)  {
        CommonSteps steps= new CommonSteps();
        steps.pageSearching(request);
        steps.getSearchingResult();
        steps.fillOrderForm();
        String value = steps.getTitleValueAmount();
        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.net');");
        TabSwitcher.SwitchTab(driver,1);
        String name=steps.produceEmailName();
        TabSwitcher.SwitchTab(driver,0);
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        steps.sendEmail(name);
        logger.info("Get amount ("+ value +") from Google form ");
        return value;
    }


    public  String getValueAmountEmail(){
        TabSwitcher.SwitchTab(driver,1);
        PageCreateEmail pageCreateEmail = new PageCreateEmail();
        CommonSteps steps = new CommonSteps();
        steps.openEmail();
        String value = pageCreateEmail.getAmount();
        logger.info("Get amount (" +value +") from temporary   email aggregator   ");
        return value;
    }

    public  String getTitleValueAmount(){
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueAmount();
        String value = ParseString.parseLineForWordsOnMiddle(title);
        return value;
    }

    public String getTitleVirtualMachineClass() {
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueMachineClass();
        String value = ParseString.getPartString(title);
        return value;
    }

    public String getTitleInstanceType() {
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueInstanceType();
        String value = ParseString.getPartString(title);
        return value;
    }

    public String getTitleRegion() {
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueRegion();
        String value = ParseString.getPartString(title);
        return value;
    }

    public String getTitleLocalSSD() {
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueLocalSSD();
        String value= ParseString.parseLineForLastsWords(title);
        return value;
    }

    public String getTitleCommitmentTerm() {
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueCommitmentTerm();
        String value = ParseString.getPartString(title);
        return value;

    }




}
