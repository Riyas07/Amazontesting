package org.TestBase;

import org.WebElements.Search_AutoComplete;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class sam {
    public static WebDriver driver;
    public  static Wait<WebDriver> wait;

    public sam enter_products()
    {
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Muham\\Documents\\IntellijProjects\\Amazontesting\\src\\main\\resources\\Test_data.xlsx");
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
            search_box.sendKeys(value);
            WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.className("s-heavy")));
          List<WebElement> list=  driver.findElements(By.xpath("//span[@class=\"s-heavy\"]"));
            System.out.println(list.get(0).getText());
        }
        catch (Exception io)
        {
            System.out.println(io.getMessage());
        }
        return new sam();
    }
    public void search_btn()
    {
        driver.findElement(By.id("nav-search-submit-button")).
                click();
    }
    public static void main(String[] args) {
        driver=new ChromeDriver();

        wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NullPointerException.class);
        driver.navigate().to("https://www.amazon.in/");
        new sam().enter_products().search_btn();
    }
}
