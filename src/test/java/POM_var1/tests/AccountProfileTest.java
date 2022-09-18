package POM_var1.tests;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import POM_var1.site.stellarburgersnomoreparties.data.tests.GetUserData;
import POM_var1.site.stellarburgersnomoreparties.pages.AccountProfilePage;
import POM_var1.site.stellarburgersnomoreparties.pages.AuthorizationPage;
import POM_var1.site.stellarburgersnomoreparties.request.model.User;
import POM_var1.site.stellarburgersnomoreparties.request.user.DeleteUser;
import POM_var1.site.stellarburgersnomoreparties.request.user.PostRegister;
import POM_var1.site.stellarburgersnomoreparties.resources.BaseURL;

import static com.codeborne.selenide.Selenide.page;

@DisplayName("Сьют на личный кабинет пользователя")
public class AccountProfileTest extends BaseTest {

    private String token;
    private final GetUserData data = new GetUserData();
    private final String email = data.getEmailUser();
    private final String password = data.getPasswordUser(7);
    private final String name = data.getNameUser();
    private AccountProfilePage profilePage = page(AccountProfilePage.class);

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
        profilePage
                .clickPersonalAccount(AccountProfilePage.class)
                .checkItIsPersonalAccountPage();
    }

    @Test
    @DisplayName("Проверка перехода из Личного кабинета на главную по кнопке Конструктор")
    public void checkClickThroughToConstructor() {
        profilePage
                .clickPersonalAccount(AccountProfilePage.class)
                .clickConstructor()
                .checkItIsMainPage();
    }

    @Test
    @DisplayName("Проверка перехода из Личного кабинета на главную по кнопке Stellar Burgers")
    public void checkClickThroughToStellarBurgers() {
        profilePage
                .clickPersonalAccount(AccountProfilePage.class)
                .clickStellarBurgers()
                .checkItIsMainPage();
    }

    @Test
    @DisplayName("Проверка выхода из Личного кабинета пользователя")
    public void checkLogOutProfile() {
        profilePage
                .clickPersonalAccount(AccountProfilePage.class)
                .clickLogOut()
                .checkItIsLoginPage();
    }
}