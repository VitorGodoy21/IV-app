package br.com.appiv.iv.teste;

import android.content.Context;

public class Conta {

    public void buscarConta(Context context){

        br.com.appiv.iv.controller.Home controller = new br.com.appiv.iv.controller.Home();
        System.out.println(controller.buscarConta(context));
    }
}
