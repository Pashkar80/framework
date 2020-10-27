package pages;




import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import javax.naming.OperationNotSupportedException;


/**
 * Created by user on 22.10.2019.
 */
public abstract class PageObject {
    protected WebDriver driver;
    protected  final Logger logger;
    public  abstract  void  openPage() throws OperationNotSupportedException;


    public PageObject() {
        this.driver = DriverSingleton.getDriver();
        this.logger=  LogManager.getRootLogger();
        PageFactory.initElements(driver, this);
    }

    public void clickJavascriptExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);

    }
}
