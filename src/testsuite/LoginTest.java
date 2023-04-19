package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = ("https://courses.ultimateqa.com/");

    @Test
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Adding implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Finding element and storing to variable for username
        WebElement loginLink1 = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        loginLink1.click();

        //verify the error message

        WebElement emailField = driver.findElement(By.name("user[email]"));
        //Sending text to email field
        emailField.sendKeys("xyz123@gmail.com");
        WebElement password = driver.findElement(By.id("user[password]"));
        //Sending text to password field
        password.sendKeys("xyz123");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid email address", expectedMessage, actualMessage);
    }



}
