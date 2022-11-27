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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_8 extends TestBase {
    WebDriverWait wait;
    VyTrack_LogIn_POM vyTrackLogInPom;
    LoginPage loginPage = new LoginPage();


//    @Test
    public void TS68_AC1(){
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        WebElement activitiesModules= Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"));
        BrowserUtils.waitfor(4);
        activitiesModules.click();

        BrowserUtils.waitfor(2);

        WebElement calendarEvent= Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item last']/a[@href='/calendar/event']"));
        BrowserUtils.waitfor(4);
        calendarEvent.click();

        WebElement createCalenderEvent = Driver.getDriver().findElement(By.xpath("//div[@class='btn-group']/a[@href='/calendar/event/create']"));
        BrowserUtils.waitfor(2);
        createCalenderEvent.click();

        WebElement clickRepeat = Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.waitfor(3); //input[@id='recurrence-repeat-view1005'] //input[@data-name='recurrence-repeat'] (//input[@type='checkbox'])[2]
        clickRepeat.click();

        WebElement defaultNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        System.out.println("defaultNumber.getAttribute(\"value\") = " + defaultNumber.getAttribute("value"));
        Assert.assertEquals(defaultNumber.getAttribute("value"), "1");


    }

    @Test
    public void TS68_AC2(){

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        WebElement activitiesModules= Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"));
        BrowserUtils.waitfor(4);
        activitiesModules.click();

        BrowserUtils.waitfor(2);

        WebElement calendarEvent= Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item last']/a[@href='/calendar/event']"));
        BrowserUtils.waitfor(4);
        calendarEvent.click();

        WebElement createCalenderEvent = Driver.getDriver().findElement(By.xpath("//div[@class='btn-group']/a[@href='/calendar/event/create']"));
        BrowserUtils.waitfor(2);
        createCalenderEvent.click();

        WebElement clickRepeat = Driver.getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.waitfor(3); //input[@id='recurrence-repeat-view1005'] //input[@data-name='recurrence-repeat'] (//input[@type='checkbox'])[2]
        clickRepeat.click();

        WebElement defaultNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        System.out.println("defaultNumber.getAttribute(\"value\") = " + defaultNumber.getAttribute("value"));
        Assert.assertTrue(defaultNumber.getAttribute("value").isBlank());


    }
}
