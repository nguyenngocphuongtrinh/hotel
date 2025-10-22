package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UOMConversionCreatePage extends BasePage {
    public UOMConversionCreatePage(WebDriver driver) {
        super(driver);
    }

    //
    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[2]/div/div/div[2]/div/div[1]/div/div/button")
    private WebElement baseUOMDropDownButton;

    @FindBy (xpath = "//div[@class='flex-1 line-clamp-1' and normalize-space()='kg']")
    private WebElement kilogramOptionDropDownListBaseUOM;

    @FindBy (xpath = "//*[@id=\":ru:-form-item-message\"]")
    private WebElement errorBaseUOMFieldMessage;

    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[2]/div/div/div[2]/div/div[2]/div/div/button")
    private WebElement targetUOMDropDownButton;

    @FindBy (xpath = "//div[@role='dialog']//div[@class='flex-1 line-clamp-1' and normalize-space()='g']")
    private WebElement gamOptionDropDownListTargetUOM;

    @FindBy (xpath = "//*[@id=\":r10:-form-item-message\"]")
    private WebElement errorTargetUOMFieldMessage;

    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[2]/div/div/div[2]/div/div[3]/div/div/input")
    private WebElement conversionRateField;

    @FindBy (xpath = "//*[@id=\":r12:-form-item-message\"]")
    private WebElement errorConversionRateFieldMessage;

    @FindBy (xpath = "//*[@id=\"root\"]/div/main/div/main/form/div/div[1]/div/div[2]/button")
    private WebElement createUOMButton;

    public void clickBaseUOMDropDownButton(){
        this.baseUOMDropDownButton.click();
    }

    public void clickKilogramOptionDropDownListBaseUOM(){
        this.kilogramOptionDropDownListBaseUOM.click();
    }

    public String getErrorBaseUOMFieldMessage(){
        return this.errorBaseUOMFieldMessage.getText();
    }

    public void clickTargetUOMDropDownButton(){
        this.targetUOMDropDownButton.click();
    }

    public void clickGamOptionDropDownListTargetUOM(){
        this.gamOptionDropDownListTargetUOM.click();
    }

    public String getErrorTargetUOMFieldMessage(){
        return this.errorTargetUOMFieldMessage.getText();
    }

    public void enterConversionRateField(String conversionRate){
        this.conversionRateField.sendKeys(conversionRate);
    }

    public String getErrorConversionRateField(){
        return this.errorConversionRateFieldMessage.getText();
    }

    public void clickCreateUOMButton(){
        this.createUOMButton.click();
    }
}
