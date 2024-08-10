package pages.elementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    private final String LOCATOR_authPage = "//div[@id = 'authPage']";
    private final String LOCATOR_inputsPage = "//div[@id = 'inputsPage']";

    //Оперделение локатора для выпадающего списка dropdownName
    public String defineDropdownLocator(String dropdownName) {
        if (isElementDisplay(By.xpath(LOCATOR_authPage + "//label[contains(text(), '" + dropdownName + "')]/../select"))) {
            return LOCATOR_authPage + "//label[contains(text(), '" + dropdownName + "')]/../select";
        } else if(isElementDisplay(By.xpath(LOCATOR_inputsPage + "//label[contains(text(), '" + dropdownName + "')]/../select"))) {
            return LOCATOR_inputsPage + "//label[contains(text(), '" + dropdownName + "')]/../select";
        } else return null;
    }

    //Проверка отображения локатора dropdownName
    public Boolean isDisplayDropdown(String dropdownName) {
        String locator = defineDropdownLocator(dropdownName);
        if (isElementDisplay(By.xpath(locator))) {
            return true;
        }
        return false;
    }

    //Выбрать значение value из выпадающего списка dropdownName
    public void selectValueFromDropdown(String dropdownName, String value) {
        String locator = defineDropdownLocator(dropdownName);
        if (isDisplayDropdown(dropdownName)) {
            driver.findElement(By.xpath(locator)).click();
        }
        if (isElementDisplay(By.xpath(locator + "/option[contains(text(), '" + value +"')]"))){
            driver.findElement(By.xpath(locator + "/option[contains(text(), '" + value +"')]")).click();
        }
        driver.findElement(By.xpath(locator)).click();
    }

    //Получить значение из выпадающего списка dropdownName
    public String getDropdownValue(String dropdownName) {
        String locator = defineDropdownLocator(dropdownName);
        if (locator != null) {
            return driver.findElement(By.xpath(locator)).getAttribute("value");
        } else return null;
    }
}
