package core.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver driver;

    //Определение вебдрайвера
    public static WebDriver createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
