package pages.elementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class RadiobuttonPage extends BasePage {
    public RadiobuttonPage(WebDriver driver) {
        super(driver);
    }

    private final String LOCATOR_Radiobutton = "//input[@type = 'radio']";

    //Нажать на радиобаттон radiobuttonName
    public void clickRadiobutton(String radiobuttonName) {
        driver.findElement(By.xpath(LOCATOR_Radiobutton + "[@id = 'dataSelect" + defineRadiobuttonNumber(radiobuttonName) + "']")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Определение локатора для радиобаттона radiobuttonName
    public static String defineRadiobuttonNumber(String radiobuttonName) {
        return radiobuttonName.replace("Вариант ", "").replace(".", "");
    }

    //Проверка активности радиобаттона radiobuttonName
    public Boolean isRadiobuttonChecked(String radiobuttonName) {
        String locator = LOCATOR_Radiobutton + "[@id = 'dataSelect" + defineRadiobuttonNumber(radiobuttonName) + "']";
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    //Проверка отображения радиобаттона radiobuttonName
    public Boolean isRadiobuttonDisplay(String radiobuttonName) {
        String locator = LOCATOR_Radiobutton + "[@id = 'dataSelect" + defineRadiobuttonNumber(radiobuttonName) + "']";
        return isElementDisplay(By.xpath(locator));
    }
}
