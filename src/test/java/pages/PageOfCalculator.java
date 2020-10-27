package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by user on 23.10.2019.
 */
public class PageOfCalculator extends PageObject {


    @Override
    public void openPage() {
        driver.get("https://cloud.google.com/products/calculator/");

    }

    @Override
    public void clickJavascriptExecutor(WebElement element) {
        js.executeScript("arguments[0].click()", element);
    }

    WebDriverWait wait = new WebDriverWait(driver, 30);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@id='mainForm']//md-input-container/input")
    private WebElement fieldOfInstance;


    @FindBy(xpath = "//*[@id='mainForm']/descendant::md-input-container[@class='flex md-input-has-value']/md-select")
    private WebElement formOperatingSystem;
    @FindBy(xpath = "//md-option[@value='free']/div[@class='md-text']")
    private WebElement valueOperatingSystem;


    @FindBy(xpath = "//md-select[@placeholder='VM Class']//span[@class='md-select-icon']")
    private WebElement formMachineClass;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='Regular']")
    private WebElement valueMachineClass;


    @FindBy(xpath = "//md-select[@placeholder='Instance type']//span[@class='md-select-icon']")
    private WebElement formMachineType;


    @FindBy(xpath = "//*[@class='md-container md-ink-ripple']")
    // @FindBy(xpath = "//md-checkbox[@class='ng-pristine ng-valid ng-empty ng-touched']/div[@class='md-container md-ink-ripple']")
    private WebElement selectAddGPU;


    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']//span[@class='md-select-icon']")
    private WebElement selectNumberGPU;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    private WebElement valueNumberGPU;


    @FindBy(xpath = "//md-select[@placeholder='GPU type']//span[@class='md-select-icon']")
    private WebElement selectTypeGPU;
    @FindBy(css = "md-option[value='NVIDIA_TESLA_V100']")
    private WebElement valueTypeGPU;


    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//span[@class='md-select-icon']")
    private WebElement selectLocalSSD;


    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']//span[@class='md-select-icon']")
    private WebElement selectDatacenterLocation;


    @FindBy(xpath = "//md-select[@placeholder='Committed usage']//span[@class='md-select-icon']")
    private WebElement selectCommitedUsage;


    @FindBy(xpath = "//*[@id='mainForm']/descendant::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement bottonAddEstimate;


    public void setValueOfInstance(String value) {
        // wait.until(ExpectedConditions.titleIs("Google Cloud Platform Pricing Calculator"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.elementToBeClickable(fieldOfInstance));
        fieldOfInstance.sendKeys(value);
    }

    public void selectOperationSystem() {
        wait.until(ExpectedConditions.elementToBeClickable(formOperatingSystem));
        clickJavascriptExecutor(formOperatingSystem);
        wait.until(ExpectedConditions.elementToBeClickable(valueOperatingSystem));
        clickJavascriptExecutor(valueOperatingSystem);


    }

    public void selectMachineClass(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(formMachineClass));
        clickJavascriptExecutor(formMachineClass);
        WebElement valueMachineClassBy = driver.findElement(By.xpath
                (String.format("//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']/div", value)));
        wait.until(ExpectedConditions.elementToBeClickable(valueMachineClassBy));
        logger.info("Value Machine Class" + valueMachineClassBy.toString());
        clickJavascriptExecutor(valueMachineClassBy);
    }


    public void selectMachineType(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(formMachineClass));
        clickJavascriptExecutor(formMachineType);
        WebElement valueMachineTypeBy = driver.findElement
                (By.xpath(String.format("//md-option[@class='ng-scope md-ink-ripple']//div[@class='md-text ng-binding' and contains (text(),'%s')]", value)));
        clickJavascriptExecutor(valueMachineTypeBy);
    }

    public void addGPU() {
        wait.until(ExpectedConditions.elementToBeClickable(selectAddGPU));
        clickJavascriptExecutor(selectAddGPU);
        wait.until(ExpectedConditions.elementToBeClickable(selectNumberGPU));
        clickJavascriptExecutor(selectNumberGPU);
        wait.until(ExpectedConditions.elementToBeClickable(valueNumberGPU));
        clickJavascriptExecutor(valueNumberGPU);
        clickJavascriptExecutor(selectTypeGPU);
        clickJavascriptExecutor(valueTypeGPU);
    }


    public void selectSelectLocalSSD(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(selectLocalSSD));
        clickJavascriptExecutor(selectLocalSSD);
        WebElement localSSDBy = driver.findElement(By.xpath
                (String.format("*//div[@class='md-text ng-binding' and contains(text(),'%s')]/parent::md-option", value)));
        wait.until(ExpectedConditions.elementToBeClickable(localSSDBy));
        clickJavascriptExecutor(localSSDBy);
    }



    public void selectDataCenterLocation(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(selectDatacenterLocation));
        clickJavascriptExecutor(selectDatacenterLocation);

        WebElement valueDatacenterLocationBy = driver.findElement(By.xpath
                (String.format("//div[@class='md-select-menu-container md-active md-clickable']" +
                        "//div[@class='md-text ng-binding' and contains(text(),'%s')]/parent::md-option", value)));
        wait.until(ExpectedConditions.elementToBeClickable(valueDatacenterLocationBy));
        clickJavascriptExecutor(valueDatacenterLocationBy);
    }

    public void selectValueCommitedUsage(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(selectCommitedUsage));
        clickJavascriptExecutor(selectCommitedUsage);
        WebElement valueCommitedUsageBy =
                driver.findElement(By.xpath(String.format
                        ("//*[@class='md-select-menu-container md-active md-clickable']" +
                                "//div[@class='md-text' and contains (text(),'%s')]/parent::md-option", value)));
        wait.until(ExpectedConditions.elementToBeClickable(valueCommitedUsageBy));
        clickJavascriptExecutor(valueCommitedUsageBy);
    }


    public void submitAddEstimate() {
        bottonAddEstimate.submit();

    }
}