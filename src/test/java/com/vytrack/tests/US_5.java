package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_5 extends TestBase {
    LoginPage loginPage = new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    //@Test
    public void TS65_AC1(){
        //Expected Column names:
        // MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS
        //Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(2);
        fleetClick.click();

        WebElement clickVehiclesModel = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//span[.='Vehicles Model']"));
        BrowserUtils.waitfor(2);
        clickVehiclesModel.click();

        WebElement modelName = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[2]//span[.='Model Name']"));
        Assert.assertTrue(modelName.getText().contains("MODEL NAME"));
        System.out.println("MODEL NAME PASSED");

        WebElement make = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[3]//span[.='Make']"));
        Assert.assertTrue(make.getText().contains("MAKE"));
        System.out.println("MAKE PASSED");

        WebElement canBe = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[4]//span[.='Can be requested']"));
        Assert.assertTrue(canBe.getText().contains("CAN BE REQUESTED"));
        System.out.println("CAN BE REQUESTED PASSED");

        WebElement cvvi = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[5]//span[.='CVVI']"));
        Assert.assertTrue(cvvi.getText().contains("CVVI"));
        System.out.println("CVVI PASSED");

        WebElement cosFee = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[6]//span[.='CO2 Fee (/month)']"));
        Assert.assertTrue(cosFee.getText().contains("CO2 FEE (/MONTH)"));
        System.out.println("CO2 FEE (/MONTH) PASSED");

        WebElement cost = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[7]//span[.='Cost (Depreciated)']"));
        Assert.assertTrue(cost.getText().contains("COST (DEPRECIATED)"));
//        System.out.println("COST (DEPRECIATED) PASSED");

        WebElement totalCost = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[8]//span[.='Total Cost (Depreciated)']"));
        Assert.assertTrue(totalCost.getText().contains("TOTAL COST (DEPRECIATED)"));
        System.out.println("TOTAL COST (DEPRECIATED) PASSED");

        WebElement co2Emissions = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[9]//span[.='CO2 Emissions']"));
        Assert.assertTrue(co2Emissions.getText().contains("CO2 EMISSIONS"));
        System.out.println("CO2 EMISSIONS PASSED");

        WebElement fuelType = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[10]//span[.='Fuel Type']"));
        Assert.assertTrue(fuelType.getText().contains("FUEL TYPE"));
        System.out.println("FUEL TYPE PASSED");

        WebElement vendors = Driver.getDriver().findElement(By.xpath("//div[@class='grid-scrollable-container']//tr[@class='grid-header-row']//th[11]//span[.='Vendors']"));
        Assert.assertTrue(vendors.getText().contains("VENDORS"));
        System.out.println("VENDORS PASSED");

    }

    //@Test // ERROR
    public void TS65_AC2(){
        //  (//li[@class='dropdown dropdown-level-1'])[1]

        //AC #2: Drivers should not able to access the Vehicle Model page, users should see “You do not have permission to perform this action.”
        //Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(2);
        fleetClick.click();

        BrowserUtils.waitfor(2);

        WebElement clickVehiclesModel = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]/div/div/ul/li[9]/a"));
        BrowserUtils.waitfor(2);
        clickVehiclesModel.click();


    }

}
