import controllers.*;
import io.restassured.response.Response;
import models.users.UserResponse;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import static utils.Utils.grEmail;

public class BaseTest {
    String token;
    String email;

    UserControllers userControllers = new UserControllers();
    PostControllers postsController = new PostControllers();
    CommentsControllers commentsController = new CommentsControllers();
    PhotosControllers photosControllers = new PhotosControllers();
    AlbumsControllers albumsControllers = new AlbumsControllers();
    TodosControllers todosControllers = new TodosControllers();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite () throws IOException {

        Files.walk(Path.of(System.getProperty("user.dir")+"/allure-results"))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        email = grEmail();
        String requestBody = String.format("{ \"email\": \"%s\", \"password\": \"Password123\" }",email);
        Response getResponse =  given()
                .spec(userControllers.reqSpec())
                .body(requestBody)
                .post("/register");
        token = getResponse
                .jsonPath()
                .get("accessToken");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite () {
        UserControllers userControllers = new UserControllers();
        UserResponse[] allUsers = userControllers.rBase(Map.of(),"/users",200)
                .extract()
                .as(UserResponse[].class);
        Integer id = Arrays.stream(allUsers).filter(user->user.getEmail().equals(email)).findFirst().get().getId();
        given()
                .spec(userControllers.reqSpec())
                .pathParam("id",id)
                .delete("/users/{id}")
                .then()
                .log()
                .all();

        UserResponse[] allUsers2 = userControllers.rBase(Map.of(),"/users",200)
                .extract()
                .as(UserResponse[].class);
        assertTrue(Arrays.stream(allUsers2).noneMatch(user->user.getId()==id));


    }
}
