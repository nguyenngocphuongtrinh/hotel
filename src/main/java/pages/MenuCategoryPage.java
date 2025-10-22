package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuCategoryPage extends BasePage{
    public MenuCategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (name= "code")
    private WebElement codeField;

    @FindBy (name= "name")
    private WebElement nameField;

    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[2]/div/div/div[2]/div/div[3]/div/div/button")
    private WebElement levelDropDown;

    @FindBy (xpath = "//*[@id=\"radix-:r5q:\"]")
    private WebElement levelListTable;

    @FindBy (xpath = "//*[@id=\"radix-:rn:\"]/div[2]/div[1]")
    private WebElement level1Button;

    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[1]/div/div[2]/button")
    private WebElement createButton;

    @FindBy (xpath = "//*[@id=\"root\"]/section/ol/li")
    private WebElement successMessage;

    @FindBy (xpath = "//p[normalize-space()='Code is required']")
    private WebElement errorCodeMessage;

    @FindBy (xpath = "//p[normalize-space()='Name is required']")
    private WebElement errorNameMessage;

    @FindBy (xpath = "//p[normalize-space()='Expected number, received string']")
    private WebElement errorLevelMessage;

    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[2]/div/div/div[2]/div/div[3]/div/div/button/div/div")
    private WebElement xButton;

    public void enterCode(String code) {
        this.codeField.sendKeys(code);
    }

    public void enterName(String level) {
        this.nameField.sendKeys(level);
    }

    public void clickLevel() {
        this.levelDropDown.click();
    }

    public void clickLevel1() {
        this.level1Button.click();
    }

    public void clickCreate() {
        this.createButton.click();
    }

    public String getSuccessMessage() {
        return this.successMessage.getText();
    }

    public String getErrorCodeMessage() {
        return this.errorCodeMessage.getText();
    }

    public String getErrorNameMessage() {
        return this.errorNameMessage.getText();
    }

    public String getErrorLevelMessage() {
        return this.errorLevelMessage.getText();
    }

    public void clickXButton() {
        this.xButton.click();
    }
}
