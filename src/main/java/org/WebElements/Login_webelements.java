package org.WebElements;

import org.TestBase.Testbase;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

public class Login_webelements extends Testbase {
    @FindBy(id = "nav-link-accountList")
    @CacheLookup
    WebElement sign_in;

    @FindBy(id = "ap_email")
    @CacheLookup
    WebElement email_textbox;

    @FindBy(id = "continue")
    @CacheLookup
    WebElement continue_btn;

    @FindBy(id = "ap_password")
    @CacheLookup
    WebElement password_txtBox;

    @FindBy(id = "signInSubmit")
    @CacheLookup
    WebElement sign_btn;

    public Login_webelements()
    {
        PageFactory.initElements(driver,this);
    }
    public Login_webelements click_sign_in()
    {
      WebElement sb= wait.until(new Function<WebDriver, WebElement>() {

           @Override
           public WebElement apply(WebDriver webDriver) {
              WebElement sbtn= webDriver.findElement(By.id("nav-link-accountList"));
//               if (sbtn.isEnabled()==true)
//               {
//                   System.out.println("it is enabled");
//               }
//               else if (sbtn.isEnabled()==false)
//               {
//                   System.out.println("not enabled");
//               }
               return sbtn;
           }
       });
       sb.click();
        return new Login_webelements();
    }
    public Login_webelements enter_email()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_email")));
            email_textbox.sendKeys("...");//muhammedriyas6262@gmail.com
        }
        catch (Exception e)
        {

            System.out.println(e.getMessage());

        }
        return new Login_webelements();
    }
    public Login_webelements click_continue()
    {
        continue_btn.click();
        return new Login_webelements();
    }
    public Login_webelements enter_password()
    {
      try
      {
          WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
          wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_password")));
          password_txtBox.sendKeys("Riyas@6262");

      }

      catch (Exception e)
      {
          System.out.println(e.getMessage());
          File destini=new File("C:\\Users\\Muham\\OneDrive\\Documents\\IntellijProjects\\Amazontesting\\src\\main\\java\\org\\utils\\login_errors\\login_username_error.png");
          TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
          File cpy= takesScreenshot.getScreenshotAs(OutputType.FILE);
          try
          {
              FileHandler.copy(cpy,destini);
          }
          catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
      }
        return new Login_webelements();
    }
    public void click_sign_tbn()
    {
        sign_btn.click();
    }
}
