package site.stellarburgers.nomoreparties.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.BaseTest;
import site.stellarburgers.nomoreparties.page.object.CreateBurgerPage;

import static site.stellarburgers.nomoreparties.BaseURL.MAINE_URL;


@DisplayName("Сьют на создание бургера")
public class CreateBurgerTest extends BaseTest {

    private static final CreateBurgerPage createBurger = Selenide.page(CreateBurgerPage.class);

    @Test
    @DisplayName("Проверка перехода в раздел Булки")
    public void checkGoSectionBun(){
        createBurger
                .openPage(MAINE_URL)
                .clickFilling()
                .clickBun()
                .isBunSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Соусы")
    public void checkGoSectionSauce(){
        createBurger
                .openPage(MAINE_URL)
                .clickSauce()
                .isSauceSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Начинки")
    public void checkGoSectionFilling(){
        createBurger
                .openPage(MAINE_URL)
                .clickFilling()
                .isFillingSelected();
    }
}
