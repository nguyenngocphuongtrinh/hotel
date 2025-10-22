package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProhibitedWordPage extends BasePage {
    public ProhibitedWordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (name="word")
    private WebElement wordField;

    @FindBy (name="level")
    private WebElement levelField;

    @FindBy (xpath ="//*[@id=\"root\"]/div/main/div/main/form/div/div[1]/div/div[2]/button")
    private WebElement createButton;

    @FindBy (xpath ="//*[@id=\"root\"]/section/ol/li")
    private WebElement successMessage;

    @FindBy (xpath ="//*[@id=\"root\"]/section/ol/li")
    private WebElement errorFailedMessage;

    @FindBy (xpath ="//p[normalize-space()='Word is required']")
    private WebElement errorMessageWordField;

    @FindBy (xpath ="//p[normalize-space()='Level is required']")
    private WebElement errorMessageLevelField;

    public void enterWord(String word){
        this.wordField.sendKeys(word);
    }

    public void enterLevel(String level){
        this.levelField.sendKeys(level);
    }

    public void clickCreateButton(){
        this.createButton.click();
    }

    public String getSuccessMessage(){
        return this.successMessage.getText();
    }

    public String getErrorFailedMessage(){
        return this.errorFailedMessage.getText();
    }

    public String getErrorMessageWordField(){
        return this.errorMessageWordField.getText();
    }

    public String getErrorMessageLevelField(){
        return this.errorMessageLevelField.getText();
    }
}
