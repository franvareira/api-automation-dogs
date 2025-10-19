package br.com.dogs.app.services;

import br.com.dogs.app.support.utils.Endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetListDogsRandom extends Endpoints {


    public static void validarListRandom() {
        try {
            Response responseRest =

                    given()
                            .filter(new AllureRestAssured())
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
