package com.vytrack.tests;


import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_3 extends TestBase {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

    @Test
    public void TS63_AC1(){
        //AC1: when users click click the “Learn how to use this space” link on the homepage,
        //users should see: Expected:
        //"How To Use Pinbar"
        //"Use pin icon on the right top corner of the page to create fast access link in the pinbar."

        //Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

//        WebElement learnToUse = Driver.getDriver().findElement(By.xpath("//div[.='Learn how to use this space']/a"));
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[.='Learn how to use this space']/a")))).click();
//        learnToUse.click();

        WebElement usePinbar = Driver.getDriver().findElement(By.xpath("//div[@class='clearfix']/h3"));
        String actualUsePinbar = usePinbar.getText();
        String expectedUserPinbar = "How To Use Pinbar";
        Assert.assertEquals(actualUsePinbar, expectedUserPinbar);
        System.out.println("PASSED the First One");

        WebElement useIcon = Driver.getDriver().findElement(By.xpath("//div[@class='clearfix']/p[1]"));
        String actualUseIcon = useIcon.getText();
        String expectedUserIcon = "Use pin icon on the right top corner of " +/*the*/ "page to create fast access link in the pinbar."; // that *note* is an extra word
        Assert.assertEquals(actualUseIcon, expectedUserIcon);
        System.out.println("PASSED the Second One");

    }

    //@Test
    public void TS63_AC2(){
        //driver.get(ConfigurationReader.getProperty("env"));

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty( "sales_manager_password"));

        WebElement learnToUse = Driver.getDriver().findElement(By.xpath("//div[.='Learn how to use this space']/a"));
        wait.until(ExpectedConditions.visibilityOf(learnToUse)).click();
        //learnToUse.click();

        WebElement source = Driver.getDriver().findElement(By.xpath("(//div[@class='clearfix'])[2]/p[2]/img"));
        System.out.println("image.getAttribute(\"src\") = " + source.getAttribute("src"));
        String actualSource = source.getAttribute("src");

        Assert.assertTrue(actualSource.contains("/bundles/oronavigation/images/pinbar-location.jpg"));
        System.out.println("PASSED");

    }
}
