package util;

import driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class BrowserTabManager {

    private static final WebDriver driver;
    private static ArrayList<String> windowHandles;

    static {
        driver = DriverSingleton.getDriver();
    }

    public static void openNewTab(String link) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchTab();
        driver.get(link);
    }

    public static void switchTab() {
        if (windowHandles == null || windowHandles.size() == 0) {
            windowHandles = new ArrayList<>(driver.getWindowHandles());
        }

        String currentWindowHandle = driver.getWindowHandle();
        String switchTo = windowHandles.stream().filter(s -> !s.equals(currentWindowHandle)).findFirst().orElse(null);
        driver.switchTo().window(switchTo);
    }
}
