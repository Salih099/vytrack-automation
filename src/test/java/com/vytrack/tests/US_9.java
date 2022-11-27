package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_9 extends TestBase{

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);


    @Test
    public void TS2_69_AC1(){
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
        defaultNumber.click();

        defaultNumber.sendKeys(Keys.BACK_SPACE, "-5", Keys.ENTER);
        BrowserUtils.waitFor(2);
        WebElement errorMessageMoreOrLess = Driver.getDriver().findElement(By.xpath("//span[@id='temp-validation-name-125-error']//span[text()='The value have not to be less than 1.']"));

        String notLessThen1Message = "The value have not to be less than 1.";
        Assert.assertEquals(errorMessageMoreOrLess.getText(), notLessThen1Message);

        Driver.getDriver().navigate().refresh();
        errorMessageMoreOrLess = Driver.getDriver().findElement(By.xpath("//span[@id='temp-validation-name-125-error']/span/span"));

        defaultNumber.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE, "154");
        BrowserUtils.waitFor(2);

        String notMoreThen99Message = "The value have not to be more than 99.";
        Assert.assertEquals(errorMessageMoreOrLess.getText(), notMoreThen99Message);

    }
}
