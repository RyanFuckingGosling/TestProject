package pages.elementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CheckboxPage extends BasePage {

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    private final String LOCATOR_Checkbox = "//input[@type = 'checkbox']";


    //Нажать на чекбокс checkboxName
    public void clickCheckbox(String checkboxName) {
        driver.findElement(By.xpath(LOCATOR_Checkbox + "[@id = 'dataCheck" + defineCheckboxNumber(checkboxName) + "']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Определение локатора для чекбокса checkboxName
    public static String defineCheckboxNumber(String checkboxName) {
        return checkboxName.replace("Вариант ", "").replace(".", "");
    }

    //Проверка активности чекбокса checkboxName
    public Boolean isCheckboxChecked(String checkboxName) {
        String locator = LOCATOR_Checkbox + "[@id = 'dataCheck" + defineCheckboxNumber(checkboxName) + "']";
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    //Проверка отображения чекбокса checkboxName
    public Boolean isDisplayCheckbox(String checkboxName) {
        String locator = LOCATOR_Checkbox + "[@id = 'dataCheck" + defineCheckboxNumber(checkboxName) + "']";
        return isElementDisplay(By.xpath(locator));
    }
}
