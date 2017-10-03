package br.com.appiv.iv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Date;

public class Cadastro extends AppCompatActivity {

    private EditText nomeConta;
    private EditText saldo;
    private EditText dataFatura;
    private EditText senha;
    private Button criarNovaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        criarElementos();
        //Ação de criar conta
        criarNovaConta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                inserirConta();
            }
        });
    }

    private void inserirConta(){

        br.com.appiv.iv.controller.Cadastro cadastro = new br.com.appiv.iv.controller.Cadastro();
        int intSenha = Integer.parseInt(senha.getText().toString());
        double dblSaldo = Double.parseDouble(saldo.getText().toString());
        Date data;
        boolean cadastrou = cadastro.inserirConta(this,
                nomeConta.getText().toString(),
                intSenha,
                dblSaldo,
                data = Date.valueOf(dataFatura.getText().toString())
        );

        if(cadastrou){

            //show de bola...
            //Leva pra outra tela
        }else{

            //ferrou
        }
    }

    private void criarElementos(){

        nomeConta = (EditText) findViewById(R.id.et_nomeConta);
        saldo = (EditText) findViewById(R.id.et_saldo);
        dataFatura = (EditText) findViewById(R.id.et_dataFatura);
        senha = (EditText) findViewById(R.id.et_senha);
        criarNovaConta = (Button) findViewById(R.id.btn_confirmar);
    }
}
