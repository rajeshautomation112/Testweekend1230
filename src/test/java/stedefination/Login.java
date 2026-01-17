package stedefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class Login {

     WebDriver driver;
    @Given("user is at loginpage")
    public void userIsAtLoginpage() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  // Replace with actual login URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @When("Enter the username and password")
    public void enterUsernameAndPassword() {
        driver.findElement(By.name("username")).sendKeys("admin");  // Use valid test credentials
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @And("click on the login button")
    public void clickLoginButton() {
        driver.findElement(By.tagName("button")).click();
    }

      @Then("user logged to the application")
        public void user_logged_to_the_application() {

         WebElement dash=driver.findElement(By.xpath("//h6[text()='Dashboard']"));

         assertTrue(dash.isDisplayed());
          System.out.println( "logged");
      }

    @And("profile picture should display")
    public void profilePictureShouldDisplay() {
        WebElement profilePic = driver.findElement(By.cssSelector("[class=\"oxd-userdropdown-img\"]"));  // Adjust selector
        assertTrue("Profile picture not visible", profilePic.isDisplayed());
    }




    }



