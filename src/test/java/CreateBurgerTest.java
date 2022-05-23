import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.page.object.CreateBurgerPage;

import static site.stellarburgers.nomoreparties.BaseURL.MAIN_URL;

@DisplayName("Сьют на создание бургера")
public class CreateBurgerTest extends BaseTest {

    private static final CreateBurgerPage createBurger = Selenide.page(CreateBurgerPage.class);

    @Test
    @DisplayName("Проверка перехода в раздел Булки")
    public void checkGoSectionBun(){
        createBurger
                .openPage(MAIN_URL)
                .clickFilling()
                .clickBun()
                .isBunSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Соусы")
    public void checkGoSectionSauce(){
        createBurger
                .openPage(MAIN_URL)
                .clickSauce()
                .isSauceSelected();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Начинки")
    public void checkGoSectionFilling(){
        createBurger
                .openPage(MAIN_URL)
                .clickFilling()
                .isFillingSelected();
    }
}