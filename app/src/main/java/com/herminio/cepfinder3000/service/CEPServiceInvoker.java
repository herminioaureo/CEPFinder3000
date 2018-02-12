package com.herminio.cepfinder3000.service;

import android.util.Log;

import com.herminio.cepfinder3000.model.CepResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hermi on 12/02/2018.
 */

public class CEPServiceInvoker {

    CepResponse serviceResponse = new CepResponse();

    public CepResponse findCep(String cep) {

        Call<CepResponse> call = new RetrofitConfigurator().getCEPService().findCEP(cep);
        call.enqueue(new Callback<CepResponse>() {
            @Override
            public void onResponse(Call<CepResponse> call, Response<CepResponse> response) {
                serviceResponse = response.body();
            }

            @Override
            public void onFailure(Call<CepResponse> call, Throwable t) {
                Log.e("CEPService   ", "Erro ao buscar o cep:" + t.getMessage());
            }
        });

        return serviceResponse;
    }
}
