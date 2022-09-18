package POM_var1.site.stellarburgersnomoreparties.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationPage extends BaseMethodPage<RegistrationPage> {

    @FindBy(how = How.XPATH, using = "//*[text()='Имя']/following-sibling::*")
    private SelenideElement inputName;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::*")
    private SelenideElement inputEmail;

    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::*")
    private SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = "//*[text()='Зарегистрироваться']")
    private SelenideElement buttonRegister;

    @FindBy(how = How.XPATH, using = "//*[text()='Вход']")
    private SelenideElement textEntry;

    @FindBy(how = How.XPATH, using = "//*[text()='Некорректный пароль']")
    private SelenideElement errorPassword;

    @Step("нажатие на кнопку Зарегистрироваться")
    public RegistrationPage clickRegister() {
        buttonRegister.click();
        return this;
    }

    @Step("ввод значение в поле Имя")
    public RegistrationPage setValueName(String name) {
        inputName.setValue(name);
        return this;
    }

    @Step("ввод значение в поле Email")
    public RegistrationPage setValueEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("ввод значение в поле Пароль")
    public RegistrationPage setValuePassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    @Step("проверка успешной регистрации")
    public RegistrationPage checkRegistration(){
        textEntry.shouldBe(Condition.visible);
        return this;
    }

    @Step("проверка отображения ошибки невалидного пароля")
    public RegistrationPage checkPasswordError(){
        errorPassword.shouldBe(Condition.visible);
        return this;
    }
}