package controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import utils.AllureRestAssured;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BaseController {

    public RequestSpecification reqSpec () {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(3000)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public ResponseSpecification resSpec (int hStatus) {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(hStatus)
                //.expectContentType(ContentType.JSON)
                .build();


    }

    public ResponseSpecification resSpec () {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();


    }

    public ValidatableResponse rBase (Map <String, Object> qParams, String endpoint, int hStatus) {
        return given()
                .spec(reqSpec())
                .queryParams(qParams)
                .get(endpoint)
                .then()
                .spec(resSpec(hStatus));
    }
}
