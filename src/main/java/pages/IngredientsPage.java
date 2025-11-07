package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IngredientsPage extends BasePage {
    public IngredientsPage(WebDriver driver) {
        super(driver);
    }

    //Locations
    @FindBy (name = "code")
    private WebElement codeField;

    @FindBy (name = "name")
    private WebElement nameField;

    @FindBy (xpath = "//*[@id=\":r3r:-form-item\"]")
    private WebElement isSpecificButton;

    @FindBy (xpath = "//input[@type='number']")
    private WebElement unitQuantityField;

    @FindBy (xpath = "//button[.//span[normalize-space()='Select UOM']]")
    private WebElement uOMField;

    @FindBy (xpath = "//*[@id=\"radix-:r41:\"]/div[2]/div[3]/div")
    private WebElement boxOption;

    @FindBy (xpath = "//input[@type='number' and @placeholder='0']")
    private WebElement priceField;

    @FindBy (xpath = "//button[@type='submit' and normalize-space()='Create']")
    private WebElement createButton;

    @FindBy (xpath = "//li[@data-type='success' and @data-visible='true']")
    private WebElement successMessage;

    @FindBy (xpath = "//li[@data-type='error' and @data-visible='true']")
    private WebElement createFailMessage;

    @FindBy (xpath = "//*[@id=\":r16:-form-item-message\"]")
    private WebElement errorCodeMessage;

    @FindBy (xpath = "//*[@id=\":r17:-form-item-message\"]")
    private WebElement errorNameMessage;

    @FindBy (xpath = "//*[@id=\":r1c:-form-item-message\"]")
    private WebElement errorUnitQuantityMessage;

    @FindBy (xpath = "//*[@id=\":r1d:-form-item-message\"]")
    private WebElement errorUOMMessage;

    //Actions
    public void enterCodeField(String code) {
        this.codeField.sendKeys(code);
    }

    public void enterNameField(String name) {
        this.nameField.sendKeys(name);
    }

    public void clickIsSpecificButton() {
        this.isSpecificButton.click();
    }

    public void enterUnitQuantityField(String unitQuantity) {
        this.unitQuantityField.sendKeys(unitQuantity);
    }

    public void clickUOMField() {
        this.uOMField.click();
    }

    public void clickBoxOption() {
        this.boxOption.click();
    }

    public void enterPriceField(String price) {
        this.priceField.sendKeys(price);
    }

    public void clickCreateButton() {
        this.createButton.click();
    }

    public String getSuccessMessage() {
        return this.successMessage.getText();
    }

    public String getCreateFailMessage() {
        return this.createFailMessage.getText();
    }

    public String getErrorCodeMessage() {
        return this.errorCodeMessage.getText();
    }

    public String getErrorNameMessage() {
        return this.errorNameMessage.getText();
    }

    public String getErrorUnitQuantityMessage() {
        return this.errorUnitQuantityMessage.getText();
    }

    public String getErrorUOMMessage() {
        return this.errorUOMMessage.getText();
    }
}
