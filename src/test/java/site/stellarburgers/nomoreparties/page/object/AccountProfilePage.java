package site.stellarburgers.nomoreparties.page.object;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;
import static site.stellarburgers.nomoreparties.BaseURL.*;

public class AccountProfilePage {

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalAccount;

    @FindBy(how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement buttonStellarBurgers;

    @FindBy(how = How.XPATH, using = "//*[text()='Выход']")
    private SelenideElement buttonLogOut;


    @Step("нажатие на кнопку Stellar Burgers")
    public AccountProfilePage clickStellarBurgers(){
        buttonStellarBurgers.click();
        return this;
    }

    @Step("нажатие на кнопку Конструктор")
    public AccountProfilePage clickConstructor(){
        buttonConstructor.click();
        return this;
    }

    @Step("нажатие на кнопку Конструктор")
    public AccountProfilePage clickPersonalAccount() {
        buttonPersonalAccount.click();
        return this;
    }

    @Step("нажатие на кнопку Конструктор")
    public AccountProfilePage clickLogOut(){
        buttonLogOut.click();
        return this;
    }

    @Step("проверка успешного перехода в Личный кабинет")
    public AccountProfilePage checkItIsPersonalAccountPage(){
        Selenide.sleep(1000);
        assertEquals("Вы не перешли на страницу личного кабинета",
                ACCOUNT_PROFILE_URL, WebDriverRunner.url());
        return this;
    }

    @Step("проверка успешного перехода на Главную страницу")
    public AccountProfilePage checkItIsMainePage(){
        assertEquals("Вы не перешли на сглавную страницу",
                MAINE_URL, WebDriverRunner.url());
        return this;
    }

    @Step("проверка успешного выхода из аккаунта")
    public AccountProfilePage checkItIsLoginPage(){
        Selenide.sleep(1000);
        assertEquals("Вы не вышли из аккаунта",
                LOGIN_URL, WebDriverRunner.url());
        return this;
    }
}