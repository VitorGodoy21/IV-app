package br.com.appiv.iv.controller;

import android.content.Context;
import java.sql.Date;
import br.com.appiv.iv.model.Conta;

public class Cadastro {

    public boolean inserirConta(Context context,
                                String nomeConta,
                                int senha,
                                double saldo,
                                Date dataFatura){

        Conta conta = new Conta(nomeConta,dataFatura,saldo,senha);
        br.com.appiv.iv.dao.Cadastro cadastro = new br.com.appiv.iv.dao.Cadastro(context);
        return cadastro.inserirConta(conta);
    }
}
