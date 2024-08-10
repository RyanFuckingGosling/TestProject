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

public class test_2 {

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

        authPage.openHost();
        fieldsPage.setValueInInputField("E-Mail:", "test@protei.ru");
        fieldsPage.setValueInInputField("Пароль:", "test");
        authPage.clickButton("Вход");
    }

    @Test(priority = 1, description = "step_1")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное окно с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного окна")
    public void step_1() {
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
    }

    @Test(priority = 2, description = "step_2")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на иконку закрытия информационного окна" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Информационное окно с текстом 'Неверный формат E-Mail не отображается'")
    public void step_2() {
        formPage.clickCloseAlertIcon();

        Assert.assertFalse(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
    }

    @Test(priority = 3, description = "step_3")
    @Description("<pre>Действие:" + "\r\n"
            + "В поле ввода 'E-Mail' ввести значение 'test'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного сообщения" + "\r\n"
            + "В поле ввода 'E-Mail' отображается значение 'test'")
    public void step_3() {
        fieldsPage.setValueInInputField("E-Mail", "test");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(fieldsPage.getTextFromInput("E-Mail"), "test");
    }

    @Test(priority = 4, description = "step_4")
    @Description("<pre>Действие:" + "\r\n"
            + "В поле ввода 'Имя:' ввести значение 'test'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного сообщения" + "\r\n"
            + "В поле ввода 'Имя:' отображается значение 'test'")
    public void step_4() {
        fieldsPage.setValueInInputField("Имя:", "test");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(fieldsPage.getTextFromInput("Имя:"), "test");
    }

    @Test(priority = 5, description = "step_5")
    @Description("<pre>Действие:" + "\r\n"
            + "В выпадающем списке 'Пол:' выбрать значение 'Женский'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного сообщения" + "\r\n"
            + "В выпадающем списке 'Пол:' отображается значение 'Женский'")
    public void step_5() {
        dropdownPage.selectValueFromDropdown("Пол:", "Женский");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(dropdownPage.getDropdownValue("Пол:"), "Женский");
    }

    @Test(priority = 6, description = "step_6")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.1'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Чекбокс 'Вариант 1.1' в состоянии 'true'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'false'")
    public void step_6() {
        checkboxPage.clickCheckbox("Вариант 1.1");

        Assert.assertTrue(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.2"));
    }

    @Test(priority = 7, description = "step_7")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.1'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Чекбокс 'Вариант 1.1' в состоянии 'false'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'false'")
    public void step_7() {
        checkboxPage.clickCheckbox("Вариант 1.1");

        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.2"));
    }

    @Test(priority = 8, description = "step_8")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.1'" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.2'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного сообщения" + "\r\n"
            + "Чекбокс 'Вариант 1.1' в состоянии 'true'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'true'")
    public void step_8() {
        checkboxPage.clickCheckbox("Вариант 1.1");
        checkboxPage.clickCheckbox("Вариант 1.2");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
        Assert.assertTrue(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertTrue(checkboxPage.isCheckboxChecked("Вариант 1.2"));
    }

    @Test(priority = 9, description = "step_9")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на радиобаттон 'Вариант 2.1'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Неверный формат E-Mail'" + "\r\n"
            + "Отображается иконка закрытия информационного сообщения" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'true'" + "\r\n"
            + "Радиобаттон 'Вариант 2.2' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.3' в состоянии 'false'")
    public void step_9() {
        radiobuttonPage.clickRadiobutton("Вариант 2.1");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Неверный формат E-Mail"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
        Assert.assertTrue(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.2"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.3"));
    }

    @Test(priority = 10, description = "step_10")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на радиобаттон 'Вариант 2.2'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.2' в состоянии 'true'" + "\r\n"
            + "Радиобаттон 'Вариант 2.3' в состоянии 'false'")
    public void step_10() {
        radiobuttonPage.clickRadiobutton("Вариант 2.2");

        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonChecked("Вариант 2.2"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.3"));
    }

    @Test(priority = 11, description = "step_11")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на радиобаттон 'Вариант 2.3'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.2' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.3' в состоянии 'true'")
    public void step_11() {
        radiobuttonPage.clickRadiobutton("Вариант 2.3");

        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.2"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonChecked("Вариант 2.3"));
    }

    @Test(priority = 12, description = "step_12")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать на иконку закрытия информационного сообщения" + "\r\n"
            + "Очистить поле ввода 'E-Mail'" + "\r\n"
            + "В поле ввода 'E-Mail' ввести значение 'test@test.ru'" + "\r\n"
            + "Очистить поле ввода 'Имя:'" + "\r\n"
            + "В выпадающем списке 'Пол:' выбрать значение 'Мужской'" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.2'" + "\r\n"
            + "Нажать на радиобаттон 'Вариант 2.1'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается информационное сообщение с текстом 'Поле имя не может быть пустым'" + "\r\n"
            + "Отображается иконка закрытия информационного сообщения" + "\r\n"
            + "В поле ввода 'E-Mail' отображается значение 'test@test.ru'" + "\r\n"
            + "В выпадающем списке 'Пол:' отображается значение 'Мужской'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'true'" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'true'")
    public void step_12() {
        formPage.clickCloseAlertIcon();
        fieldsPage.clearInputField("E-Mail:");
        fieldsPage.setValueInInputField("E-Mail:", "test@test.ru");
        fieldsPage.clearInputField("Имя:");
        dropdownPage.selectValueFromDropdown("Пол:", "Мужской");
        checkboxPage.clickCheckbox("Вариант 1.2");
        radiobuttonPage.clickRadiobutton("Вариант 2.1");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayAlertFieldWithText("Поле имя не может быть пустым"));
        Assert.assertTrue(formPage.isDisplayAlertCloseIcon());
        Assert.assertEquals(fieldsPage.getTextFromInput("E-Mail"), "test@test.ru");
        Assert.assertEquals(dropdownPage.getDropdownValue("Пол:"), "Мужской");
        Assert.assertTrue(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
    }

    @Test(priority = 13, description = "step_13")
    @Description("<pre>Действие:" + "\r\n"
            + "В поле ввода 'Имя:' ввести значение 'test'" + "\r\n"
            + "В выпадающем списке 'Пол:' выбрать значение 'Женский'" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.1'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "Отображается модальное окно" + "\r\n"
            + "В модальном окне отображается значение 'Данные добавлены.'" + "\r\n"
            + "В модальном окне отображается кнопка 'Ok'")
    public void step_13() {
        fieldsPage.setValueInInputField("Имя:", "test");
        dropdownPage.selectValueFromDropdown("Пол:", "Женский");
        checkboxPage.clickCheckbox("Вариант 1.1");
        formPage.clickButton("Добавить");

        Assert.assertTrue(formPage.isDisplayModalWindow());
        Assert.assertEquals(formPage.getTextFromModalWindow(), "Данные добавлены.");
        Assert.assertTrue(formPage.isDisplayButtonInModalWindow("Ok"));
    }

    @Test(priority = 14, description = "step_14")
    @Description("<pre>Действие:" + "\r\n"
            + "Нажать кнопку 'Ok'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "В поле ввода 'E-Mail' отображается значение 'test@test.ru'" + "\r\n"
            + "В поле ввода 'Имя:' отображается значение 'test'" + "\r\n"
            + "В выпадающем списке 'Пол:' отображается значение 'Женский'" + "\r\n"
            + "Чекбокс 'Вариант 1.1' в состоянии 'false'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'true'" + "\r\n"
            + "Радиобаттон 'Вариант 2.2' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.3' в состоянии 'false'" + "\r\n"
            + "В таблице отображается строка со значениями 'test@test.ru', 'test', 'Женский', 'Нет', '2.1'")
    public void step_14() {
        formPage.clickButton("Ok");

        Assert.assertEquals(fieldsPage.getTextFromInput("E-Mail"), "test@test.ru");
        Assert.assertEquals(fieldsPage.getTextFromInput("Имя:"), "test");
        Assert.assertEquals(dropdownPage.getDropdownValue("Пол:"), "Женский");
        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertFalse(checkboxPage.isCheckboxChecked("Вариант 1.2"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.2"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.3"));
        String[] data = {"test@test.ru", "test", "Женский", "Нет", "2.1"};
        Assert.assertTrue(formPage.isDisplayRowInTable(data));
    }

    @Test(priority = 15, description = "step_15")
    @Description("<pre>Действие:" + "\r\n"
            + "Очистить поле ввода 'E-Mail'" + "\r\n"
            + "В поле ввода 'E-Mail' ввести значение 'test.pass@second.ru'" + "\r\n"
            + "Очистить поле ввода 'Имя:'" + "\r\n"
            + "В поле ввода 'Имя:' ввести значение 'testTEST'" + "\r\n"
            + "В выпадающем списке 'Пол:' выбрать значение 'Мужской'" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.1'" + "\r\n"
            + "Нажать на чекбокс 'Вариант 1.2'" + "\r\n"
            + "Нажать на радиобаттон 'Вариант 2.3'" + "\r\n"
            + "Нажать кнопку 'Добавить'" + "\r\n"
            + "Нажать кнопку 'Ok'" + "\r\n"
            + "Ожидаемый результат:" + "\r\n"
            + "В поле ввода 'E-Mail' отображается значение 'test.pass@second.ru'" + "\r\n"
            + "В поле ввода 'Имя:' отображается значение 'testTEST'" + "\r\n"
            + "В выпадающем списке 'Пол:' отображается значение 'Мужской'" + "\r\n"
            + "Чекбокс 'Вариант 1.1' в состоянии 'true'" + "\r\n"
            + "Чекбокс 'Вариант 1.2' в состоянии 'true'" + "\r\n"
            + "Радиобаттон 'Вариант 2.1' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.2' в состоянии 'false'" + "\r\n"
            + "Радиобаттон 'Вариант 2.3' в состоянии 'true'" + "\r\n"
            + "В таблице отображается строка со значениями 'test.pass@second.ru', 'testTEST', 'Мужской', '1.1, 1.2', '2.3'")
    public void step_15() {
        fieldsPage.clearInputField("E-Mail");
        fieldsPage.setValueInInputField("E-Mail", "test.pass@second.ru");
        fieldsPage.clearInputField("Имя:");
        fieldsPage.setValueInInputField("Имя:", "testTEST");
        dropdownPage.selectValueFromDropdown("Пол:", "Мужской");
        checkboxPage.clickCheckbox("Вариант 1.1");
        checkboxPage.clickCheckbox("Вариант 1.2");
        radiobuttonPage.clickRadiobutton("Вариант 2.3");
        formPage.clickButton("Добавить");
        formPage.clickButton("Ok");

        Assert.assertEquals(fieldsPage.getTextFromInput("E-Mail"), "test.pass@second.ru");
        Assert.assertEquals(fieldsPage.getTextFromInput("Имя:"), "testTEST");
        Assert.assertEquals(dropdownPage.getDropdownValue("Пол:"), "Мужской");
        Assert.assertTrue(checkboxPage.isCheckboxChecked("Вариант 1.1"));
        Assert.assertTrue(checkboxPage.isCheckboxChecked("Вариант 1.2"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.1"));
        Assert.assertFalse(radiobuttonPage.isRadiobuttonChecked("Вариант 2.2"));
        Assert.assertTrue(radiobuttonPage.isRadiobuttonChecked("Вариант 2.3"));
        String[] data = {"test.pass@second.ru", "testTEST", "Мужской", "1.1, 1.2", "2.3"};
        Assert.assertTrue(formPage.isDisplayRowInTable(data));
    }

    @AfterClass()
    public void afterClass() {
        driver.close();
    }
}
