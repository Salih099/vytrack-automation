package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath =" //div[@class='loader-mask']" )
    public WebElement loaderMask;

    public void waitUntilLoaderMaskInvisiibility(){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


}
