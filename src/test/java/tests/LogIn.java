package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverManagerUtil;

public class LogIn {
    private WebDriver driver;
    private pages.LogInPage logInPage;
    String expectedURL = "https://tryi-ui-dev.diqit.io/dashboard";

    //Thiết lập trước khi chạy các test
    @BeforeMethod
    public void setup() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://tryi-ui-dev.diqit.io/login");
        logInPage = new pages.LogInPage(driver);
    }

    //Verify login successfully with valid credentials
    @Test
    public void log_001() throws InterruptedException {
        logInPage.enterUsername("hankyuhanshin.hotel");
        logInPage.enterPassword("Diqit0505@");
        logInPage.clickLoginButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), this.expectedURL);
    }

    @Test
    public void log_002() throws InterruptedException {
        logInPage.enterUsername("hankyuhanshin.hotel");
        logInPage.enterPassword("diqit");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getInvalidPasswordErrorMessage(), "invalid password");
    }

    @Test
    public void log_003() throws InterruptedException {
        logInPage.enterUsername("hotel");
        logInPage.enterPassword("123Tt@");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getErrorMessage(), "failed to get user");
    }

    @Test
    public void log_004() throws InterruptedException {
        logInPage.enterUsername("");
        logInPage.enterPassword("Diqit0505@");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getUserNameField(), "");
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/login");
    }

    @Test
    public void log_005() throws InterruptedException {
        logInPage.enterUsername("hankyuhanshin.hotel");
        logInPage.enterPassword("");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getPasswordField(), "");
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/login");
    }

    @Test
    public void log_006() throws InterruptedException {
        logInPage.enterUsername("");
        logInPage.enterPassword("");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getUserNameField(), "");
        Assert.assertEquals(logInPage.getPasswordField(), "");
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/login");
    }

    @Test
    public void log_007() throws InterruptedException {
        logInPage.enterUsername(" hankyuhanshin.hotel ");
        logInPage.enterPassword("Diqit0505@");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getErrorMessage(), "failed to get user");
    }

    @Test
    public void log_008() throws InterruptedException {
        logInPage.enterUsername("sakura.hotel");
        logInPage.enterPassword("Diqit0505@");
        logInPage.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertEquals(logInPage.getErrorMessage(), "failed to get user");
    }
}
