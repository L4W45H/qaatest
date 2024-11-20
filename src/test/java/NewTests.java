import controllers.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import models.posts.Posts;
import models.users.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.*;
import java.io.File;
import java.util.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import static utils.Utils.*;

public class NewTests extends BaseTest {

    @Test(description = "Get all posts. Verify HTTP response status code and content type.    /posts  200      ")
    public void test1() {
        postsController.rBase(Map.of(),"/posts",200);

    }

    @Test(description = "Get all comments and verify the response charset.    /comments   200   ")
    public void test2() {
        commentsController.rBase(Map.of(),"/comments",200)
                .contentType(containsString("charset=utf-8"))
                .header("Content-Type", containsString("charset=utf-8"));

    }

    @Test(description = "Get the third album (path parameter) and verify the content length.  /albums     200     ")
    public void test3() {
        AlbumsControllers albumsControllers = new AlbumsControllers();
        albumsControllers.getAlbumsPP("/posts",200,3)
                .header("Content-Length", notNullValue());
    }

    @Test(description = "Get all photos and verify that the content length header is absent in response.  /photos     200     ")
    public void test4() {
        photosControllers.rBase(Map.of(),"/photos",200).header("Content-Length", nullValue());
    }

    @Test(description = "Verify response time for photos, endpoint is less than 10 seconds.   /photos     200  ")
    public void test5() {
        albumsControllers.rBase(Map.of(),"/photos",200)
                .time(lessThan(10000L));
    }

    @Test(description = "Get all users. Verify HTTP response status code. Verify the 5th user geo coordinates.    /users  200   ")
    public void test6() {
        UserResponse[] test6 = userControllers.rBase(Map.of(),"/users",200)
                .extract()
                .as(UserResponse[].class);
        UserResponse useresp = Arrays.stream(test6)
                .filter(userid -> userid.getId() == 5).findFirst().get();
        assertNotNull(useresp.getAddress().getGeo().getLat());
        assertNotNull(useresp.getAddress().getGeo().getLng());
    }

    @Test(description = "Get a non-existing album. Verify HTTP response status code.  /albums     404    ")
    public void test7() {
        Albums[] getAlbums = albumsControllers.rBase(Map.of(),"/albums",200)
                .extract()
                .as(Albums[].class);
        Integer indexn = getAlbums.length + 1;
        albumsControllers.getAlbumsPP("/albums",404,indexn);
    }

    @Test(description = "Verify the HTTP status code and completion status of the 10th task.  /todos  200     ")
    public void test8() {
        Todos[] test8 = todosControllers.rBase(Map.of(),"/todos",200)
                .extract()
                .as(Todos[].class);
        Todos completionv = Arrays.stream(test8).filter(userid -> userid.getId() == 10).findFirst().get();
        assertTrue(completionv.getCompleted());
    }


    @Test(description = "Get the user by street name. Verify HTTP status code. Verify the street field of the returned user record.  /users   200    ")
    public void test9() {
        String street = "Victor Plains";
        Map<String, Object> sStreet = Map.of("address.street", street);
        UserResponse[] test9 = userControllers.rBase(sStreet,"/users",200)
                .extract()
                .as(UserResponse[].class);
        UserResponse useresp2 = Arrays.stream(test9).findFirst().get();
        assertEquals(useresp2.getAddress().getStreet(), street);
    }

    @Test(description = "Get all users without the third one excluded by name. Verify HTTP response status code. Verify that the third user is not present in the response.  /users   200 ")
    public void test10() {
        String name1 = "Clementine Bauch";
        Map<String, Object> sStreet = Map.of("name_ne", name1);
        UserResponse[] test10 = userControllers.rBase(sStreet,"/users",200)
                .extract()
                .as(UserResponse[].class);
     Boolean exist = Arrays.stream(test10).anyMatch(user -> user.getName().equals(name1));
        assertFalse(exist);
    }

    @Test(description = "Get comments with posted sorted in descending order. Verify HTTP response status code. Verify that records are sorted in response.  /comments    200    ")
    public void test11() {
        Comments[] getComments = commentsController.rBase(Map.of(),"/comments",200)
                .extract()
                .as(Comments[].class);
        int i = 1;
        for (Comments sort : getComments) {
            assertEquals(sort.getId(), i);
            i++;
        }
    }

    @Test(description = "Get photos from the third album. Verify HTTP response status code. Verify that only photos from the third album are returned.   /photos  200     ", dataProvider = "dataProv")

    public void test12(Integer album3) {
        Map<String, Object> sPhotos = Map.of("albumId", album3);
        Photos[] test12 = photosControllers.rBase(sPhotos,"/photos",200)
                .extract()
                .as(Photos[].class);
        Boolean exist = Arrays.stream(test12).allMatch(user -> Objects.equals(user.getAlbumId(), album3));
        assertTrue(exist);
    }

    @DataProvider
    public Integer[] dataProv() {
        return new Integer[]{1, 2, 3};
    }

    @Test(description = "Get the user by city name. Verify HTTP response status code. Verify user with the proper city is returned.  /users   200     ")

    public void test13() {
        String city = "Howemouth";
        Map<String, Object> sCity = Map.of("address.city", city);
        UserResponse[] test9 = userControllers.rBase(sCity,"/users",200)
                .extract()
                .as(UserResponse[].class);
        UserResponse useresp2 = Arrays.stream(test9).findFirst().get();
        assertEquals(useresp2.getAddress().getCity(), city);
    }

    @Test(description = "Get only the first 10 posts. Verify HTTP response status code. Verify that only the first posts are returned.   /posts   200    ")
    public void test14() {
        Map<String, Object> postMap = Map.of("_limit", 10);
        Posts[] test14 = postsController.rBase(postMap,"/posts",200)
                .extract()
                .as(Posts[].class);
        Arrays.stream(test14).forEach(post -> assertTrue(post.getId() <= 10));
        assertEquals(test14.length, 10);
    }

    @Test(description = "Get posts with id = 55 and id = 60. Verify HTTP response status code. Verify the id values of returned records. /posts   200")
    public void test15() {
        Integer id1 = 55;
        Integer id2 = 60;
        Posts[] test15 = postsController.sPosts(id1, id2)
                .extract()
                .as(Posts[].class);
        Posts postid1 = Arrays.stream(test15).filter(post -> post.getId() == id1).findFirst().orElse(null);
        Posts postid2 = Arrays.stream(test15).filter(post -> post.getId() == id2).findFirst().orElse(null);
        assertNotNull(postid1);
        assertNotNull(postid2);
        assertEquals(postid1.getId(), id1);
        assertEquals(postid2.getId(), id2);

    }

    @Test(description = "Get photos from the first album in a range from the 20th to the 25th. Verify HTTP response status code. Verify returned album and photo ids.    /photos  200")
    public void test16() {
        Map<String, Object> postMap = Map.of("_start", 19, "_end", 25);
        Albums[] test16 = albumsControllers.rBase(postMap,"/posts",200)
                .extract()
                .as(Albums[].class);
        boolean albumId = Arrays.stream(test16).allMatch(album -> album.getId() > 19 && album.getId() <= 25);
        assertTrue(albumId, "range is not correct");
    }

    @Test(description = "Get the tenth user. Verify HTTP response status code. Verify response against JSON schema.  /users   200     ")
    public void test17() {
        Map<String, Object> sUsers = Map.of("id", 10);
        UserResponse[] test17 = userControllers.rBase(sUsers,"/users",200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "/src/test/resources/schema.json")))
                .extract()
                .as(UserResponse[].class);
    }

    @Test(description = "Create an already existing comment entity. Verify HTTP response status code.    /comments    500     Comment entity with the same id should created as a precondition for the test")
    public void test18() {
        Comments sComments = new Comments();
        sComments.setEmail("testemail");
        sComments.setBody("testbody");
        sComments.setName("testname");
        ValidatableResponse test18 = commentsController.postComments(sComments);
    }

    @Test(description = "Create a post. Verify HTTP response status code. /664/posts 401")
    public void test19() {
         Posts bodyPost = grPost(grBody(),grTitle());
        postsController.createPosts("/664/posts",bodyPost,401);
    }

    @Test(description = "Register a new user. Verify HTTP response status code. Verify that the access token is present in the response body. /register 201")
    public void test20() {
        String randEmail = grEmail();
        String requestBody = String.format("{ \"email\": \"%s\", \"password\": \"Password123\" }",randEmail);
     Response getResponse =  given()
             .spec(userControllers.reqSpec())
                .body(requestBody)
                .post("/register");
     getResponse
                .then()
             .spec(userControllers.resSpec(HttpStatus.SC_CREATED))
                .body("accessToken", notNullValue());
    }

    @Test(description = "Create a post by adding an access token in the header. Verify HTTP response status code. Verify post is created. /664/posts 201",
    dependsOnMethods = {"test20"})
    public void test21() {
        String randTitle = grTitle();
        String randBody = grBody();
        Posts bodyPost = grPost(randBody,randTitle);
      Posts createdPost = postsController.createTokenPosts(bodyPost,token)
                .extract()
                .as(Posts.class);
            assertNotNull(createdPost);
            assertEquals(createdPost.getTitle(), randTitle);
            assertEquals(createdPost.getBody(), randBody);
    }

    @Test(description = "Create a post by adding an access token in the header. Verify HTTP response status code. Verify post is created. /664/posts 201",
            dependsOnMethods = {"test20"})
    public void test22() {
        String randTitle = grTitle();
        String randBody = grBody();
        Posts bodyPost = grPost(randBody,randTitle);
        Posts createdPost = given()
                .spec(postsController.reqSpec())
                .header("Authorization", "Bearer " + token).body(bodyPost)
                .post("/664/posts")
                .then()
                .spec(postsController.resSpec(HttpStatus.SC_CREATED))
                .extract()
                .as(Posts.class);
        assertNotNull(createdPost);
        assertEquals(createdPost.getTitle(), randTitle);
        assertEquals(createdPost.getBody(), randBody);
    }


    @Test(description = "Create a post entity and verify that the entity is created. Verify HTTP response status code. Use JSON in the body. /posts 201")
    public void test23() {
        String randTitle = grTitle();
        String randBody = grBody();
        Posts bodyPost = grPost(randBody,randTitle);
        Posts createdPost = postsController.createPosts("/posts",bodyPost,201)
            .extract()
            .as(Posts.class);
    assertNotNull(createdPost);
    assertEquals(createdPost.getTitle(), randTitle);
    assertEquals(createdPost.getBody(), randBody);
    }

    @Test(description = "Update non-existing entity. Verify HTTP response status code. /posts 404")
    public void test24() {
        String randTitle = grTitle();
        String randBody = grBody();
        Map<String, Object> postMap = Map.of();
        Posts[] test24 = postsController.rBase(postMap,"/posts",200)
                .extract()
                .as(Posts[].class);
        Posts bodyPost = grPost(randBody,randTitle);
        Integer indexn = test24[test24.length-1].getId()+Integer.parseInt(RandomStringUtils.randomNumeric(3));
        postsController.updatePosts("/posts",bodyPost,404,indexn);
    }

    @Test(description = "Create a post entity and update the created entity. Verify the HTTP response status code and verify that the entity is updated. /posts 200")
    public void test25() {
        String randTitle = grTitle();
        String randBody = grBody();
        Posts bodyPost = grPost(randBody,randTitle);
        Posts createdPost = postsController.createPosts("/posts",bodyPost,201)
               .extract()
               .as(Posts.class);
       assertNotNull(createdPost);
       assertEquals(createdPost.getTitle(), randTitle);
       assertEquals(createdPost.getBody(), randBody);
       bodyPost.setId(createdPost.getId());
       //assertEquals(bodyPost,createdPost);
       assertEquals(bodyPost.hashCode(),createdPost.hashCode());

        String randTitleNew = grTitle();
        String randBodyNew = grBody();
        Posts bodyPostNew = new Posts();
        bodyPostNew.setBody(randBodyNew);
        bodyPostNew.setTitle(randTitleNew);
        Posts updatedPost = postsController.updatePosts("/posts",bodyPostNew,200,createdPost.getId())
               .extract()
               .as(Posts.class);
       assertNotNull(updatedPost);
       assertEquals(updatedPost.getTitle(), randTitleNew);
       assertEquals(updatedPost.getBody(), randBodyNew);
    }

    @Test(description = "Delete non-existing post entity. Verify HTTP response status code. /posts 404")
    public void test26() {
        Map<String, Object> postMap = Map.of();
        Posts[] test24 = postsController.rBase(postMap,"/posts",200)
                .extract()
                .as(Posts[].class);
        Integer indexn = test24[test24.length-1].getId()+Integer.parseInt(RandomStringUtils.randomNumeric(3));
          postsController.deletePosts("/posts",404,indexn);
    }

}