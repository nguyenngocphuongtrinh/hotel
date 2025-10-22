package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UOMListPage extends BasePage {

    // Constructor
    public UOMListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//*[@id=\"root\"]/div/main/div/main/div/div[3]/div[1]/div/table/tbody/tr[1]/td[4]/div/button[1]")
    private WebElement editButton;

    @FindBy (xpath ="//*[@id=\"root\"]/div/main/div/main/div/div[3]/div[1]/div/table/tbody/tr[1]/td[4]/div/button[2]")
    private WebElement deleteButton;

    public void clickEditButton() {
        this.editButton.click();
    }

    public void clickDeleteButton() {
        this.deleteButton.click();
    }
}
