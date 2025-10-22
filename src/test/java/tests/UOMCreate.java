package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.UOMCreatePage;
import utils.WebDriverManagerUtil;

public class UOMCreate {
    private WebDriver driver;
    private LogInPage logInPage;
    private UOMCreatePage uomCreatePage;
    String expectedURL = "https://tryi-ui-dev.diqit.io/dashboard";

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

        uomCreatePage = new UOMCreatePage(driver);
        driver.get("https://tryi-ui-dev.diqit.io/admin/uom/create");

        Thread.sleep(2000);
    }

//    Verify that an UOM is created successfully
    @Test
    public void cuom_001 () throws InterruptedException {
        uomCreatePage.enterName("test");
        uomCreatePage.enterCode("TEST");
        uomCreatePage.enterDescription("description");
        Thread.sleep(3000);
        uomCreatePage.clickOnCreateButton();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom");
        Assert.assertEquals(uomCreatePage.getSuccessMessage(), "Successful\nThe item has been successfully created!");
    }

//    Verify that a UOM cannot be created when all fields are blank
    @Test
    public void cuom_002 () throws InterruptedException {
        uomCreatePage.enterName("");
        uomCreatePage.enterCode("");
        uomCreatePage.enterDescription("");
        Thread.sleep(3000);
        uomCreatePage.clickOnCreateButton();

        Thread.sleep(1000);
        Assert.assertEquals(uomCreatePage.getErrorMessageNameField(), "Name is required" );
        Assert.assertEquals(uomCreatePage.getErrorMessageCodeField(), "Code is required" );
        Assert.assertEquals(uomCreatePage.getErrorMessageDescriptionField(), "Description is required" );
    }

//    Verify that a UOM cannot be created without entering the Name field
    @Test
    public void cuom_003 () throws InterruptedException {
        uomCreatePage.enterName("");
        uomCreatePage.enterCode("TEST");
        uomCreatePage.enterDescription("description");
        Thread.sleep(3000);
        uomCreatePage.clickOnCreateButton();

        Thread.sleep(1000);
        Assert.assertEquals(uomCreatePage.getErrorMessageNameField(), "Name is required" );
    }

//    Verify that a UOM cannot be created without entering the Code field
    @Test
    public void cuom_004 () throws InterruptedException {
        uomCreatePage.enterName("test");
        uomCreatePage.enterCode("");
        uomCreatePage.enterDescription("description");
        Thread.sleep(3000);
        uomCreatePage.clickOnCreateButton();

        Thread.sleep(1000);
        Assert.assertEquals(uomCreatePage.getErrorMessageCodeField(), "Code is required" );
    }

//    Verify that a UOM cannot be created without entering the Description field
    @Test
    public void cuom_005 () throws InterruptedException {
        uomCreatePage.enterName("test");
        uomCreatePage.enterCode("TEST");
        uomCreatePage.enterDescription("");
        Thread.sleep(3000);
        uomCreatePage.clickOnCreateButton();

        Thread.sleep(1000);
        Assert.assertEquals(uomCreatePage.getErrorMessageDescriptionField(), "Description is required" );
    }

//    Verify that a UOM is created successfully with Inactive status
    @Test
    public void cuom_006 () throws InterruptedException {
        uomCreatePage.enterName("test");
        uomCreatePage.enterCode("TEST");
        uomCreatePage.enterDescription("description");
        uomCreatePage.clickOnStatusButton(); //create UOM with status is Inactive
        Thread.sleep(3000);
        uomCreatePage.clickOnCreateButton();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom");
        Assert.assertEquals(uomCreatePage.getSuccessMessage(), "Successful\nThe item has been successfully created!");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        WebDriverManagerUtil.closeDriver();
    }
}
