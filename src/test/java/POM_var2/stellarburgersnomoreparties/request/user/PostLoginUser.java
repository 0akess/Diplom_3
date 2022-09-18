package POM_var2.stellarburgersnomoreparties.request.user;

import POM_var2.stellarburgersnomoreparties.request.BaseSpecForRequest;
import POM_var2.stellarburgersnomoreparties.request.model.User;
import io.restassured.response.ValidatableResponse;

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