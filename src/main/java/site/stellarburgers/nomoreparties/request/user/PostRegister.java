package site.stellarburgers.nomoreparties.request.user;

import io.restassured.response.ValidatableResponse;
import site.stellarburgers.nomoreparties.request.BaseSpecForRequest;
import site.stellarburgers.nomoreparties.request.model.User;

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