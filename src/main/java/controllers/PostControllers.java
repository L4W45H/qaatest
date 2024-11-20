package controllers;

import io.restassured.response.ValidatableResponse;
import models.posts.Posts;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostControllers extends BaseController {

    public ValidatableResponse sPosts(Integer id1, Integer id2) {
        return given()
                .spec(reqSpec())
                .queryParam("id", id1)
                .queryParam("id", id2)
                .get("/posts")
                .then()
                .spec(resSpec());
    }

    public ValidatableResponse createPosts (String endpoint, Posts bodyPost, int hStatus) {
        return given()
                .spec(reqSpec())
                .body(bodyPost)
                .post(endpoint)
                .then()
                .spec(resSpec(hStatus));
    }
    public ValidatableResponse updatePosts (String endpoint, Posts bodyPost, int hStatus, Object path) {
        return given()
                .spec(reqSpec())
                .body(bodyPost)
                .pathParam("id", path)
                .put(endpoint+"/{id}")
                .then()
                .spec(resSpec(hStatus));
    }
    public void deletePosts (String endpoint,int hStatus, Object path) {
         given()
                .spec(reqSpec())
                .pathParam("id", path)
                .delete(endpoint+"/{id}")
                .then()
                .spec(resSpec(hStatus));
    }
    public ValidatableResponse createTokenPosts (Posts bodyPost, String token) {
        return given()
                .spec(reqSpec())
                .body(bodyPost)
                .header("Authorization", "Bearer " + token)
                .post("/664/posts")
                .then()
                .spec(resSpec(201));
    }
}
