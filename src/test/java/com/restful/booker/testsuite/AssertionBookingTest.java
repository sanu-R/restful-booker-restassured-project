package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;

public class AssertionBookingTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        response = given()
                .when()
                .get("/booking/1")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        //verify the firstName
        response.body("firstname", hasItem("Jim"));
    }

    @Test
    public void test002() {
        //verify the lastname
        response.body("lastname", hasItem("Smith"));
    }

    //verify the totalprice
    @Test
    public void test003() {
        response.body("totalprice", hasItem(596));
    }

    @Test
    public void test004() {
        response.body("depositpaid", hasKey("true"));
    }

    @Test
    public void test005() {
        response.body("additionalneeds",hasItem("Breakfast"));
    }

}
