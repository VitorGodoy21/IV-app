package br.com.appiv.iv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Date;

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
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                String validacao = "";
                validacao += etDataFatura.getText().toString().charAt((etDataFatura.getText().toString().length()) - 1);
                if(!validacaoDataFatura(validacao) && !validacaão.equals("/")) {

                    validacao = etDataFatura.getText().toString().replace(validacao, " ");
                    etDataFatura.setText(validacao);
                }
                String barra = "";
                if(count==2) {

                    barra = etDataFatura.getText().toString() + "/";
                    etDataFatura.setText(barra);
                    etDataFatura.setSelection(3);
                }

                if(count==5)
                    etSenha.requestFocus();
            }

        });
    }

    private void inserirConta(){

        br.com.appiv.iv.controller.Cadastro cadastro = new br.com.appiv.iv.controller.Cadastro();
        int intSenha = Integer.parseInt(etSenha.getText().toString());
        double dblSaldo = Double.parseDouble(etSaldo.getText().toString());
        Date data;
        data = Date.valueOf(etDataFatura.getText().toString());
        boolean cadastrou = cadastro.inserirConta(this,
                etNomeConta.getText().toString(),
                intSenha,
                dblSaldo,
                data
        );

        if(cadastrou){

            //show de bola...
            //Leva pra outra tela
        }else{

            //ferrou
        }
    }

    private boolean validacaoDataFatura(String s) {

        if(s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") ||
           s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("/")  ) {
            return true;
        }

        return false;

    }

}
