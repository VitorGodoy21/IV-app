package br.com.appiv.iv;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    private EditText etNomeConta;
    private EditText etSaldo;
    private EditText etSenha;
    private EditText etConfirmarSenha;
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
        etConfirmarSenha = (EditText) findViewById(R.id.et_confirmarSenha);
        btnCriarNovaConta = (Button) findViewById(R.id.btn_confirmar);
    }

    private void acaoElementos() {

        btnCriarNovaConta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Context context = getBaseContext();
                if(validarCamposPreenchidos())
                    if(validarSaldo())
                        if(validarSenha())
                            inserirConta();
            }

        });

        etSaldo.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                int i;
                for(i=0; i < s.toString().length(); i++) {
                    char t = s.toString().charAt(i);
                    if (s.toString().charAt(i) == '.' && count != 0) {
                        if (i+2 < s.toString().length() ) {
                            //String validacao = etSaldo.getText().toString();
                            //validacao += etSaldo.getText().toString().charAt(etSaldo.length() - 1);
                            //etSaldo.getText().toString().replace(validacao, "");
                            //etSaldo.setText(validacao);
                            etSenha.requestFocus();
                        }
                    }
                }
            }

        });


    }

    private boolean validarSenha(){

        if(etSenha.getText().toString().length() <= 3 ) {
            br.com.appiv.iv.tools.Mensagem.mostrarAlert(br.com.appiv.iv.constants.Cadastro.ERRO_TAMANHO_SENHA, this);
            return false;
        }
        if(!etSenha.getText().toString().equals(etConfirmarSenha.getText().toString())) {
            br.com.appiv.iv.tools.Mensagem.mostrarAlert(br.com.appiv.iv.constants.Cadastro.ERRO_CONFIRMAR_SENHA, this);
            return false;
        }

        return true;
    }

    private boolean validarCamposPreenchidos(){
        StringBuilder erro = new StringBuilder();
        erro.append(br.com.appiv.iv.constants.Cadastro.ERRO_CAMPOS_NAO_PREENCHIDOS);
        boolean erroBool = false;
        if(etNomeConta.getText().toString().length() == 0) {
            erro.append(br.com.appiv.iv.constants.Cadastro.NOMECONTA);
            erroBool = true;
        }

        if(etSaldo.getText().toString().length() == 0) {
            erro.append(br.com.appiv.iv.constants.Cadastro.SALDO);
            erroBool = true;
        }

        if(etSenha.getText().toString().length() == 0 ) {
            erro.append(br.com.appiv.iv.constants.Cadastro.SENHA);
            erroBool = true;
        }

        if(etConfirmarSenha.getText().toString().length() == 0 ) {
            erro.append(br.com.appiv.iv.constants.Cadastro.CONFIRMARSENHA);
            erroBool = true;
        }

        if(erroBool) {
            br.com.appiv.iv.tools.Mensagem.mostrarAlert(erro.toString(), this);
            return  false;
        }

        return true;
    }

    private boolean validarSaldo(){
        String saldo = etSaldo.getText().toString();
        int i, ponto = 0;
        boolean temPonto = false;

        if(saldo.charAt(0) == '.') {
            br.com.appiv.iv.tools.Mensagem.mostrarAlert(br.com.appiv.iv.constants.Cadastro.SALDO_INVALIDO, this);
            return false;
        }
        else{
            for (i = 0; i < saldo.length(); i++) {
                if (saldo.charAt(i) == '.') {
                    ponto = i;
                    temPonto = true;
                }
            }

            if(!temPonto) {
                br.com.appiv.iv.tools.Mensagem.mostrarAlert(br.com.appiv.iv.constants.Cadastro.SALDO_INVALIDO, this);
                return false;
            }

            if((saldo.length() - 3) != ponto ) {
                br.com.appiv.iv.tools.Mensagem.mostrarAlert(br.com.appiv.iv.constants.Cadastro.SALDO_INVALIDO, this);
                return false;
            }
        }


        return true;
    }

    private void inserirConta(){

        br.com.appiv.iv.controller.Cadastro controller = new br.com.appiv.iv.controller.Cadastro();
        int intSenha = Integer.parseInt(etSenha.getText().toString());
        double dblSaldo = Double.parseDouble(etSaldo.getText().toString());
        controller.inserirConta(this,
                etNomeConta.getText().toString(),
                intSenha,
                dblSaldo);
    }

/*    private void testeBuscarConta(){

        br.com.appiv.iv.teste.Conta teste = new br.com.appiv.iv.teste.Conta();
        teste.buscarConta(this);
    }*/

/*    private void testeAtualizar(){

        br.com.appiv.iv.controller.Ganho controller = new br.com.appiv.iv.controller.Ganho();
        controller.atualizar(this,9,"","",5,-1,"");
        br.com.appiv.iv.teste.Ganho teste = new br.com.appiv.iv.teste.Ganho();
        teste.buscar(this);
    }*/

    /*private void testeDeletar(){

        br.com.appiv.iv.controller.Ganho controller = new br.com.appiv.iv.controller.Ganho();
        controller.deletar(this,9);
    }*/

/*    private void testeBuscarGanho(){

        br.com.appiv.iv.teste.Ganho teste = new br.com.appiv.iv.teste.Ganho();
        teste.buscar(this);
    }*/

/*    private void testeInserirGanho(){

        br.com.appiv.iv.controller.Ganho controller = new br.com.appiv.iv.controller.Ganho();
        controller.inserir(this,
                "teste30",
                "teste30/10",
                10.0,
                20.0,
                0,
                "30/10/2017");
    }*/

/*    private void testeBuscarGanho(){

        br.com.appiv.iv.teste.Ganho teste = new br.com.appiv.iv.teste.Ganho();
        teste.buscar(this,"bico","trabalhei por fora",20.0,10.0,0,"18/10/2017");
    }*/
}
















