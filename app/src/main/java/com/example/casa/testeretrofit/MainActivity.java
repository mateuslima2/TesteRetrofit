package com.example.casa.testeretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;

import com.example.casa.testeretrofit.modelos.Catalogo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ERRO QUERIDO" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Servico.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Servico service = retrofit.create(Servico.class);
        Call <Catalogo> pegarCatalogo = service.listaCatalogo();

// parte que verifica se foi com sucesso

        pegarCatalogo.enqueue(new Callback<Catalogo>() {
            @Override
            public void onResponse(Call<Catalogo> call, Response<Catalogo> response) {
                if(!response.isSuccess()){
                    Log.i("TAG", "ERRO QUERIDO: " + response.code());
                }else{
                    Catalogo catalogo = response.body();
                }
            }
            @Override
            public void onFailure(Call<Catalogo> call, Throwable t) {
                Log.e(TAG, "ERRO " + t.getMessage());
            }
        });



    }
}
