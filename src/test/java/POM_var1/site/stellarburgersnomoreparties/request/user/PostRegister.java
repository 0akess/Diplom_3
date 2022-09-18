package POM_var1.site.stellarburgersnomoreparties.request.user;

import io.restassured.response.ValidatableResponse;
import POM_var1.site.stellarburgersnomoreparties.request.BaseSpecForRequest;
import POM_var1.site.stellarburgersnomoreparties.request.model.User;

import static io.restassured.RestAssured.given;

public class PostRegister extends BaseSpecForRequest {

    public ValidatableResponse registerUser(User registerUser) {

        return given()
                .spec(baseSpec())
                .and()
                .body(registerUser)
                .when()
                .post("/api/auth/register")
                .then();
    }
}