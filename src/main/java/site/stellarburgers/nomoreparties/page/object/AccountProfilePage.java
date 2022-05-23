package site.stellarburgers.nomoreparties.page.object;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static site.stellarburgers.nomoreparties.BaseURL.*;

public class AccountProfilePage {

    // для чего: https://ru.stackoverflow.com/questions/1155809/Разница-между-findby-и-findelements
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalAccount;

    @FindBy(how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement buttonStellarBurgers;

    @FindBy(how = How.XPATH, using = "//*[text()='Выход']")
    private SelenideElement buttonLogOut;


    //  @Step - штука для алюра
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
        assertEquals(ACCOUNT_PROFILE_URL, WebDriverRunner.url(),
                "Вы не перешли на страницу личного кабинета");
        return this;
    }

    @Step("проверка успешного перехода на Главную страницу")
    public AccountProfilePage checkItIsMainePage(){
        assertEquals(MAIN_URL, WebDriverRunner.url(),
                "Вы не перешли на сглавную страницу");
        return this;
    }

    @Step("проверка успешного выхода из аккаунта")
    public AccountProfilePage checkItIsLoginPage(){
        Selenide.sleep(1000);
        assertEquals(LOGIN_URL, WebDriverRunner.url(),
                "Вы не вышли из аккаунта");
        return this;
    }
}