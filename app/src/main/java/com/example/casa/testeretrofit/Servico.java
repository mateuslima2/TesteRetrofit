package com.example.casa.testeretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

import com.example.casa.testeretrofit.modelos.Catalogo;

/**
 * Created by Casa on 13/11/2016.
 */

public interface Servico {
    public  final static String BASE_URL="https://www.udacity.com/public-api/v0/";

    @GET("courses")
    Call<Catalogo> listaCatalogo();
}
