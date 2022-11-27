package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class US_1 {

    LoginPage loginPage = new LoginPage();


    //@Test
    public void TS61_AC1(){
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));

        WebElement dashboards = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Dashboards'])[1]"));
        Assert.assertTrue(dashboards.getText().contains("Dashboards"));
        System.out.println("Dashboards PASSED");

        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Fleet'])[1]"));
        Assert.assertEquals(fleet.getText(), "Fleet");
        System.out.println("Fleet PASSED");

        WebElement customers = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Customers'])[1]"));
        Assert.assertEquals(customers.getText(), "Customers");
        System.out.println("Customers PASSED");

        WebElement sales = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Sales'])[1]"));
        Assert.assertEquals(sales.getText(), "Sales");
        System.out.println("Sales PASSED");

        WebElement activities = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Activities'])[1]"));
        Assert.assertEquals(activities.getText(), "Activities");
        System.out.println("Activities PASSED");

        WebElement marketing = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Marketing'])[1]"));
        Assert.assertEquals(marketing.getText(), "Marketing");
        System.out.println("Marketing PASSED");

        WebElement reports_segments = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='Reports & Segments'])[1]"));
        Assert.assertEquals(reports_segments.getText(), "Reports & Segments");
        System.out.println("Reports & Segments PASSED");

        WebElement system = Driver.getDriver().findElement(By.xpath("(//span[normalize-space(text())='System'])[1]"));
        Assert.assertEquals(system.getText(), "System");
        System.out.println("System PASSED");

        Driver.getDriver().quit();

    }

    //@Test
    public void TS61_AC2(){

        //====== Error
        //WebElement fleet = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li[1]/a/span"));
        //Assert.assertEquals(fleet.getText(), "Fleet");
        //System.out.println("Fleet PASSED");
        //====== Error

        WebElement customers = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][2]"));
        Assert.assertEquals(customers.getText(), "Customers");
        System.out.println("Customers PASSED");

        WebElement activities = Driver.getDriver().findElement(By.xpath("(//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'])[3]/a/span"));
        Assert.assertEquals(activities.getText(), "Activities");
        System.out.println("Activities PASSED");

        WebElement system = Driver.getDriver().findElement(By.xpath("(//div[@id='main-menu']//li[@class='mobile-hide dropdown dropdown-level-1 last'])/a/span"));
        Assert.assertEquals(system.getText(), "System");
        System.out.println("System PASSED");


    }

}
