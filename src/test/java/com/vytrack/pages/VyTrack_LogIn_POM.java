package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrack_LogIn_POM {

    public VyTrack_LogIn_POM(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement inputUser;

    @FindBy(id="prependedInput2")
    public WebElement inputPassword;

    @FindBy(id="_submit")
    public WebElement signInButton;

    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement fieldRequiredErrorMsg;

    @FindBy(xpath = "//title")
    public WebElement isTitle;

    @FindBy (xpath = "(//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'])[1]/a")
    public WebElement clickFleetModule;

    @FindBy (xpath = "//div[@id='main-menu']//li[@class='dropdown dropdown-level-1'][1]")
    public WebElement fleetClickDriver;

    @FindBy(xpath = "//li[@class='dropdown-menu-single-item']//a[.='Vehicle Contracts']")
    public WebElement vehicleContract;

    @FindBy(xpath = "(//div[@class='alert alert-error fade in top-messages '])[2]//div")
    public WebElement AlertMessage;

    @FindBy(xpath = "(//li[@class='dropdown-menu-single-item first'])[2]/a/span")
    public WebElement vehicles;


}
