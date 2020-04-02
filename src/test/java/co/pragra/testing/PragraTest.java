package co.pragra.testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class PragraTest {

    WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/work/geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
            driver = new ChromeDriver();
        }
   }
    @Ignore
    @Parameters("site_url")
    public void testcase1(String url) {
        driver.get(url);

        WebElement alertbtn = driver.findElement(By.xpath("//button[text()='Generate Alerts']"));
        alertbtn.click();
        WebDriverWait driverWait = new WebDriverWait(driver, 20);
        Alert alert = driverWait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert);
        alert.dismiss();
    }

    @Ignore
    @Test()
    public void actionTest(){
        driver.get("https://www.cn.ca/en/");
        WebElement custCenter= driver.findElement(By.id("ctl06__134faf5d27b3d8_repMainNav_topLevelLink_2"));
        WebElement stayInformed=driver.findElement(By.id("ctl06__134faf5d27b3d8_repMainNav_repSecondLevel_2_secondLevelLink_4"));
        WebElement custNews=driver.findElement(By.id("ctl06__134faf5d27b3d8_repMainNav_repSecondLevel_2_repThirdLevel_4_thirdLevelLink_0"));

        Actions actions =new Actions(driver);
        actions.moveToElement(custCenter).pause(2000)
                .moveToElement(stayInformed).pause(2000)
                .moveToElement(custNews).pause(2000)
                .build().perform();
    }

    @Test(enabled = false)
    public void cmdKey(){

        driver.get("https://zoom.us/");
        WebElement joinMeeting =driver.findElement((By.id("btnJoinMeeting")));
        Actions action=new Actions(driver);
        action.keyDown(Keys.COMMAND).click(joinMeeting)
                .build().perform();
    }

    @Test
    public void actionWait(){
        driver.get("https://pragra.co/sel.html");
        WebElement button =driver.findElement(By.id("dblclik"));
        Actions action=new Actions(driver);
        action.doubleClick(button).build().perform();
        WebDriverWait driverWait = new WebDriverWait(driver,20);
        Alert alert =  driverWait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        driverWait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='msg']"),"Just Double Clicked"));

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }
}
