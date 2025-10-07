package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Phương thức để lấy tiêu đề của trang hiện tại
    public String getTitle() {
        return driver.getTitle();
    }



}
