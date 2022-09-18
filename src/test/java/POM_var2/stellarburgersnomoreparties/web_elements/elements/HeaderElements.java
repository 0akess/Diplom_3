package POM_var2.stellarburgersnomoreparties.web_elements.elements;

import POM_var2.stellarburgersnomoreparties.web_elements.BaseMethodPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HeaderElements extends BaseMethodPage<HeaderElements> {

    @Step("нажатие на кнопку Личный Кабинет")
    public HeaderElements clickPersonalAccount() {
        $(By.linkText("Личный Кабинет")).click();
        return this;
    }

    @Step("нажатие на кнопку Конструктор")
    public HeaderElements clickConstructor() {
        $(By.linkText("Конструктор")).click();
        return this;
    }

    @Step("нажатие на кнопку Stellar Burgers")
    public HeaderElements clickStellarBurgers() {
        $(By.className("AppHeader_header__logo__2D0X2")).click();
        return this;
    }
}
