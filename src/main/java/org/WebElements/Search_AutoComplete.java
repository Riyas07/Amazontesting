package org.WebElements;

import org.TestBase.Testbase;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.webPages.Search_auto_omplete;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Search_AutoComplete extends Testbase {
    @FindBy(id = "twotabsearchtextbox")
    @CacheLookup
    WebElement search_txt_box;
    public Search_AutoComplete ()
    {
        PageFactory.initElements(driver,this);
    }

    public void enter_products()
    {
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Muham\\OneDrive\\Documents\\IntellijProjects\\Amazontesting\\src\\main\\resources\\Test_data.xlsx");
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet= xssfWorkbook.getSheetAt(0);
            String value=   xssfSheet.getRow(1).getCell(0).toString();
            WebElement search_box=  wait.until(new Function<WebDriver,WebElement>()
            {

                @Override
                public WebElement apply(WebDriver webDriver) {
                    WebElement  s_box=   webDriver.findElement(By.id("twotabsearchtextbox"));
                    return s_box;
                }
            });
            search_box.clear();
            search_box.sendKeys(value);
            WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(30));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-heavy")));
          List<WebElement> auto_list=  driver.findElements(By.className("s-heavy"));

          auto_list.get(0).click();
        }
        catch (Exception io)
        {
            System.out.println(io.getMessage());
        }
    }

}
