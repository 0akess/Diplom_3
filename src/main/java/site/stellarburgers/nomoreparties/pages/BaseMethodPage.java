package site.stellarburgers.nomoreparties.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import site.stellarburgers.nomoreparties.resources.BaseURL;

public class BaseMethodPage<T> {

//    private final T T;
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalAccount;

    @FindBy(how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement buttonStellarBurgers;


    public T open(BaseURL url){
        Selenide.open(url.getUrl());
        return (T) this;
    }

    @Step("нажатие на кнопку Личный Кабинет")
    public static <E> E clickPersonalAccount(Personal personal) {
//        buttonPersonalAccount.click();
        return (E) personal.o();
    }

    @Step("нажатие на кнопку Конструктор")
    public CreateBurgerPage clickConstructor(){
        buttonConstructor.click();
        return new CreateBurgerPage();
    }

    @Step("нажатие на кнопку Stellar Burgers")
    public CreateBurgerPage clickStellarBurgers(){
        buttonStellarBurgers.click();
        return new CreateBurgerPage();
    }
}
