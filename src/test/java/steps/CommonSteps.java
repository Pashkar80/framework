package steps;

import entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;
import service.OrderCreator;
import util.ParseString;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;


public class CommonSteps extends  PageObject {
    private String request = "Google Cloud Platform Pricing Calculator";
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

    public PageOfCalculator fillOrderForm(String value) {
        PageOfCalculator pageOfCalculator = new PageOfCalculator();
        pageOfCalculator.setValueOfInstance(value);
        pageOfCalculator.selectOperationSystem();
        pageOfCalculator.selectMachineClass();
        pageOfCalculator.selectMachineType();
        pageOfCalculator.addGPU();
        pageOfCalculator.selectSelectLocalSSD();
        pageOfCalculator.selectDataCenterLocation();
        pageOfCalculator.selectValueCommitedUsage();
        pageOfCalculator.submitAddEstimate();
        return pageOfCalculator;
    }

    public String getAmountFromGoogleForm()  {
        CommonSteps steps= new CommonSteps();
        String name=steps.produceEmailName();
        String email=driver.getWindowHandle();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.open('https://cloud.google.com/');");
        new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> allWindows_1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allWindows_1.get(1));
        steps.pageSearching(request);
        steps.getSearchingResult();
        steps.fillOrderForm(order.getCountInstance());
        String value = steps.getTitleValueAmount();
        steps.sendEmail(name);
        String calc=driver.getWindowHandle();
        driver.switchTo().window(email);
        javascriptExecutor.executeScript("window.scrollBy(0,450)", "");
        logger.info("Get amount ("+ value +" from Google form ");
        return value;
    }


    public  String getValueAmountEmail(){
        PageCreateEmail pageCreateEmail = new PageCreateEmail();
        CommonSteps steps = new CommonSteps();
        steps.openEmail();
        String value = pageCreateEmail.getAmount();
        logger.info("Get amount (" +value +") from temporary   email aggregator   ");
        return value;
    }

    public  String getTitleValueAmount(){
        PageOfResultsEnterData pageOfResultsEnterData = new PageOfResultsEnterData();
        String title = pageOfResultsEnterData.getValueAmuont();
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
