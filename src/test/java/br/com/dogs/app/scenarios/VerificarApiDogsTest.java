package br.com.dogs.app.scenarios;

import br.com.dogs.app.services.GetListAllDogs;
import br.com.dogs.app.services.GetListDogsRandom;
import org.junit.jupiter.api.Test;


public class VerificarApiDogsTest {


    @Test
    public void validarListAllDogs(){

        GetListAllDogs.validarListAll();
    }

    @Test
    public void validarListRandomDogs(){

        GetListDogsRandom.validarListRandom();
    }
}
