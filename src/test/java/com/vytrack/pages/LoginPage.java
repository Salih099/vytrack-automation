package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    /*
        Default
    public loginPage(){
      super();
    }
    */

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginButton;

    public void login(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}
