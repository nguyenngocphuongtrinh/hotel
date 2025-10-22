package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ImportantControlPointPage;
import pages.LogInPage;
import pages.UOMCreatePage;
import utils.WebDriverManagerUtil;

public class ImportantControlPointCreate {
    private WebDriver driver;
    private LogInPage logInPage;
    private ImportantControlPointPage importantControlPointPage;

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

        importantControlPointPage = new ImportantControlPointPage(driver);
        driver.get("https://tryi-ui-dev.diqit.io/admin/important-management-item/create");

        Thread.sleep(2000);
    }

//    Verify that an Important Control Point is created successfully
    @Test
    public void cicp_001 () throws InterruptedException {
        importantControlPointPage.enterCode("123");
        importantControlPointPage.enterName("test1");
        Thread.sleep(2000);
        importantControlPointPage.clickCreateButton();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/important-management-item");
        Assert.assertEquals(importantControlPointPage.getSuccessMessage(), "Successful\nThe item has been successfully created!");
    }

//    Verify that an Important Control Point cannot be created when all fields are blank
    @Test
    public void cicp_002 () throws InterruptedException {
        importantControlPointPage.enterCode("");
        importantControlPointPage.enterName("");
        Thread.sleep(2000);
        importantControlPointPage.clickCreateButton();

        Thread.sleep(2000);
        Assert.assertEquals(importantControlPointPage.getErrorMessageCodeField(), "Code is required" );
        Assert.assertEquals(importantControlPointPage.getErrorMessageNameField(), "Name is required" );

    }

//    Verify that an Important Control Point cannot be created when Code field is blank
    @Test
    public void cicp_003 () throws InterruptedException {
        importantControlPointPage.enterCode("");
        importantControlPointPage.enterName("test1");
        Thread.sleep(2000);
        importantControlPointPage.clickCreateButton();

        Assert.assertEquals(importantControlPointPage.getErrorMessageCodeField(), "Code is required" );
    }

//    Verify that an Important Control Point cannot be created when Name field is blank
    @Test
    public void cicp_004 () throws InterruptedException {
        importantControlPointPage.enterCode("123");
        importantControlPointPage.enterName("");
        Thread.sleep(2000);
        importantControlPointPage.clickCreateButton();

        Assert.assertEquals(importantControlPointPage.getErrorMessageNameField(), "Name is required" );
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        WebDriverManagerUtil.closeDriver();
    }
}
