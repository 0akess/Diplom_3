package POM_var2.stellarburgersnomoreparties.request.user;

import POM_var2.stellarburgersnomoreparties.request.BaseSpecForRequest;
import POM_var2.stellarburgersnomoreparties.request.model.User;
import io.restassured.response.ValidatableResponse;

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