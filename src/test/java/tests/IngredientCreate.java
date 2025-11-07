package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IngredientsPage;
import pages.LogInPage;
import pages.MenuCategoryPage;
import utils.WebDriverManagerUtil;

public class IngredientCreate {
    private WebDriver driver;
    private LogInPage logInPage;
    private IngredientsPage ingredientsPage;

    @BeforeMethod
    public void setUp() throws InterruptedException{
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://tryi-ui-dev.diqit.io/login");

        logInPage = new LogInPage(driver);
        logInPage.enterUsername("hankyuhanshin.hotel");
        logInPage.enterPassword("Diqit0505@");
        logInPage.clickLoginButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/dashboard");
        ingredientsPage = new IngredientsPage(driver);
        driver.get("https://tryi-ui-dev.diqit.io/admin/ingredients/create");
        Thread.sleep(2000);
    }

    @Test
    public void ci_001() throws InterruptedException {
        ingredientsPage.enterCodeField("123");
        ingredientsPage.enterNameField("ingredient");
//        ingredientsPage.enterUnitQuantityField("");
        ingredientsPage.clickUOMField();
        Thread.sleep(1000);

        ingredientsPage.clickBoxOption();
        Thread.sleep(1000);

        ingredientsPage.enterPriceField("100");
        Thread.sleep(2000);

        ingredientsPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/ingredients");
        Assert.assertEquals(ingredientsPage.getSuccessMessage(), "Successful\nThe item has been successfully created!");
    }

    @Test
    public void ci_002() throws InterruptedException {
        ingredientsPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/ingredients/create");
        Assert.assertEquals(ingredientsPage.getErrorCodeMessage(), "Code is required");
        Assert.assertEquals(ingredientsPage.getErrorNameMessage(), "Name is required");
        Assert.assertEquals(ingredientsPage.getErrorUOMMessage(),"UOM is required");
    }

    @Test
    public void ci_003() throws InterruptedException {
        ingredientsPage.enterNameField("ingredient");
        ingredientsPage.enterUnitQuantityField("10");
        ingredientsPage.clickUOMField();
        Thread.sleep(1000);

        ingredientsPage.clickBoxOption();
        Thread.sleep(1000);

        ingredientsPage.enterPriceField("100");
        ingredientsPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/ingredients/create");
        Assert.assertEquals(ingredientsPage.getErrorCodeMessage(), "Code is required");
    }

    @Test
    public void ci_004() throws InterruptedException {
        ingredientsPage.enterCodeField("123");
        ingredientsPage.enterUnitQuantityField("10");
        ingredientsPage.clickUOMField();
        Thread.sleep(1000);

        ingredientsPage.clickBoxOption();
        Thread.sleep(1000);

        ingredientsPage.enterPriceField("100");
        ingredientsPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/ingredients/create");
        Assert.assertEquals(ingredientsPage.getErrorNameMessage(), "Name is required");
    }

    @Test
    public void ci_005() throws InterruptedException {
        ingredientsPage.enterCodeField("123");
        ingredientsPage.enterNameField("ingredient");
        ingredientsPage.enterUnitQuantityField("0");
        ingredientsPage.clickUOMField();
        Thread.sleep(1000);

        ingredientsPage.clickBoxOption();
        Thread.sleep(1000);

        ingredientsPage.enterPriceField("100");
        ingredientsPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/ingredients/create");
        Assert.assertEquals(ingredientsPage.getErrorUnitQuantityMessage(), "Unit quantity must be greater than 0");
    }

    @Test
    public void ci_006() throws InterruptedException {
        ingredientsPage.enterCodeField("123");
        ingredientsPage.enterNameField("ingredient");
        ingredientsPage.enterUnitQuantityField("0");
        ingredientsPage.clickUOMField();
        Thread.sleep(1000);

        ingredientsPage.clickBoxOption();
        Thread.sleep(1000);

        ingredientsPage.enterPriceField("100");
        ingredientsPage.clickCreateButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/ingredients/create");
        Assert.assertEquals(ingredientsPage.getErrorUOMMessage(), "UOM is required");
    }
}
