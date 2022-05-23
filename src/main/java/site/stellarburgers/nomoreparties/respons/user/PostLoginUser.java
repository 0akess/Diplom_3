package site.stellarburgers.nomoreparties.respons.user;

import io.restassured.response.ValidatableResponse;
import site.stellarburgers.nomoreparties.respons.BaseSpecForRequest;
import site.stellarburgers.nomoreparties.respons.model.User;

import static io.restassured.RestAssured.given;

public class PostLoginUser extends BaseSpecForRequest {

    public ValidatableResponse loginUser(User loginUser) {

        return given()
                .spec(baseSpec())
                .and()
                .body(loginUser)
                .when()
                .post("/api/auth/login")
                .then();
    }
}