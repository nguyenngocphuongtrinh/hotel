package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MenuCategoryPage;
import pages.ProhibitedWordPage;
import utils.WebDriverManagerUtil;

public class MenuCategoryCreate {
    private WebDriver driver;
    private LogInPage logInPage;
    private MenuCategoryPage menuCategoryPage;

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

        menuCategoryPage = new MenuCategoryPage(driver);
        driver.get("https://tryi-ui-dev.diqit.io/admin/menu-category/create");

        Thread.sleep(2000);
    }

//    Verify that a Menu Category is created successfully
    @Test
    public void cmc_001() throws InterruptedException {
        menuCategoryPage.enterCode("123");
        menuCategoryPage.enterName("test");
//        menuCategoryPage.clickLevel();
//        menuCategoryPage.clickLevel1();

        Thread.sleep(2000);
        menuCategoryPage.clickCreate();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/menu-category");
        Assert.assertEquals(menuCategoryPage.getSuccessMessage(), "Successful\nThe item has been successfully created!");
    }

//    Verify that a Menu Category cannot be created when all fields are blank
@Test
    public void cmc_002() throws InterruptedException {
        menuCategoryPage.enterCode("");
        menuCategoryPage.enterName("");

        Thread.sleep(2000);
        menuCategoryPage.clickCreate();

        Thread.sleep(2000);
        Assert.assertEquals(menuCategoryPage.getErrorCodeMessage(),"Code is required");
        Assert.assertEquals(menuCategoryPage.getErrorNameMessage(), "Name is required");
    }

//    Verify that a Menu Category cannot be created when Code field is blank
    @Test
    public void cmc_003() throws InterruptedException {
        menuCategoryPage.enterCode("");
        menuCategoryPage.enterName("test");

        Thread.sleep(2000);
        menuCategoryPage.clickCreate();

        Thread.sleep(2000);
        Assert.assertEquals(menuCategoryPage.getErrorCodeMessage(),"Code is required");
    }

//    Verify that a Menu Category cannot be created when Name field is blank
    @Test
    public void cmc_004() throws InterruptedException {
        menuCategoryPage.enterCode("123");
        menuCategoryPage.enterName("");

        Thread.sleep(2000);
        menuCategoryPage.clickCreate();

        Thread.sleep(2000);
        Assert.assertEquals(menuCategoryPage.getErrorNameMessage(), "Name is required");
    }

    @Test
    public void cmc_005() throws InterruptedException {
        menuCategoryPage.enterCode("123");
        menuCategoryPage.enterName("test");
        menuCategoryPage.clickXButton();

        Thread.sleep(2000);
        menuCategoryPage.clickCreate();

        Thread.sleep(2000);
        Assert.assertEquals(menuCategoryPage.getErrorLevelMessage(), "Expected number, received string");
    }
}
