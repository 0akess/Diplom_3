package site.stellarburgers.nomoreparties.page.object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AuthorizationPage {

    @FindBy(how = How.XPATH, using = "//*[text()='Уже зарегистрированы?']/child::*")
    private SelenideElement buttonEntryToRegister;

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalAccount;

    @FindBy(how = How.XPATH, using = "//*[text()='Войти в аккаунт']")
    private SelenideElement buttonEntryToMaine;

    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement buttonEntryToRecoveryPassword;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::*")
    private SelenideElement inputEmail;

    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::*")
    private SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement buttonLogInToTheSite;

    @FindBy(how = How.XPATH, using = "//*[text()='Оформить заказ']")
    private SelenideElement buttonPlaceAnOrder;


    @Step("переход по ссылке")
    public AuthorizationPage openPage(String url) {
        Selenide.open(url);
        return this;
    }

    @Step("нажатие на кнопку Личный Кабинет")
    public AuthorizationPage clickPersonalAccount() {
        buttonPersonalAccount.click();
        return this;
    }

    @Step("нажатие на кнопку Войти в аккаунт")
    public AuthorizationPage clickLogInToTheSite() {
        buttonLogInToTheSite.click();
        return this;
    }

    @Step("нажатие на кнопку Войти в аккаунт")
    public AuthorizationPage clickEntryToRegisterPage() {
        buttonEntryToRegister.click();
        return this;
    }

    @Step("нажатие на кнопку Войти")
    public AuthorizationPage clickEntryToMainePage() {
        buttonEntryToMaine.click();
        return this;
    }

    @Step("нажатие на кнопку Войти")
    public AuthorizationPage clickEntryToRecoveryPasswordPage() {
        buttonEntryToRecoveryPassword.click();
        return this;
    }

    @Step("ввод значение в поле Email")
    public AuthorizationPage setValueEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("ввод значение в поле Password")
    public AuthorizationPage setValuePassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    @Step("проверка успешной авторизации")
    public AuthorizationPage checkSuccessfulAuthorization() {
        buttonPlaceAnOrder.shouldBe(Condition.visible);
        return this;
    }
}
