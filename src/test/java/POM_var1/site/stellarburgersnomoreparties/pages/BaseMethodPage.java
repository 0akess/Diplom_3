package POM_var1.site.stellarburgersnomoreparties.pages;

import POM_var1.site.stellarburgersnomoreparties.resources.BaseURL;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BaseMethodPage<T> {

    public T open(BaseURL url) {
        Selenide.open(url.getUrl());
        return (T) this;
    }

    @Step("нажатие на кнопку Личный Кабинет")
    public static <PersonalAccount extends Personal> PersonalAccount clickPersonalAccount(Class<PersonalAccount> personal) {
        $(By.linkText("Личный Кабинет")).click();
        return page(personal);
    }

    @Step("нажатие на кнопку Конструктор")
    public CreateBurgerPage clickConstructor() {
        $(By.linkText("Конструктор")).click();
        return page(CreateBurgerPage.class);
    }

    @Step("нажатие на кнопку Stellar Burgers")
    public CreateBurgerPage clickStellarBurgers() {
        $(By.className("AppHeader_header__logo__2D0X2")).click();
        return page(CreateBurgerPage.class);
    }
}
