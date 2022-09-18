package POM_var2.tests;

import POM_var2.stellarburgersnomoreparties.data.tests.GetUserData;
import POM_var2.stellarburgersnomoreparties.web_elements.pages.AccountProfilePage;
import POM_var2.stellarburgersnomoreparties.web_elements.pages.AuthorizationPage;
import POM_var2.stellarburgersnomoreparties.web_elements.pages.CreateBurgerPage;
import POM_var2.stellarburgersnomoreparties.web_elements.elements.HeaderElements;
import POM_var2.stellarburgersnomoreparties.request.model.User;
import POM_var2.stellarburgersnomoreparties.request.user.DeleteUser;
import POM_var2.stellarburgersnomoreparties.request.user.PostRegister;
import POM_var2.stellarburgersnomoreparties.resources.BaseURL;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

@DisplayName("Сьют на личный кабинет пользователя")
public class AccountProfileTest extends BaseTest {

    private String token;
    private final GetUserData data = new GetUserData();
    private final String email = data.getEmailUser();
    private final String password = data.getPasswordUser(7);
    private final String name = data.getNameUser();
    private AccountProfilePage profilePage = page(AccountProfilePage.class);
    private HeaderElements header = page(HeaderElements.class);
    private CreateBurgerPage create = page(CreateBurgerPage.class);

    @BeforeEach
    @DisplayName("Создаем пользователя для тестов и авторизовываемся")
    public void startTest() {
        token = new PostRegister().registerUser(new User().builder()
                        .email(email)
                        .password(password)
                        .name(name)
                        .build())
                .statusCode(HttpStatus.SC_OK)
                .extract().path("accessToken");

        page(AuthorizationPage.class)
                .open(BaseURL.LOGIN_URL)
                .setValueEmail(email)
                .setValuePassword(password)
                .clickLogInToTheSite();
    }

    @AfterEach
    @DisplayName("Удаляем тестового пользователя")
    public void endTests() {
        new DeleteUser().deleteUser(token)
                .statusCode(HttpStatus.SC_ACCEPTED);
    }

    @Test
    @DisplayName("Проверка перехода в Личный кабинет пользователя")
    public void checkClickThroughToAccountProfile() {

        header
                .open(BaseURL.MAIN_URL)
                .clickPersonalAccount();
        profilePage
                .checkItIsPersonalAccountPage();
    }

    @Test
    @DisplayName("Проверка перехода из Личного кабинета на главную по кнопке Конструктор")
    public void checkClickThroughToConstructor() {
        header
                .open(BaseURL.MAIN_URL)
                .clickPersonalAccount()
                .clickConstructor();
        create
                .checkItIsMainPage();
    }

    @Test
    @DisplayName("Проверка перехода из Личного кабинета на главную по кнопке Stellar Burgers")
    public void checkClickThroughToStellarBurgers() {
        header
                .open(BaseURL.MAIN_URL)
                .clickPersonalAccount()
                .clickStellarBurgers();
        create
                .checkItIsMainPage();
    }

    @Test
    @DisplayName("Проверка выхода из Личного кабинета пользователя")
    public void checkLogOutProfile() {
        header
                .open(BaseURL.MAIN_URL)
                .clickPersonalAccount();
        profilePage
                .clickLogOut()
                .checkItIsLoginPage();
    }
}