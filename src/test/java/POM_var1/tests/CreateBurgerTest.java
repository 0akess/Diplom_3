package POM_var1.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import POM_var1.site.stellarburgersnomoreparties.pages.AuthorizationPage;
import POM_var1.site.stellarburgersnomoreparties.pages.CreateBurgerPage;
import POM_var1.site.stellarburgersnomoreparties.resources.BaseURL;

@DisplayName("Сьют на создание бургера")
public class CreateBurgerTest extends BaseTest {

    private final CreateBurgerPage createBurger = Selenide.page(CreateBurgerPage.class);

    @Test
    @DisplayName("Проверка перехода в раздел Булки")
    public void checkGoSectionBun(){
        createBurger
                .open(BaseURL.MAIN_URL)
                .clickFilling()
                .clickBun()
                .isBunSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Соусы")
    public void checkGoSectionSauce(){
        createBurger
                .open(BaseURL.MAIN_URL)
                .clickSauce()
                .isSauceSelected()
                .clickPersonalAccount(AuthorizationPage.class)
                .setValueEmail("test")
                .clickConstructor()
                .checkItIsMainPage()
                .clickPersonalAccount(AuthorizationPage.class);
    }

    @Test
    @DisplayName("Проверка перехода в раздел Начинки")
    public void checkGoSectionFilling(){
        createBurger
                .open(BaseURL.MAIN_URL)
                .clickFilling()
                .isFillingSelected();
    }
}