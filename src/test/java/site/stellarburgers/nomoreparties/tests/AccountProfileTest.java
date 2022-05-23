package site.stellarburgers.nomoreparties.tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.nomoreparties.BaseTest;
import site.stellarburgers.nomoreparties.data.tests.GetUserData;
import site.stellarburgers.nomoreparties.page.object.AccountProfilePage;
import site.stellarburgers.nomoreparties.page.object.AuthorizationPage;
import site.stellarburgers.nomoreparties.respons.model.User;
import site.stellarburgers.nomoreparties.respons.user.DeleteUser;
import site.stellarburgers.nomoreparties.respons.user.PostRegister;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static site.stellarburgers.nomoreparties.BaseURL.LOGIN_URL;


@DisplayName("Сьют на личный кабинет пользователя")
public class AccountProfileTest extends BaseTest {

    private static String token;
    private static final GetUserData data = new GetUserData();
    private static final String email = data.getEmailUser();
    private static final String password = data.getPasswordUser(7);
    private static final String name = data.getNameUser();
    private static final AccountProfilePage profilePage = page(AccountProfilePage.class);

    @Before
    @DisplayName("Создаем пользователя для тетсов")
    public void startTest() {
        token = new PostRegister().registerUser(new User(email, password, name))
                .statusCode(HttpStatus.SC_OK)
                .extract().path("accessToken");

        open(LOGIN_URL, AuthorizationPage.class)
                .setValueEmail(email)
                .setValuePassword(password)
                .clickLogInToTheSite();
    }

    @After
    @DisplayName("Удаляем тестового пользователя")
    public void endTests() {
        new DeleteUser().deleteUser(token)
                .statusCode(HttpStatus.SC_ACCEPTED);
    }


    @Test
    @DisplayName("Проверка перехода в Личный кабинет пользователя")
    public void checkClickThroughToAccountProfile() {
        profilePage
                .clickPersonalAccount()
                .checkItIsPersonalAccountPage();
    }

    @Test
    @DisplayName("Проверка перехода из Личного кабинета на главную по кнопке Конструктор")
    public void checkClickThroughToConstructor() {
        profilePage
                .clickPersonalAccount()
                .clickConstructor()
                .checkItIsMainePage();
    }

    @Test
    @DisplayName("Проверка перехода из Личного кабинета на главную по кнопке Stellar Burgers")
    public void checkClickThroughToStellarBurgers() {
        profilePage
                .clickPersonalAccount()
                .clickStellarBurgers()
                .checkItIsMainePage();
    }

    @Test
    @DisplayName("Проверка выхода из Личного кабинета пользователя")
    public void checkLogOutProfile() {
        profilePage
                .clickPersonalAccount()
                .clickLogOut()
                .checkItIsLoginPage();
    }
}