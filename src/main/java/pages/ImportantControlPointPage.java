package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportantControlPointPage extends BasePage {
    public ImportantControlPointPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (name="code")
    private WebElement codeField;

    @FindBy (name="name")
    private WebElement nameField;

    @FindBy (xpath ="//*[@id=\"root\"]/div/main/div/main/form/div/div[1]/div/div[2]/button")
    private WebElement createButton;

    @FindBy (xpath ="//*[@id=\"root\"]/section/ol/li")
    private WebElement successMessage;

    @FindBy (xpath ="//p[normalize-space()='Code is required']")
    private WebElement errorMessageCodeField;

    @FindBy (xpath = "//p[normalize-space()='Name is required']")
    private WebElement errorMessageNameField;

    public void enterCode(String code) {
        this.codeField.sendKeys(code);
    }

    public void enterName(String name) {
        this.nameField.sendKeys(name);
    }

    public void clickCreateButton() {
        this.createButton.click();
    }

    public String getSuccessMessage() {
        return this.successMessage.getText();
    }

    public String getErrorMessageCodeField() {
        return this.errorMessageCodeField.getText();
    }

    public String getErrorMessageNameField() {
        return this.errorMessageNameField.getText();
    }
}
