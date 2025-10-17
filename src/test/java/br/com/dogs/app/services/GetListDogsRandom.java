package br.com.dogs.app.services;

import br.com.dogs.app.support.utils.Endpoints;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetListDogsRandom extends Endpoints {


    public static void validarListRandom(){

        Response responseRest =

                given ()
                        .log().all()
                .when()
                        .get(BASE_URI + PATH_RANDOM)
                .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();


        assertThat(responseRest.path("status"), is("success"));
        assertThat(responseRest.path("message"), notNullValue());
        assertThat((String) responseRest.path("message"), startsWith("https://images.dog.ceo/"));
        assertThat((String) responseRest.path("message"), endsWith(".jpg"));

        String url = (String) responseRest.path("message");
        assertThat(url, matchesPattern("^https://.*\\.jpg$"));


    }
}
