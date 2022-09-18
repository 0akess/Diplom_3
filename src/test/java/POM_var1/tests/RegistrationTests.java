package POM_var1.tests;

import com.codeborne.selenide.Selenide;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import POM_var1.site.stellarburgersnomoreparties.resources.BaseURL;
import POM_var1.site.stellarburgersnomoreparties.data.tests.GetUserData;
import POM_var1.site.stellarburgersnomoreparties.pages.RegistrationPage;
import POM_var1.site.stellarburgersnomoreparties.request.model.User;
import POM_var1.site.stellarburgersnomoreparties.request.user.DeleteUser;
import POM_var1.site.stellarburgersnomoreparties.request.user.PostLoginUser;

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
                .open(BaseURL.REGISTRATION_URl)
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
                .open(BaseURL.REGISTRATION_URl)
                .setValueName(data.getNameUser())
                .setValueEmail(data.getEmailUser())
                .setValuePassword(data.getPasswordUser(5))
                .clickRegister()
                .checkPasswordError();
    }
}