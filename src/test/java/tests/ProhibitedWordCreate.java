package tests;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProhibitedWordPage;
import utils.WebDriverManagerUtil;

public class ProhibitedWordCreate {
    private WebDriver driver;
    private LogInPage logInPage;
    public ProhibitedWordPage prohibitedWordPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://tryi-ui-dev.diqit.io/login");

        logInPage = new LogInPage(driver);
        logInPage.enterUsername("hankyuhanshin.hotel");
        logInPage.enterPassword("Diqit0505@");
        logInPage.clickLoginButton();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/dashboard");

        prohibitedWordPage = new ProhibitedWordPage(driver);
        driver.get("https://tryi-ui-dev.diqit.io/admin/sensitive-word/create");

        Thread.sleep(2000);
    }

//    Verify that a Prohibited Word is created successfully
    @Test
    public void cpw_001() throws InterruptedException {
        prohibitedWordPage.enterWord("test");
        prohibitedWordPage.enterLevel("1");
        Thread.sleep(2000);

        prohibitedWordPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/sensitive-word");
        Assert.assertEquals(prohibitedWordPage.getSuccessMessage(), "Successful\nThe item has been successfully created!");
    }

//    Verify that a Prohibited Word cannot be created when all fields are blank
    @Test
    public void cpw_002() throws InterruptedException {
        prohibitedWordPage.enterWord("");
        prohibitedWordPage.enterLevel("");
        Thread.sleep(2000);

        prohibitedWordPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(prohibitedWordPage.getErrorMessageWordField(),"Word is required");
        Assert.assertEquals(prohibitedWordPage.getErrorMessageLevelField(),"Level is required");
    }

//    Verify that a Prohibited Word cannot be created when Word field is blank
    @Test
    public void cpw_003() throws InterruptedException {
        prohibitedWordPage.enterWord("");
        prohibitedWordPage.enterLevel("1");
        Thread.sleep(2000);

        prohibitedWordPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(prohibitedWordPage.getErrorMessageWordField(),"Word is required");
    }
//    Verify that a Prohibited Word cannot be created when Level field is blank
    @Test
    public void cpw_004() throws InterruptedException {
        prohibitedWordPage.enterWord("test");
        prohibitedWordPage.enterLevel("0");
        Thread.sleep(2000);

        prohibitedWordPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(prohibitedWordPage.getErrorMessageLevelField(),"Level is required");
    }

//    Verify that duplicate prohibited word creation is not allowed
    @Test
    public void cpw_005() throws InterruptedException {
        prohibitedWordPage.enterWord("a");
        prohibitedWordPage.enterLevel("1");
        Thread.sleep(2000);

        prohibitedWordPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(prohibitedWordPage.getErrorFailedMessage(),"Failed\nCreate failed!");
    }
}
