package site.stellarburgers.nomoreparties.respons.user;

import io.restassured.response.ValidatableResponse;
import site.stellarburgers.nomoreparties.respons.BaseSpecForRequest;

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