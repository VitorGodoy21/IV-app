package br.com.appiv.iv;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Date;
import br.com.appiv.iv.tools.Data;

public class Cadastro extends AppCompatActivity implements Mensagem {

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

                if(validarInsercao()){

                    inserirConta();
                }
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
                    mostrarMensagem(br.com.appiv.iv.constants.Cadastro.dataInvalida);
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
        Data data = new Data();
        Date dataFatura = Date.valueOf(data.formatoValido(etDataFatura.getText().toString()));
        boolean cadastrou = cadastro.inserirConta(this,
                etNomeConta.getText().toString(),
                intSenha,
                dblSaldo,
                dataFatura
        );

        if(cadastrou){

            //Redireciona para outra tela
        }else{

            //ferrou
        }
    }

    //Este método é responsável pela verificação final da ação do botão que cadastra uma nova conta
    private boolean validarInsercao(){

        Data data = new Data();
        if(     etNomeConta.getText().toString().equals("") ||
                etSaldo.getText().toString().equals("") ||
                etDataFatura.getText().toString().equals("") ||
                etSenha.getText().toString().equals("")){

            mostrarMensagem(br.com.appiv.iv.constants.Cadastro.camposNulos);
            return false;
        } else if(!data.validarTamanhoData(etDataFatura.getText().toString().length())){

            mostrarMensagem(br.com.appiv.iv.constants.Cadastro.formatoInvalido);
            return false;
        }else {

            return true;
        }
    }

    @Override
    public void mostrarMensagem(String mensagem) {

        AlertDialog.Builder alert = new AlertDialog.Builder(br.com.appiv.iv.Cadastro.this);
        alert.setTitle(br.com.appiv.iv.constants.Cadastro.titulo);
        alert.setMessage(mensagem);
        alert.setPositiveButton(br.com.appiv.iv.constants.Cadastro.botao, null);
        alert.create();
        alert.show();
    }
}
