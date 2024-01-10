package org.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.WebElements.Login_webelements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.webPages.Login_page;

import java.time.Duration;
import java.util.function.Function;

public class Testbase {

 public static WebDriver driver;
 public  static  Wait<WebDriver> wait;
 public static Login_webelements login_webelements=new Login_webelements();
    @BeforeClass
    public void amazon_log_page()
    {
//        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
//        desiredCapabilities.acceptInsecureCerts();
//        desiredCapabilities.setBrowserName("chrome");
//        desiredCapabilities.setPlatform(Platform.WIN11);
//        desiredCapabilities.setCapability(CapabilityType.BROWSER_VERSION," 114.0.5735.201");
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("start-maximized");
       chromeOptions.addArguments("--disable-notifications");
       chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
       //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        //WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver(chromeOptions);

         wait=new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(30))
                 .pollingEvery(Duration.ofSeconds(5))
                 .ignoring(NullPointerException.class);
        driver.navigate().to("https://www.amazon.in/");
        WebDriverWait driverWait=new WebDriverWait(driver,Duration.ofSeconds(2));

    }

}
