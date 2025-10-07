package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Tạo class LoginPage kế thừa từ BasePage
public class LogInPage extends BasePage {

    // Constructor
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    // Tìm phần tử WebElement bằng id "username"
    @FindBy(id="username")
    private WebElement usernameField;

    // Tìm phần tử WebElement bằng id "password"
    @FindBy(id="password")
    private WebElement passwordField;

    //Tìm phần tử WebElement bằng xpath "login button"
    @FindBy(xpath = "//button[@type='submit' and normalize-space(text())='Login']")
    private WebElement logInButton;

    @FindBy(xpath = "//p[@class='text-sm text-red-500' and normalize-space(.)='invalid password']")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = "//p[@class='text-sm text-red-500' and normalize-space(.)='failed to get user']")
    private WebElement errorMessage;

    //Actions
    public void enterUsername(String username) {
        this.usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        this.logInButton.click();
    }

    public String getInvalidPasswordErrorMessage() {
        return invalidPasswordErrorMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getUserNameField() {
        return usernameField.getText();
    }

    public String getPasswordField() {
        return passwordField.getText();
    }
}
