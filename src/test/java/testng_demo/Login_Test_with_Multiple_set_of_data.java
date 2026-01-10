package testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Login_Test_with_Multiple_set_of_data {

    WebDriver driver;

    @BeforeMethod(groups="smoke")
    @Parameters({"browser","url"})
    public void setup(String browser,String url) {


        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        else if(browser.equalsIgnoreCase("edge")){

            driver=new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @Test(dataProvider = "logindata",dataProviderClass = Excel_Reader.class, groups="smoke",priority=1)
    public void Enter_Credentials(String username,String password) throws InterruptedException {

        WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
        user.clear();
        user.sendKeys(username);


        WebElement pass=driver.findElement(By.cssSelector("input[name='password']"));
        pass.clear();

        pass .sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();

        WebElement pro=driver.findElement(By.xpath("//img[@alt=\"profile picture\"]"));

        Assert.assertTrue(pro.isDisplayed(),"login successful");

    }



    @DataProvider(name = "logindata")
    public Object[][] getDAta(){

        return new Object[][]{

                {"Admin","admin123"},
                { "Admin","jack123"},
                {"robinhood","admin123"},
                {"jack","sparrow"}
        };
    }

    @AfterMethod(groups="Functional")
    public void Browser_Close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
