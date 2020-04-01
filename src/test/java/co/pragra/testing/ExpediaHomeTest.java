package co.pragra.testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class ExpediaHomeTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
       System.setProperty("webdriver.chrome.driver","/work/chromedriver.exe");
    }
    @Test
    @Parameters("site_url")
     public void testOpenBrowser(String url) throws InterruptedException {
       driver =new ChromeDriver();
       driver.get(url);
       //driver.get("https://www.expedia.ca/");
       System.out.println(driver.getCurrentUrl());
       System.out.println(driver.getTitle());
       Assert.assertTrue(driver.getTitle().contains("Cheap Flights"));

        Actions action =new Actions(driver);
        action.keyDown(Keys.COMMAND).click(driver.findElement(By.id("itinerary"))).build().perform();
        action.keyDown(Keys.COMMAND).click(driver.findElement(By.xpath("//*[@id='secondaryNav']/div[1]/a"))).build().perform();
        Thread.sleep(2000);
        //driver.close();

        String current =driver.getWindowHandle(); //gets the current window id.
        System.out.println("current window :"+current);
        Set<String> windows =driver.getWindowHandles(); ///returns the set of window ids that are open (open tab id's)
        System.out.println("new window" +windows);
        //to move to other window use for loop
        for(String window : windows) {
           if (!window.equals(current)) {
               driver.switchTo().window(window);
               break;
           }
        }
        //driver.switchTo(). - used when we have to switch between multiple windows.
        driver.navigate().refresh();
        //driver.navigate().to("https://www.zoom.com");
        Thread.sleep(3000);
       // driver.navigate().back();
        Thread.sleep(3000);
       // driver.navigate().forward();
        WebDriver.Window window = driver.manage().window();
       window.fullscreen();
        Point position = window.getPosition();
        System.out.println(position.x);
        System.out.println(position.y);
       // window.setPosition(new Point(500,500));
        Dimension size= window.getSize();
        System.out.println(size.height);
        System.out.println(size.width);
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }

}
