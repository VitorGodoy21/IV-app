package br.com.appiv.iv.controller;


import android.content.Context;

import br.com.appiv.iv.model.Conta;

public class Home {

    public Home(){


    }

    public Conta buscarConta(Context context){

        br.com.appiv.iv.dao.Home dao = new br.com.appiv.iv.dao.Home(context);
        return dao.buscarConta();
    }
}
