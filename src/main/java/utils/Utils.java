package utils;

import com.github.javafaker.Faker;
import models.posts.Posts;

public class Utils {
    private static Faker faker = new Faker();

    public static String grEmail () {
        return faker.internet().emailAddress();
    }
    public static String grTitle () {
        return faker.harryPotter().location();
    }
    public static String grBody () {
        return faker.harryPotter().quote();
    }
    public static Posts grPost (String grBody, String grTitle) {
        Posts bodyPost = new Posts();
        bodyPost.setBody(grBody);
        bodyPost.setTitle(grTitle);
        return bodyPost;
    }
}
