package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Xpath_CSS {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Test_Click() {
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
