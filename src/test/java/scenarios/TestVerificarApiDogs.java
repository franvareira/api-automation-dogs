package scenarios;

import org.junit.jupiter.api.Test;
import services.GetListAllDogs;

public class TestVerificarApiDogs {

    @Test
    public void validarListAllDogs(){

        GetListAllDogs.validarListAll();
    }
}
