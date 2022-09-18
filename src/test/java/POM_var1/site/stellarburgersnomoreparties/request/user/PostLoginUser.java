package POM_var1.site.stellarburgersnomoreparties.request.user;

import POM_var1.site.stellarburgersnomoreparties.request.model.User;
import io.restassured.response.ValidatableResponse;
import POM_var1.site.stellarburgersnomoreparties.request.BaseSpecForRequest;

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