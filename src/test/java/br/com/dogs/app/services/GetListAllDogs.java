package br.com.dogs.app.services;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import br.com.dogs.app.support.utils.Endpoints;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetListAllDogs extends Endpoints {


    public static void validarListAll() {
        try {
            Response responseRest =

                    given()
                            .filter(new AllureRestAssured())
                            .log().all()
                            .when()
                            .get(BASE_URI + PATH_ALL)
                            .then()
                            .log().all()
                            .assertThat()
                            .statusCode(200)
                            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/schemaValidator.json"))
                            .extract().response();


            assertThat(responseRest.path("status"), equalTo("success"));
            assertNotNull(responseRest.path("message.bulldog"));

            List<String> bulldogSubracas = responseRest.path("message.bulldog");
            assertThat(bulldogSubracas, hasItems("boston", "english", "french"));

            List<String> affenpinscher = responseRest.path("message.affenpinscher");
            assertThat(affenpinscher, empty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
