package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
    }

    @AfterMethod
    public void tearDown() {
//        BrowserUtils.sleep(1);
        Driver.closeDriver();
    }
}
