package com.cybertek.tests;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class ChromeBrowserTest {

    private final static Logger logger = Logger.getLogger(ChromeBrowserTest.class);

    @Test
    public void test() throws Exception {
        /*
        If error for chromedriver, we need to change it:
        WebDriverManager.chromedriver().browserVersion("2.23").setup(); <---probably don't need this line
        desiredCapabilities.setCapability("chromeDriverExecutable", WebDriverManager.chromedriver().browserVersion("2.23").getDownloadedDriverPath());
        //this line will set chrome driver of specific version
         */

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.get("http://google.com");
        logger.info(driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }

}
