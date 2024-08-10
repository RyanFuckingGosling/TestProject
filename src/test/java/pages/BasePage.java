package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    private static final String PATH = ".../TestProject/html/qa-test.html";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажать кнопку buttonName
    public void clickButton(String buttonName){
        if (isDisplayButtonByText(buttonName)) {
            driver.findElement(By.xpath("//button[contains(text(), '" + buttonName + "')]")).click();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Проверка отображения кнопки buttonName
    public Boolean isDisplayButtonByText(String buttonName) {
        return isElementDisplay(By.xpath("//button[contains(text(), '" + buttonName + "')]"));
    }

    //Проверка отображения элемента
    public boolean isElementDisplay(final By by) {
        boolean res = true;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L));
        driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    boolean result = false;

                    try {
                        result = d.findElement(by).isDisplayed();
                    } catch (Exception var4) {
                        result = false;
                    }
                    return result;
                }
            });
        } catch (Exception var7) {
            res = false;
        }
        return res;
    }

    //Открытие страницы
    public void openHost(){
        driver.get(PATH);
    }
}
