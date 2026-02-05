package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Xpath_CSS {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.xpath("//button[@type='submit' and @title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-firstname")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-lastname")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email_address")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-password")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-confirmation")).getText(), "This is a required field.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.id("firstname")).sendKeys("Kien");
        driver.findElement(By.id("middlename")).sendKeys(" ");
        driver.findElement(By.id("lastname")).sendKeys("Tran");
        driver.findElement(By.id("email_address")).sendKeys("abc@dsadsadsa");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");


        driver.findElement(By.xpath("//button[@type='submit' and @title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email_address")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void Register_03_Invalid_Password() {

        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.id("firstname")).sendKeys("Kien");
        driver.findElement(By.id("middlename")).sendKeys(" ");
        driver.findElement(By.id("lastname")).sendKeys("Tran");
        driver.findElement(By.id("email_address")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("password")).sendKeys("      #@!321321321         ");
        driver.findElement(By.id("confirmation")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@type='submit' and @title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-password")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.id("firstname")).sendKeys("Kien");
        driver.findElement(By.id("middlename")).sendKeys(" ");
        driver.findElement(By.id("lastname")).sendKeys("Tran");
        driver.findElement(By.id("email_address")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("654321");

        driver.findElement(By.xpath("//button[@type='submit' and @title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-cpassword-confirmation")).getText(), "Please make sure your passwords match.");
    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
