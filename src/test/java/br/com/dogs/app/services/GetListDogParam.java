package br.com.dogs.app.services;

import br.com.dogs.app.support.utils.Endpoints;
import br.com.dogs.app.support.utils.FileOperations;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetListDogParam extends Endpoints {

    static String raca = FileOperations.randomRaca();

    public static void validarListRaca() {

        Response responseRest =

                given()
                        .log().all()
                .when()
                        .get(BASE_URI_PARAM + raca + PATH_PARAM)
                .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        assertThat(responseRest.path("status"), is("success"));
        assertThat(responseRest.path("message"), notNullValue());

        String url = responseRest.then().extract().path("message");
        String nomeImagem = url.substring(url.lastIndexOf('/') + 1);
        assertThat((String) responseRest.path("message"), containsString(nomeImagem));

    }
}