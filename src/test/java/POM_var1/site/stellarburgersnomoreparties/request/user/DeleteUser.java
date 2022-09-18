package POM_var1.site.stellarburgersnomoreparties.request.user;

import io.restassured.response.ValidatableResponse;
import POM_var1.site.stellarburgersnomoreparties.request.BaseSpecForRequest;

import static io.restassured.RestAssured.given;

public class DeleteUser extends BaseSpecForRequest {

    public ValidatableResponse deleteUser(String token) {

        return given()
                .spec(baseSpecWithToken(token))
                .and()
                .delete("/api/auth/user")
                .then();
    }
}