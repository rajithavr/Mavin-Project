package co.pragra.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class PragraTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/work/chromedriver.exe");
    }
    @Test
    @Parameters("site_url")
    public void openBrowser(String url){
        driver = new ChromeDriver();
        driver.get(url);
        WebDriverWait driverwait = new WebDriverWait(driver,200);
        WebElement button =driver.findElement(By.id("dblclik"));
        button.click();
        //driverwait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='msg']"),"Just Double Clicked"));
        driverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='msg']")));
        System.out.println(driver.findElement(By.xpath("//span[@id='msg']")));
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='a_working_locator']"))).click();
    }
//    @Test
//    public void testCase1()
//    {
//        WebDriverWait driverwait = new WebDriverWait(driver,200,500);
//        WebElement button =driver.findElement(By.id("dblclik"));
//        button.click();
//        driverwait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='msg']"),"Just Double Clicked"));
//    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }
}
