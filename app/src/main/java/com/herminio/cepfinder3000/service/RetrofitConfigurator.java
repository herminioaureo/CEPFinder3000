package com.herminio.cepfinder3000.service;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by herminio on 12/02/2018.
 * Classe responsavel por retornar um objeto Retrofit configurado com<br>
 * informacoes do Converter e da URL do serviço
 */

public class RetrofitConfigurator {

    private final static String BASE_URL = "https://viacep.com.br/ws/";

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CEPService getCEPService() {
        return getRetrofit().create(CEPService.class);
    }

}
