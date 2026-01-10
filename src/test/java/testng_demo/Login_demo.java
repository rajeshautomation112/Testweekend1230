package testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_demo {

    WebDriver driver;
      @Test(groups = "smoke", priority = 0)
      @Parameters({"browser","url"})
      public void browser_setup(String browser,String url) throws InterruptedException {

          if (browser.equalsIgnoreCase("chrome")) {
              driver = new ChromeDriver();
              driver.manage().window().maximize();
              driver.get(url);

              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
              // Thread.sleep(4);
          } else if (browser.equalsIgnoreCase("edge")) {
              driver = new EdgeDriver();
              driver.manage().window().maximize();
              driver.get(url);

              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          }
      }
    @Test(groups = "smoke", priority = 1)
    public void enter_login_credentials(){

           driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
           driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");

    }

    @Test(groups="functional",priority = 2)
    public void click_on_login_button(){

      driver.findElement(By.tagName("button")).click();
    }


    @Test(groups="functional",priority = 3)
    public void close_the_browser(){
         driver.quit();

    }
}
