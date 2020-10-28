package pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 10.11.2019.
 */
public class PageOfResultsEnterData extends PageObject {




    @Override
    public void openPage() {


    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@id='compute']//div[@class='md-list-item-text ng-binding'and contains(text(),'VM class:')]")
    private WebElement valueClassVM;


    @FindBy(xpath = "//*[@id='compute']//div[@class='md-list-item-text ng-binding'and contains(text(),' Instance type:')]")
    private WebElement valueInstanceType;


    @FindBy(xpath = "//*[@id='compute']//div[@class='md-list-item-text ng-binding'and contains(text(),' Region:')]")
    private WebElement valueRegion;


    @FindBy(xpath = "//*[@id='compute']//div[@class='md-list-item-text ng-binding'and contains(text(),' Total')]")
    private WebElement valueLocalSSD;


    @FindBy(xpath = "//*[@id='compute']//div[@class='md-list-item-text ng-binding'and contains(text(),'Commitment term:')]")
    private WebElement valueCommitmentTerm;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    private WebElement valueAmount;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement feildEmailSet;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;


    public String getValueMachineClass() {
     return   valueClassVM.getText();

    }

    public String getValueInstanceType() {
        return  valueInstanceType.getText();

    }

    public String getValueRegion() {

        return valueRegion.getText();
    }

    public String getValueLocalSSD() {

        return  valueLocalSSD.getText();
    }


    public String getValueCommitmentTerm() {

        return valueCommitmentTerm.getText();
    }

    public String getValueAmount() {

        return valueAmount.getText();
    }

    public void pushButtonEmail() {
        new WebDriverWait(driver,20).
                until(ExpectedConditions.elementToBeClickable(buttonEmailEstimate));
        clickJavascriptExecutor(buttonEmailEstimate);
    }

    public void setEmail(String email) {
        clickJavascriptExecutor(feildEmailSet);
        feildEmailSet.sendKeys(email);
    }

    public void sendResult() {
        clickJavascriptExecutor(buttonSendEmail);}


}
