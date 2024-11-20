package controllers;

import io.restassured.filter.log.LogDetail;
import io.restassured.response.ValidatableResponse;
import models.users.Comments;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommentsControllers extends BaseController {

    public ValidatableResponse postComments (Comments body) {

        return given()
                .spec(reqSpec())
                .body(body)
                .post("/comments")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);

    }

}
