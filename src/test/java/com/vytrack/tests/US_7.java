package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VyTrack_LogIn_POM;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_7 extends TestBase{
    WebDriverWait wait;
    VyTrack_LogIn_POM vyTrackLogInPom;
    LoginPage loginPage = new LoginPage();



    @Test
    public void TS67_AC1() {
        /**once the user launched to the Vehicle page, all the checkboxes should be unchecked
         Driver.getDriver().get(ConfigurationReader.getProperty("env"));
         VyTrack_LogIn.login_crm_Sales(Driver.getDriver());

         WebElement fleetClick = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
         BrowserUtils.sleep(2);
         fleetClick.click();

         WebElement vehiclesClick = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown-menu-single-item first'])[2]/a/span"));
         BrowserUtils.sleep(2);
         vehiclesClick.click();

         WebElement checkBox = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]/input"));
         checkBox.isDisplayed();
         */

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        BrowserUtils.waitfor(2);

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(3);
        fleetClick.click();

        WebElement vehiclesClick = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown-menu-single-item first'])[2]/a/span"));
        //BrowserUtils.sleep(2);
        vehiclesClick.click();

        BrowserUtils.waitfor(2);
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]/input"));
        checkBox.isDisplayed();

        System.out.println("TS67_AC1 PASSED");
    }

    @Test
    public void TS67_AC2() {
        //user check the first checkbox to check all the cars
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        BrowserUtils.waitfor(2);

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(3);
        fleetClick.click();

        WebElement vehiclesClick = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown-menu-single-item first'])[2]/a/span"));
        //BrowserUtils.sleep(2);
        vehiclesClick.click();

        BrowserUtils.waitfor(2);
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]/input"));
        BrowserUtils.waitfor(2);
        checkBox.click();
        BrowserUtils.waitfor(2);

        System.out.println("TS67_AC2 PASSED");
    }

    @Test
    public void TS67_AC3() {
        //users can select any car
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));
        BrowserUtils.waitfor(2);

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(3);
        fleetClick.click();

        WebElement vehiclesClick = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown-menu-single-item first'])[2]/a/span"));
        //BrowserUtils.sleep(2);
        vehiclesClick.click();

        BrowserUtils.waitfor(3);
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("(//tr[@class='grid-row row-click-action'])[9]/td[1]/input"));
        checkBox.click();
        BrowserUtils.waitfor(2);

        System.out.println("TS67_AC3 PASSED");

    }



}
