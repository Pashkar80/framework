package util;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabSwitcher {

    public static void SwitchTab(WebDriver driver, int number){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
    }
}