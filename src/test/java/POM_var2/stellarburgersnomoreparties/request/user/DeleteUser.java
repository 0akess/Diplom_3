package POM_var2.stellarburgersnomoreparties.request.user;

import POM_var2.stellarburgersnomoreparties.request.BaseSpecForRequest;
import io.restassured.response.ValidatableResponse;

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