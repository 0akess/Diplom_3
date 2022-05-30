import com.codeborne.selenide.Selenide;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.stellarburgers.nomoreparties.BaseURL;
import site.stellarburgers.nomoreparties.data.tests.GetUserData;
import site.stellarburgers.nomoreparties.page.object.RegistrationPage;
import site.stellarburgers.nomoreparties.respons.model.User;
import site.stellarburgers.nomoreparties.respons.user.DeleteUser;
import site.stellarburgers.nomoreparties.respons.user.PostLoginUser;

@DisplayName("Сьют на регистрацию пользователя")
public class RegistrationTests extends BaseTest {

    RegistrationPage registration = Selenide.page(RegistrationPage.class);
    private static final GetUserData data = new GetUserData();
    private static final String email = data.getEmailUser();
    private static final String password = data.getPasswordUser(7);

    @AfterAll
    @DisplayName("Удаляем тестового пользователя")
    public static void endTests() {
        try {
            new DeleteUser()
                    .deleteUser(new PostLoginUser().loginUser(new User().builder().email(email).password(password).build())
                            .extract().path("accessToken"))
                    .statusCode(HttpStatus.SC_ACCEPTED);
        }catch (IllegalArgumentException e){
            System.out.println("пользователь не создавался");
        }
    }

    @Test
    @DisplayName("Проверка формы регистрации")
    public void positiveRegistrationUser() {
        registration
                .openPage(BaseURL.REGISTRATION_URl)
                .setValueName(data.getNameUser())
                .setValueEmail(email)
                .setValuePassword(password)
                .clickRegister()
                .checkRegistration();
    }

    @Test
    @DisplayName("Проверка регистрации - ошибка при вводе пароля меньше 6 цифр")
    public void checkErrorMessagePassword() {
        registration
                .openPage(BaseURL.REGISTRATION_URl)
                .setValueName(data.getNameUser())
                .setValueEmail(data.getEmailUser())
                .setValuePassword(data.getPasswordUser(5))
                .clickRegister()
                .checkPasswordError();
    }
}