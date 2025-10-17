package br.com.dogs.app.scenarios;

import br.com.dogs.app.services.GetListAllDogs;
import br.com.dogs.app.services.GetListDogParam;
import br.com.dogs.app.services.GetListDogsRandom;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Test automation API Dogs")
public class VerificarApiDogsTest {

    @Test
    @Description("Validar o retorno de toda lista de Dogs")
    @DisplayName("ValidarListAll")
    public void validarListAllDogs(){

        GetListAllDogs.validarListAll();
    }

    @Test
    @Description("Validar o retorno da lista randomica de Dogs")
    @DisplayName("ValidarListRandom")
    public void validarListRandomDogs(){

        GetListDogsRandom.validarListRandom();
    }

    @Test
    @Description("Validar o retorno de racas cadastradas randomicamente")
    @DisplayName("ValidarListRacaRandom")
    public void validarListRacaRandomDogs(){

        GetListDogParam.validarListRaca();
    }
}
