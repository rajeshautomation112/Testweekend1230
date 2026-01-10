package testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_with_excel_data {


    WebDriver driver;

    @BeforeClass
    @Parameters("url")
    public void browser_setup(String url) {


        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(dataProvider="exceldata",dataProviderClass = Excel_Reader.class, priority = 1)

    public void Enter_login_credentials(String username,String password) throws InterruptedException {

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.xpath("//img[@class=\"oxd-userdropdown-img\"]")).click();

        WebDriverWait waitDriver=new WebDriverWait(driver, Duration.ofSeconds(5));

        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Logout']"))).click();
    }
}

