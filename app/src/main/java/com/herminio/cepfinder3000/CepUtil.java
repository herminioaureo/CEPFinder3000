package com.herminio.cepfinder3000;

import com.herminio.cepfinder3000.model.CepResponse;

/**
 * Created by herminio on 12/02/2018.
 */

public class CepUtil {

    public static boolean isCepValid(String cep) {
        if (cep != null && cep.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isCepNotExits(CepResponse response) {
        if (response.getLogradouro() == null) {
            return true;
        } else {
            return false;
        }
    }

}
