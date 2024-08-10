package tests;

import core.base.Browser;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.FormPage;
import pages.elementsPage.CheckboxPage;
import pages.elementsPage.DropdownPage;
import pages.elementsPage.FieldsPage;
import pages.elementsPage.RadiobuttonPage;

public class test_1 {

    public AuthPage authPage;
    public Browser browser;
    public CheckboxPage checkboxPage;
    public DropdownPage dropdownPage;
    public FieldsPage fieldsPage;
    public FormPage formPage;
    public RadiobuttonPage radiobuttonPage;
    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = browser.createDriver();
        authPage = new AuthPage(driver);
        checkboxPage = new CheckboxPage(driver);
        dropdownPage = new DropdownPage(driver);
        fieldsPage = new FieldsPage(driver);
        formPage = new FormPage(driver);
        radiobuttonPage = new RadiobuttonPage(driver);
    }

    @Test(description = "step_1")
    @Description("<pre>Действие:" + "\r\n"
            + "Открыть страницу" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается поле ввода 'E-Mail'" + "\r\n"
            + "Отображается поле ввода 'Пароль:'" + "\r\n"
            + "Отображается кнопка 'Вход'")
    public void step_1() {
        authPage.openHost();

        Assert.assertTrue(fieldsPage.isInputFieldDisplay("E-Mail:"));
        Assert.assertTrue(fieldsPage.isInputFieldDisplay("Пароль:"));
        Assert.assertTrue(authPage.isDisplayButtonByText("Вход"));
    }

    @Test(description = "step_2")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать кнопку 'Вход'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного окна")
    public void step_2() {
        authPage.clickButton("Вход");

        Assert.assertTrue(authPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(authPage.isDisplayAlertCloseIcon());
    }

    @Test(description = "step_3")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на иконку закрытия информационного сообщения" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Информационное сообщение с текстом 'Неверный формат E-Mail' не отображается")
    public void step_3() {
        authPage.clickCloseAlertIcon();

        Assert.assertFalse(authPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
    }

    @Test(description = "step_4")
    @Description("<pre>Действие:" + "\r\n"
            + "В поле ввода 'E-Mail' ввести значение 'test'" + "\r\n"
            + "Нажать кнопку 'Вход'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного окна" + "\r\n"
            + "В поле ввода 'E-Mail' отображается значение 'test'")
    public void step_4() {
        fieldsPage.setValueInInputField("E-Mail:", "test");
        authPage.clickButton("Вход");

        Assert.assertTrue(authPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(authPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(fieldsPage.getTextFromInput("E-Mail:"), "test");
    }

    @Test(description = "step_5")
    @Description("<pre>Действие:" + "\r\n"
            + "Очистить поле ввода 'E-Mail'" + "\r\n"
            + "В поле ввода 'E-Mail' ввести значение 'test@test.ru'" + "\r\n"
            + "Нажать кнопку 'Вход'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного окна" + "\r\n"
            + "В поле ввода 'E-Mail' отображается значение 'test@test.ru'")
    public void step_5() {
        fieldsPage.clearInputField("E-Mail");
        fieldsPage.setValueInInputField("E-Mail", "test@test.ru");
        authPage.clickButton("Вход");

        Assert.assertTrue(authPage.isDisplayAlertFieldWithText("Неверный E-Mail или пароль"));
        Assert.assertTrue(authPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(fieldsPage.getTextFromInput("E-Mail:"), "test@test.ru");
    }

    @Test(description = "step_6")
    @Description("<pre>Действие:" + "\r\n"
            + "В поле ввода 'Пароль:' ввести значение 'test'" + "\r\n"
            + "Нажать кнопку 'Вход'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный E-Mail или пароль'" + "\r\n"
            + "Отображается иконка закрытия информационного окна" + "\r\n"
            + "В поле ввода 'Пароль:' отображается значение 'test'")
    public void step_6() {
        fieldsPage.setValueInInputField("Пароль:", "test");
        authPage.clickButton("Вход");

        Assert.assertTrue(authPage.isDisplayAlertFieldWithText("Неверный E-Mail или пароль"));
        Assert.assertTrue(authPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(fieldsPage.getTextFromInput("Пароль:"), "test");
    }

    @Test(description = "step_7")
    @Description("<pre>Действие:" + "\r\n"
            + "Очистить поле ввода 'E-Mail:'" + "\r\n"
            + "Очистить поле ввода 'Пароль:'" + "\r\n"
            + "В поле ввода 'E-Mail:' ввести значение 'test@protei.ru'" + "\r\n"
            + "В поле ввода 'Пароль:' ввести значение 'test'" + "\r\n"
            + "Нажать кнопку 'Вход'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается поле ввода 'E-Mail:'" + "\r\n"
            + "Отображается поле ввода 'Имя:'" + "\r\n"
            + "Отображается выпадающий список 'Пол:'"
            + "В выпадающем списке 'Пол:' отображается значение 'Мужской'" + "\r\n"
            + "Отоюражается чекбокс 'Вариант 1.1'" + "\r\n"
            + "Отображается чекбокс 'Вариант 1.2'" + "\r\n"
            + "Чекбокс 'Вариант 1.1' в состоянии 'false'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'false'" + "\r\n"
            + "Отображается радиобаттон 'Вариант 2.1'" + "\r\n"
            + "Отображается радиобаттон 'Вариант 2.2'" + "\r\n"
            + "Отображается радиобаттон 'Вариант 2.3'" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.2' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.3' в состоянии 'false'" + "\r\n"
            + "Отображается кнопка 'Добавить'" + "\r\n"
            + "Отображается таблица")

    public void step_7() {
        fieldsPage.clearInputField("E-Mail:");
        fieldsPage.clearInputField("Пароль:");
        fieldsPage.setValueInInputField("E-Mail:", "test@protei.ru");
        fieldsPage.setValueInInputField("Пароль:", "test");
        authPage.clickButton("Вход");

        Assert.assertTrue(fieldsPage.isInputFieldDisplay("E-Mail:"));
        Assert.assertTrue(fieldsPage.isInputFieldDisplay("Имя:"));
        Assert.assertTrue(dropdownPage.isDisplayDropdown("Пол:"));
        Assert.assertEquals(dropdownPage.getDropdownValue("Пол:"), "Мужской");
        Assert.assertTrue(checkboxPage.isDisplayCheckbox("Вариант 1.1"));
        Assert.assertTrue(checkboxPage.isDisplayCheckbox("Вариант 1.2"));
        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.2"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonDisplay("Вариант 2.1"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonDisplay("Вариант 2.2"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonDisplay("Вариант 2.3"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.2"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.3"));
        Assert.assertTrue(authPage.isDisplayButtonByText("Добавить"));
        Assert.assertTrue(formPage.isDisplayTableHeaders());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
