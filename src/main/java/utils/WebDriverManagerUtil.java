package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//File này giúp quản lý trình duyệt (chrome)
//Muốn test chrome thì gọi file này
public class WebDriverManagerUtil {
    private static WebDriver driver;

    //func mở chrome để test
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup(); // Tự động tải và setup driver
            driver = new ChromeDriver();
        }
        return driver;
    }

    //func quit chrome
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
