package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BasePage {

    private final String LOCATOR_AlertsHolder = "//div[@id = 'authAlertsHolder']";
    private final String LOCATOR_AlertCloseIcon = "//a[contains(@class, 'alert-close')]";

    public AuthPage(WebDriver driver) {
        super(driver);
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

    //Провкерка отображения информационного сообщения
    public Boolean isDisplayAlertFieldWithText(String errorText) {
        return isElementDisplay(By.xpath(LOCATOR_AlertsHolder + "//*[contains(text(), '" + errorText + "')]"));
    }

    //Проверка отображения иконки закрытия в информационном сообщении
    public Boolean isDisplayAlertCloseIcon() {
        return isElementDisplay(By.xpath(LOCATOR_AlertsHolder + LOCATOR_AlertCloseIcon));
    }

}
