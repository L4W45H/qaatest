package controllers;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class AlbumsControllers extends BaseController {

    public ValidatableResponse getAlbumsPP (String endpoint, int hStatus, Object path) {
        return given()
                .spec(reqSpec())
                .pathParam("id", path)
                .get(endpoint + "/{id}")
                .then()
                .spec(resSpec(hStatus));
    }
}
