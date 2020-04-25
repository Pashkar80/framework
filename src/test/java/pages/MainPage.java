package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 22.10.2019.
 */
public class MainPage extends PageObject {
private  static  final  String BASE_URL=" https://cloud.google.com/";


    public MainPage() {
        super();
        PageFactory.initElements(driver,this);
    }

    public void openPage() {
        driver.get(BASE_URL);
        logger.info("Open page ("+BASE_URL +")is succeed");

    }

    WebDriverWait wait = new WebDriverWait(driver, 30);


   @FindBy(xpath = "//devsite-search//input")
    private WebElement searchButton;


public void searchingPage(String request){
    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
    searchButton.click();
    searchButton.sendKeys(request);
    searchButton.submit();
}
}