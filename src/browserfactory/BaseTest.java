package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest { // class file
    public static WebDriver driver;

    public void openBrowser(String baseUrl){ // /Defined method to Open Url
        driver = new ChromeDriver(); // //Storing the Browser driver to variable
        driver.get(baseUrl); //Get Url
        driver.manage().window().maximize(); //Maximize Screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); ////implicit wait
    }
    public void closeBrowser(){
        driver.quit(); //close all browser
    }
}
