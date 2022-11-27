package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack_LogIn {

    //Method #1 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver driver
    public static void login_Crm_Store(WebDriver driver){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("storeManager1"));

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();
    }

    public static void login_crm_Sales(WebDriver driver){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("salesManager1"));

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();
    }

    public static void login_crm_Driver(WebDriver driver){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("driver1"));

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();
    }



    //Method #2 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String username
    //• Arg3: String password
    public static void login_crm(WebDriver driver,String username,String password){
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();
    }
}
