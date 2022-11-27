package com.vytrack.tests;


import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VyTrack_LogIn_POM;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_4 extends TestBase {
    // Look at note.file to understand "config" OR "sing"
    /*WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void TC64_AC1(){
        // Expected Page Title: "All - Vehicle Contract - Entities - System - Car - Entities - System"

        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract");

        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("storemanager56");

        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123");

        WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
        login.click();

        //WebElement actualTitlePage = driver.findElement(By.xpath("//html[@class='desktop-version']/head/title"));
        String expectedTitle ="All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitlePage = driver.getTitle();

        //System.out.println("actualTitlePage = " + actualTitlePage);
        //System.out.println("expectedTitle = " + expectedTitle);
        //Assert.assertEquals(actualTitlePage, expectedTitle);
        Assert.assertTrue(expectedTitle.contains(actualTitlePage));
        System.out.println("PASSED AC1");
    }

    @Test (priority = 2)
    public void TC64_AC2() {
        //WebElement alertMessage = driver.findElement(By.tagName("//div[.='You do not have permission to perform this action.']"));
        // user7 --- user12 | UserUser123
        // Drivers should NOT able to access the Vehicle contracts page, the app should display, Expected:
        // "You do not have permission to perform this action."
        driver.get("https://qa2.vytrack.com/");

        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("user10");

        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123");

        WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
        login.click();

        WebElement fleetClick = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetClick.click();

        // (//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder'])[1]/div/ul/li[6]
        WebElement vehicleContract = driver.findElement(By.xpath("(//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder'])[1]/div/ul/li[6]"));
        vehicleContract.click();

        WebElement actualAlertMessage = driver.findElement(By.xpath("(//div[@class='alert alert-error fade in top-messages '])[2]//div"));

        String expectedAlertMessage = "You do not have permission to perform this action.";

        Assert.assertTrue( expectedAlertMessage.contains(actualAlertMessage.getText()));
        System.out.println("PASSED AC2");

    }*/
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait;
    VyTrack_LogIn_POM vyTrackLogInPom;

/*
    //@Test (priority = 1)
    public void config_TS64_AC1(){
        Driver.getDriver().get(ConfigurationReader.getProperty("envV-C"));

        VyTrack_LogIn.login_crm_Sales(driver);

        BrowserUtils.verifyTitle(driver, "All - Vehicle Contract - Entities - System - Car - Entities - System");
        System.out.println("config_TC64_AC1 PASSED");
    }
    //@Test (priority = 2)
    public void config_TS64_AC2() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        VyTrack_LogIn.login_crm_Driver(driver);

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetClick.click();

        WebElement vehicleContract = Driver.getDriver().findElement(By.xpath("(//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder'])[1]/div/ul/li[6]"));
        vehicleContract.click();

        WebElement actualAlertMessage = Driver.getDriver().findElement(By.xpath("(//div[@class='alert alert-error fade in top-messages '])[2]//div"));

        String expectedAlertMessage = "You do not have permission to perform this action.";

        Assert.assertTrue( expectedAlertMessage.contains(actualAlertMessage.getText()));
        System.out.println("config_TC64_AC2 PASSED");

    }
*/

/*============================================================================================*/

//    @Test
    public void sing_TS64_AC1(){

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

//        wait.until(ExpectedConditions.visibilityOf(vyTrackLogInPom.clickFleetModule)).click();

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(3);
        fleetClick.click();

        WebElement vehicleContract = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item']//a[@href='/entity/Extend_Entity_VehicleContract']"));
        BrowserUtils.waitfor(3);
        vehicleContract.click();

        BrowserUtils.waitfor(5);

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract");
//        wait.until(ExpectedConditions.)
        Assert.assertEquals(Driver.getDriver().getTitle(), "All - Vehicle Contract - Entities - System - Car - Entities - System");

//        assert wait.until(ExpectedConditions.urlMatches("https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract"));
//        assert wait.until(ExpectedConditions.titleIs("All - Vehicle Contract - Entities - System - Car - Entities - System"));


        System.out.println("sing_TC64_AC1 PASSED");
    }

    @Test
    public void sing_TS64_AC2() {

        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty( "driver_password"));

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitFor(3);
        fleetClick.click();

        WebElement vehicleContract = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item']//a[@href='/entity/Extend_Entity_VehicleContract']"));
        BrowserUtils.waitFor(3);
        vehicleContract.click();

// "You do not have permission to perform this action."

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//div[@class='alert alert-error fade in top-messages '])[2]//div")).getText().contains("You do not have permission to perform this action."));
        System.out.println("sing_TC64_AC2 PASSED");
    }

}
