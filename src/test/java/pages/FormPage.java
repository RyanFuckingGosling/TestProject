package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage{
    public FormPage(WebDriver driver) {
        super(driver);
    }

    private final String LOCATOR_AlertsHolder = "//div[@id = 'dataAlertsHolder']";
    private final String LOCATOR_AlertCloseIcon = "//a[contains(@class, 'alert-close')]";
    private final String[] TableHeaders = {"E-Mail", "Имя", "Пол", "Выбор 1", "Выбор 2"};
    private final String LOCATOR_ModalWindow = "//div[@class = 'uk-modal-dialog']";

    //Проверка отображения заголовков таблицы
    public Boolean isDisplayTableHeaders() {
        for (int i = 0; i < TableHeaders.length; i++) {
            if (!isElementDisplay(By.xpath("//thead/tr/th[contains(text(), '" + TableHeaders[i] + "')]"))) {
                return false;
            }
        }
        return true;
    }

    //Нажать на иконку закрытия информационного сообщения
    public void clickCloseAlertIcon(){
        if (isDisplayAlertCloseIcon()){
            driver.findElement(By.xpath(LOCATOR_AlertsHolder + LOCATOR_AlertCloseIcon)).click();
        }
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Проверка отображения информационного сообщения
    public Boolean isDisplayAlertFieldWithText(String errorText) {
        return isElementDisplay(By.xpath(LOCATOR_AlertsHolder + "//*[contains(text(), '" + errorText + "')]"));
    }

    //Проверка отображения иконки закрытия информационного сообщения
    public Boolean isDisplayAlertCloseIcon() {
        return isElementDisplay(By.xpath(LOCATOR_AlertsHolder + LOCATOR_AlertCloseIcon));
    }

    //Проверка отображения модального окна
    public Boolean isDisplayModalWindow() {
        return isElementDisplay(By.xpath(LOCATOR_ModalWindow));
    }

    //Получить текст из модального окна
    public String getTextFromModalWindow() {
        if (isElementDisplay(By.xpath(LOCATOR_ModalWindow))) {
            return driver.findElement(By.xpath(LOCATOR_ModalWindow + "//div[contains(@class, 'content')]")).getText();
        }
        return null;
    }

    //Проверка отображения кнопки buttonName в модальном окне
    public Boolean isDisplayButtonInModalWindow(String buttonName) {
        return isElementDisplay(By.xpath(LOCATOR_ModalWindow + "//button[contains(text(), '" + buttonName + "')]"));
    }

    //Проверка отображения значений в последней строке таблицы
    public Boolean isDisplayRowInTable(String[] data) {
        if (isElementDisplay(By.xpath("//tbody/tr[last()]"))) {
            for (int i = 1; i < 5; i++) {
                if (!isElementDisplay(By.xpath("//tbody/tr[last()]/td[" + i + "][contains(text(), '" + data[i - 1] + "')]"))) {
                    return false;
                }
            }
        }
        return true;
    }
}
