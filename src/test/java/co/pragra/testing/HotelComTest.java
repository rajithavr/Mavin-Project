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
import java.util.concurrent.TimeUnit;

public class HotelComTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/work/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    @Parameters("site_url")

    public void testcase1(String url) throws InterruptedException {
        driver.get(url);

        WebElement searchInput=driver.findElement(By.xpath("//input[@id='qf-0q-destination']"));
            //waits
        //implicit wait(applies on driver),,fluent wait
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //it ll keep putting wait for everyelement but better than thread.sleep

        //explicit wait
        WebDriverWait driverWait =new WebDriverWait(driver,10);

        //driver.findElement(By.id("qf-0q-destination"));
        //searchInput.sendKeys("Austin", Keys.SPACE,"Texas");
        //searchInput.sendKeys(Keys.ESCAPE);
        //searchInput.clear();// its clears wht is written..

        searchInput.sendKeys("regina");
        WebElement choice =  driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#citysqm-asi0-s2>td>div:nth-child(2)")));
        //WebElement choice =driver.findElement(By.cssSelector("#citysqm-asi0-s2>td>div:nth-child(2)"));
        choice.click();

        WebElement link= driver.findElement(By.id("hdr-gift-card"));
        //link.click(); //it clicks the link
        //link. submit(); //nothing happens submit can be given in a form or whenver we try to submit the form
       // driver.findElement(By.xpath("//form[@class='cont-bd']")).submit();  //form tries to submit the page.

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
