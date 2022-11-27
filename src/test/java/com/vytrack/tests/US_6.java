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
import org.testng.annotations.Test;

import java.util.List;

public class US_6 extends TestBase {

    WebDriverWait wait;
    VyTrack_LogIn_POM vyTrackLogInPom;
    LoginPage loginPage = new LoginPage();


    @Test
    public void TS66_AC1() {
        //AC #1: users should see “view, edit, delete” when they hover the mouse to the three dots “...”.

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));


//        BrowserUtils.waitfor(2);
//        wait.until(ExpectedConditions.visibilityOf(vyTrackLogInPom.clickFleetModule)).click();

        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]"));
        BrowserUtils.waitfor(3);
        fleetClick.click();


        BrowserUtils.waitfor(4);
        WebElement clickVehicles = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"));
        clickVehicles.click();

        BrowserUtils.waitfor(4);

        String expected3Dot = "...";
        List<WebElement> _3dot = Driver.getDriver().findElements(By.xpath("//td[@data-column-label='test']/div/div/a[.='...']"));

        //BrowserUtils.sleep(4);

        int count = 1;
        for (WebElement each3Dots : _3dot) {
            if (each3Dots.getText().contains(expected3Dot)) {
                System.out.print(count++ + " ");
            }
        }

        // ==================================================================
//        WebElement threeDotButton = Driver.getDriver().findElement(By.xpath("//td[@data-column-label='test']/div/div/a"));
//
//        new Actions(driver).moveToElement(threeDotButton).perform();
//
//        WebElement verifyThreeOptions = Driver.getDriver().findElement(By.xpath("(//div[@class='more-bar-holder']/div)[1]"));
//        verifyThreeOptions.isDisplayed();
//
//        Assert.assertTrue(verifyThreeOptions.isDisplayed(), "Displaying hover over three buttons FAILED!");
//        System.out.println("Displaying hover over three buttons - " + verifyThreeOptions.isDisplayed());
        // ==================================================================

    }

}
