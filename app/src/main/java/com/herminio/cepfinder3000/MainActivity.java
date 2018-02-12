package com.herminio.cepfinder3000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.herminio.cepfinder3000.model.CepResponse;
import com.herminio.cepfinder3000.service.CEPServiceInvoker;
import com.herminio.cepfinder3000.service.RetrofitConfigurator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Classe principal do projeto CepFinder3000
 * Para esse projeto foi utilizado como exemplo o material de Matheus Castiglioni disponivel<br>
 * no site https://medium.com/collabcode/consumindo-web-service-no-android-com-retrofit-a261bb385b21
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cep = findViewById(R.id.etMain_cep);
        final TextView logradouro = findViewById(R.id.txtLogradouro);
        final TextView complemento = findViewById(R.id.txtComplemento);
        final TextView bairro = findViewById(R.id.txtBairro);
        final TextView localidade = findViewById(R.id.txtLocalidade);
        final TextView uf = findViewById(R.id.txtUF);

        Button btnBuscarCep = findViewById(R.id.btnMain_buscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (CepUtil.isCepValid(cep.getText().toString())) {

                    Call<CepResponse> call = new RetrofitConfigurator().getCEPService().findCEP(cep.getText().toString());
                    call.enqueue(new Callback<CepResponse>() {
                        @Override
                        public void onResponse(Call<CepResponse> call, Response<CepResponse> response) {
                            CepResponse cepResponse = response.body();

                            if (!CepUtil.isCepNotExits(cepResponse)) {
                                logradouro.setText(cepResponse.toString());
                            } else {
                                logradouro.setText("");
                                Toast.makeText(getApplicationContext(), "CEP inexistente", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CepResponse> call, Throwable t) {
                            Log.e("CEPService   ", "Erro ao buscar o cep:" + t.getMessage());
                            logradouro.setText("CEP inexistente!");
                            Toast.makeText(getApplicationContext(), "CEP inexistente", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    logradouro.setText("");
                    Toast.makeText(getApplicationContext(), "CEP invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
