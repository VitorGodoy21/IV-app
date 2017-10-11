package br.com.appiv.iv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    private EditText etNomeConta;
    private EditText etSaldo;
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
        etSenha = (EditText) findViewById(R.id.et_senha);
        btnCriarNovaConta = (Button) findViewById(R.id.btn_confirmar);
    }

    private void acaoElementos() {

    }
}
