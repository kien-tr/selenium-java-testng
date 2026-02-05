package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    public void initialBroswer() {
        // Mở broswer
        driver = new FirefoxDriver();

        //Truy cập vào trang web, đến màn hình login
        driver.get("https://demo.nopcommerce.com/register");
    }


    //Thẻ (tagname) - Thuộc tính (attribute) - giá trị thuộc tính (value)
    //Cú pháp Xpath: //tagname[@attribute='value']
    //Cú pháp Css: tagname[attribute='value']
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("register-next-step-button"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("textbox"));

    }

    @Test
    public void TC_04_LinkText() {
        //Chỉ làm việc với element là link và có text
        //Thẻ a có thuộc tính href
        //Phải lấy hết toàn bộ text
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));

    }

    @Test
    public void TC_05_Partial_Link_Text() {
        //Chỉ làm việc với element là link
        //Có thể lấy toàn bộ text hoặc 1 phần
        driver.findElement(By.partialLinkText("Conditions"));

    }

    @Test
    public void TC_06_Tagname() {
        //Tên thẻ HTML
        //Khi muốn tìm tất cả element giống nhau (thẻ của component giống nhau)
        //Tất cả textbox/ button/ checkbox/ link/ radio/...
        driver.findElement(By.tagName("Button"));
        driver.findElement(By.tagName("Input"));
        driver.findElement(By.tagName("Label"));
    }

    @Test
    public void TC_07_CSS() {
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));
        driver.findElement(By.className(""));
    }

    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.tagName(""));
    }

    @Test
    public void TC_09_Relative_Locator() {
        driver.get("https://demo.nopcommerce.com/login");
        //Element A
        By passwordTextboxBy = By.cssSelector("input#Password");

        //Element B
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Element C
        By forgotPasswordLinkBy = By.cssSelector("span.forgot-password");

        //Element D
        By loginButtonBy = By.cssSelector("button.login-button");

        //Element E
        WebElement rememberMeText = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy) //label đang nằm trên cái login button
                .below(passwordTextboxBy) //label đang nằm dưới cái textbox password
                .toRightOf(rememberMeCheckboxBy) //label đang nằm bên phải cái check box remember me
                .toLeftOf(forgotPasswordLinkBy) //label đang nằm bên trái cái link text forgot pssword
        );
    }


    @AfterClass
    public void cleanBroswer(){
        driver.quit();
    }
}
