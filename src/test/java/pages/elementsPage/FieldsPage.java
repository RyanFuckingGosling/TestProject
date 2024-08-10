package pages.elementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class FieldsPage extends BasePage {
    public FieldsPage(WebDriver driver) {
        super(driver);
    }

    private final String LOCATOR_authPage = "//div[@id = 'authPage']";
    private final String LOCATOR_inputsPage = "//div[@id = 'inputsPage']";


    //Очистить поле ввода inputName
    public void clearInputField(String inputName) {
        String locator = defineFieldLocator(inputName);
        if (locator != null) {
            driver.findElement(By.xpath(locator)).clear();
        }
    }

    //Опеределение локатора для поля ввода inputName
    public String defineFieldLocator(String inputName) {
        if (isElementDisplay(By.xpath(LOCATOR_authPage + "//label[contains(text(), '" + inputName + "')]/../input"))) {
            return LOCATOR_authPage + "//label[contains(text(), '" + inputName + "')]/../input";
        } else if(isElementDisplay(By.xpath(LOCATOR_inputsPage + "//label[contains(text(), '" + inputName + "')]/../input"))) {
            return LOCATOR_inputsPage + "//label[contains(text(), '" + inputName + "')]/../input";
        } else return null;
    }

    //Получить значение из поля ввода inputName
    public String getTextFromInput(String inputName) {
        String locator = defineFieldLocator(inputName);
        if (locator != null) {
            return driver.findElement(By.xpath(locator)).getAttribute("value");
        } else return null;
    }

    //Проверка отображения поля ввода inputName
    public Boolean isInputFieldDisplay(String inputName) {
        String locator = defineFieldLocator(inputName);
        if (locator != null) {
            return isElementDisplay(By.xpath(locator));
        } else return null;
    }


    //Ввести значение value в поле ввода inputName
    public void setValueInInputField(String inputName, String value) {
        String locator = defineFieldLocator(inputName);
        if (locator != null) {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }
    }
}
