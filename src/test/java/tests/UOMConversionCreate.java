package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.UOMConversionCreatePage;
import pages.UOMCreatePage;
import utils.WebDriverManagerUtil;

public class UOMConversionCreate {
    private WebDriver driver;
    private LogInPage logInPage;
    private UOMConversionCreatePage uomConversionCreatePage;
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

        uomConversionCreatePage = new UOMConversionCreatePage(driver);
        driver.get("https://tryi-ui-dev.diqit.io/admin/uom-conversion/create");

        Thread.sleep(2000);
    }

    @Test
    public void cuc_001 () throws InterruptedException {
        uomConversionCreatePage.clickBaseUOMDropDownButton();
        uomConversionCreatePage.clickKilogramOptionDropDownListBaseUOM();
        Thread.sleep(1000);
        uomConversionCreatePage.clickTargetUOMDropDownButton();
        uomConversionCreatePage.clickGamOptionDropDownListTargetUOM();
        Thread.sleep(1000);
        uomConversionCreatePage.enterConversionRateField("1");
        uomConversionCreatePage.clickCreateUOMButton();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom-conversion");
    }

    @Test
    public void cuc_002 () throws InterruptedException {
        Thread.sleep(3000);

        uomConversionCreatePage.clickCreateUOMButton();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom-conversion/create");
        Assert.assertEquals(uomConversionCreatePage.getErrorBaseUOMFieldMessage(),"This field is required");
        Assert.assertEquals(uomConversionCreatePage.getErrorTargetUOMFieldMessage(),"This field is required");
        Assert.assertEquals(uomConversionCreatePage.getErrorConversionRateField(),"This field is required");
    }

    @Test
    public void cuc_003 () throws InterruptedException {
        uomConversionCreatePage.clickTargetUOMDropDownButton();
        uomConversionCreatePage.clickGamOptionDropDownListTargetUOM();
        Thread.sleep(1000);

        uomConversionCreatePage.enterConversionRateField("1");
        Thread.sleep(1000);

        uomConversionCreatePage.clickCreateUOMButton();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom-conversion/create");
        Assert.assertEquals(uomConversionCreatePage.getErrorBaseUOMFieldMessage(),"This field is required");
    }

    @Test
    public void cuc_004 () throws InterruptedException {
        uomConversionCreatePage.clickBaseUOMDropDownButton();
        uomConversionCreatePage.clickKilogramOptionDropDownListBaseUOM();
        Thread.sleep(1000);

        uomConversionCreatePage.enterConversionRateField("1");
        Thread.sleep(1000);

        uomConversionCreatePage.clickCreateUOMButton();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom-conversion/create");
        Assert.assertEquals(uomConversionCreatePage.getErrorBaseUOMFieldMessage(),"This field is required");
    }

    @Test
    public void cuc_005 () throws InterruptedException {
        uomConversionCreatePage.clickBaseUOMDropDownButton();
        uomConversionCreatePage.clickKilogramOptionDropDownListBaseUOM();
        Thread.sleep(2000);

        uomConversionCreatePage.clickTargetUOMDropDownButton();
        uomConversionCreatePage.clickGamOptionDropDownListTargetUOM();
        Thread.sleep(2000);

        uomConversionCreatePage.clickCreateUOMButton();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://tryi-ui-dev.diqit.io/admin/uom-conversion/create");
        Assert.assertEquals(uomConversionCreatePage.getErrorConversionRateField(), "This field is required");
    }
}
