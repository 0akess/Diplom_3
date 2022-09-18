package POM_var2.tests;

import POM_var2.stellarburgersnomoreparties.web_elements.pages.CreateBurgerPage;
import POM_var2.stellarburgersnomoreparties.resources.BaseURL;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                .isSauceSelected();
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