package br.com.dogs.app.services;

import br.com.dogs.app.support.utils.Endpoints;
import br.com.dogs.app.support.utils.FileOperations;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static javax.swing.UIManager.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetListDogsRound extends Endpoints {


    public static void validarListDogsImage() {
        try {
            Response responseRest =
                    given()
                            .filter(new AllureRestAssured())
                            .log().all()
                    .when()
                            .get(BASE_URI_PARAM + PATH_ROUD)
                    .then()
                            .log().all()
                            .assertThat()
                            .statusCode(200)
                            .extract().response();

            assertThat(responseRest.path("status"), is("success"));
            assertThat(responseRest.path("message"), notNullValue());
            assertThat(responseRest.path("message[0]"), is("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}