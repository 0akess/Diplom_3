package POM_var2.tests;

import POM_var2.stellarburgersnomoreparties.data.tests.GetUserData;
import POM_var2.stellarburgersnomoreparties.web_elements.pages.RegistrationPage;
import POM_var2.stellarburgersnomoreparties.request.model.User;
import POM_var2.stellarburgersnomoreparties.request.user.DeleteUser;
import POM_var2.stellarburgersnomoreparties.request.user.PostLoginUser;
import POM_var2.stellarburgersnomoreparties.resources.BaseURL;
import com.codeborne.selenide.Selenide;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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