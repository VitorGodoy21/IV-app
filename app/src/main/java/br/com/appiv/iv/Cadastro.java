package br.com.appiv.iv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Date;

import br.com.appiv.iv.complementar.Data;

public class Cadastro extends AppCompatActivity {

    private EditText etNomeConta;
    private EditText etSaldo;
    private EditText etDataFatura;
    private EditText etSenha;
    private Button btnCriarNovaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        criarElementos();
        acaoElementos();

    }

    private void criarElementos(){

        etNomeConta = (EditText) findViewById(R.id.et_nomeConta);
        etSaldo = (EditText) findViewById(R.id.et_saldo);
        etDataFatura = (EditText) findViewById(R.id.et_dataFatura);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btnCriarNovaConta = (Button) findViewById(R.id.btn_confirmar);
    }

    private void acaoElementos() {

        btnCriarNovaConta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                inserirConta();
            }
        });

        etDataFatura.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                Data data = new Data();
                if(!data.validarPreenchimentoData(etDataFatura.getText().toString())){

                    etDataFatura.setText("");
                }

                if(etDataFatura.getText().length() == 2) {

                    if(data.formatarData(etDataFatura.getText().toString(),
                            etDataFatura.getText().toString().length(),
                            count) != null){

                        etDataFatura.setText(data.formatarData(etDataFatura.getText().toString(),
                                etDataFatura.getText().toString().length(),
                                count));
                        etDataFatura.setSelection(3);
                    }else{

                        etDataFatura.setText("");
                    }
                }

                if(etDataFatura.getText().toString().length() == 5)
                    etSenha.requestFocus();
            }

        });
    }

    private void inserirConta(){

        br.com.appiv.iv.controller.Cadastro cadastro = new br.com.appiv.iv.controller.Cadastro();
        int intSenha = Integer.parseInt(etSenha.getText().toString());
        double dblSaldo = Double.parseDouble(etSaldo.getText().toString());
        Date data;
        data = Date.valueOf("2015-03-13");
        boolean cadastrou = cadastro.inserirConta(this,
                etNomeConta.getText().toString(),
                intSenha,
                dblSaldo,
                data
        );

        if(cadastrou){

            //Redireciona para outra tela
        }else{

            //ferrou
        }
    }
}
