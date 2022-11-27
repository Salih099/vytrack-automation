package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_2 extends TestBase {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    @Test
    public void TS62_AC1(){
        // users access the Oronic Documentation page by clicking the question icon.
        // The page URL: https://doc.oroinc.com/

        //driver.get(ConfigurationReader.getProperty("env"));
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        //wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@class='help no-hash']/i")))).click();
        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//a[@href='http://www.oroinc.com/doc']/i"));
        BrowserUtils.waitfor(2);
        questionIcon.click();
        //wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[@href='http://www.oroinc.com/doc']")))).click();

        for (String eachLinks : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(eachLinks);
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        }

        String actualTitle = Driver.getDriver().getCurrentUrl();
        String expectedTitleAfterClick = "https://doc.oroinc.com/";

        Assert.assertEquals(actualTitle,expectedTitleAfterClick);
    }

}
