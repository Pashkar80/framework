package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})

public class CommonConditions {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public void stopDriver() {
        DriverSingleton.closeDriver();
    }
}