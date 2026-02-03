package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {

    //1 - Setup: OS/ Broswer/ Web/ Page/ Data/ Variable/ Object/...

    WebDriver driver;

    @BeforeClass
    public void initialBroswer() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com");
    }


    //2 - Action/ Execute: Tương tác lên Element nào/ nhập liệu/ verify/.....

    @Test
    public void TC_01_() {

    }

    @Test
    public void TC_02_() {

    }

    //3 - Clean: Delete data test/ account/ close broswer/.....

    @AfterClass
    public void cleanBroswer(){
        driver.quit();
    }
}
