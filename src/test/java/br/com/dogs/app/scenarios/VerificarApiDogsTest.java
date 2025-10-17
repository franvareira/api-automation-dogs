package br.com.dogs.app.scenarios;

import br.com.dogs.app.services.GetListAllDogs;
import org.junit.jupiter.api.Test;


public class VerificarApiDogsTest {


 @Test
    public void validarListAllDogs(){

        GetListAllDogs.validarListAll();
    }
}
