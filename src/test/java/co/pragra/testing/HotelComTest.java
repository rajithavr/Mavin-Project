package co.pragra.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class HotelComTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/work/chromedriver.exe");
    }
    @Test
    @Parameters("site_url")
    public void testOpenBrowser() throws InterruptedException {
        driver = new ChromeDriver();
       // driver.get("https://pragra.co/sel.html");

       // WebDriverWait driverWait =new WebDriverWait(driver,200,500);
//
       /// WebElement button =driver.findElement(By.id("dblclik"));
      //  button.click();
      //  driverWait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='msg']"),"Just Double Clicked"));


        WebElement searchInput=driver.findElement(By.xpath("//input[@id='qf-0q-destination']")); //driver.findElement(By.id("qf-0q-destination"));
        searchInput.sendKeys("Austin");

       // WebElement choice =driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#citysqm-asi0-s2>td>div:nth"))


        WebElement link= driver.findElement(By.id("hdr-gift-card"));
        link.click(); //it clicks the link
        link. submit(); //nothing happens submit can be given in a form or whenver we try to submit the form
        driver.findElement(By.xpath("//form[@class='cont-bd']")).submit();  //form tries to submit the page.

        //searchInput.sendKeys("Austin", Keys.SPACE,"Texas");
       // searchInput.sendKeys(Keys.ESCAPE);
        //Thread.sleep(2000);
        //searchInput.clear();// its clears wht is written..
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
