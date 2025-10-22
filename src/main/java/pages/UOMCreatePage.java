package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UOMCreatePage extends BasePage {

    // Constructor
    public UOMCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (name="name")
    private WebElement nameField;

    @FindBy (name="code")
    private WebElement codeField;

    @FindBy (name="desc")
    private WebElement descriptionField;

    @FindBy (xpath ="//button[@role='switch']")
    private WebElement statusButton;

    @FindBy (xpath ="//button[normalize-space()='Create']")
    private WebElement createButton;

    @FindBy (xpath ="//li[contains(@class,'toast-with-icon') and .//div[normalize-space(.)='The item has been successfully created!']]")
    private WebElement successMessage;

    @FindBy (xpath ="//p[@data-slot='form-message' and normalize-space()='Name is required']")
    private WebElement errorMessageNameField;

    @FindBy (xpath ="//p[@data-slot='form-message' and normalize-space()='Code is required']")
    private WebElement errorMessageCodeField;

    @FindBy (xpath ="//p[@data-slot='form-message' and normalize-space()='Description is required']")
    private WebElement errorMessageDescriptionField;

    public void enterName (String name){
        this.nameField.sendKeys(name);
    }

    public void enterCode (String code){
        this.codeField.sendKeys(code);
    }

    public void enterDescription(String description){
        this.descriptionField.sendKeys(description);
    }

    public void clickOnStatusButton(){
        this.statusButton.click();
    }

    public void clickOnCreateButton(){
        this.createButton.click();
    }

    public  String getSuccessMessage(){
        return this.successMessage.getText();
    }

    public  String getErrorMessageNameField(){
        return this.errorMessageNameField.getText();
    }

    public  String getErrorMessageCodeField(){
        return this.errorMessageCodeField.getText();
    }

    public  String getErrorMessageDescriptionField(){
        return this.errorMessageDescriptionField.getText();
    }
}
