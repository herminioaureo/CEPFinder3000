package com.herminio.cepfinder3000.service;

import com.herminio.cepfinder3000.model.CepResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by herminio on 12/02/2018.
 * Interface que ira expor o metodo para acesso ao servico de consulta de CEP
 */

public interface CEPService {

    @GET("{cep}/json")
    public Call<CepResponse> findCEP(@Path("cep") String cep);

}
