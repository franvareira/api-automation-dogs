package br.com.dogs.app.services;
import io.restassured.response.Response;
import br.com.dogs.app.support.utils.Endpoints;

import static io.restassured.RestAssured.*;

public class GetListAllDogs extends Endpoints {


    public static void validarListAll(){

        Response reponseRest =

                given ()
                        .log().all()
                 .when()
                        .get(BASE_URI + PATH_ALL)
                 .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();



    }


}
