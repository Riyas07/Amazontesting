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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Search_webelements extends Testbase {
    @FindBy(id = "twotabsearchtextbox")
    @CacheLookup
    WebElement search_box;

    @FindBy(id = "nav-search-submit-button")
    @CacheLookup
    WebElement search_btn;

    public Search_webelements(){
        PageFactory.initElements(driver,this);
    }
    public Search_webelements enter_products() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Muham\\OneDrive\\Documents\\IntellijProjects\\Amazontesting\\src\\main\\resources\\Test_data.xlsx");
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
     XSSFSheet xssfSheet= xssfWorkbook.getSheetAt(0);
//    int total_row= xssfSheet.getLastRowNum();
//   int column= xssfSheet.getRow(0).getLastCellNum();
  WebElement serch_b= wait.until(new Function<WebDriver, WebElement>() {

      @Override
      public WebElement apply(WebDriver webDriver) {
       WebElement txtbox=   webDriver.findElement(By.id("twotabsearchtextbox"));
          return txtbox;
      }
  });
        serch_b.sendKeys(xssfSheet.getRow(0).getCell(0).toString());
        return  new Search_webelements();
    }
    public  void clilck_search_btn()
    {

        search_btn.click();
    }
}
