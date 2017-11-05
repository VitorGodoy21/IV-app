package br.com.appiv.iv.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

public class Ganho {

    public Ganho(){


    }

    public boolean inserir(Context context,
                           String nome,
                           String descricao,
                           double saldoMovimentado,
                           double saldoCalculado,
                           int qtdParcela,
                           String dataRecebimento){

        br.com.appiv.iv.model.Ganho ganho =
                new br.com.appiv.iv.model.Ganho(nome,
                        descricao,
                        saldoMovimentado,
                        saldoCalculado,
                        qtdParcela,
                        dataRecebimento,
                        1);
        br.com.appiv.iv.dao.Ganho dao = new br.com.appiv.iv.dao.Ganho(context);
        return dao.inserir(ganho);
    }

    public List<br.com.appiv.iv.model.Ganho> buscar(Context context){

        br.com.appiv.iv.dao.Ganho dao = new br.com.appiv.iv.dao.Ganho(context);
        return dao.buscar();
    }

    public List<br.com.appiv.iv.model.Ganho> buscar(Context context,
                                                    String nome,
                                                    String descricao,
                                                    double saldoMovimentado,
                                                    double saldoCalculado,
                                                    int qtdParcela,
                                                    String dataRecebimento){

        br.com.appiv.iv.model.Ganho ganho = new br.com.appiv.iv.model.Ganho(nome,
                descricao,
                saldoMovimentado,
                saldoCalculado,
                qtdParcela,
                dataRecebimento,
                1);
        br.com.appiv.iv.dao.Ganho dao = new br.com.appiv.iv.dao.Ganho(context);
        return dao.buscar(ganho);
    }

    public boolean atualizar(Context context,
                             int id,
                             String nome,
                             String descricao,
                             double saldoMovimentado,
                             int qtdParcela,
                             String dataRecebimento){

        br.com.appiv.iv.model.Ganho ganho =
                new br.com.appiv.iv.model.Ganho(id,
                    nome,
                    descricao,
                    saldoMovimentado,
                    0,
                    qtdParcela,
                    dataRecebimento,
                    0);
        br.com.appiv.iv.dao.Ganho dao = new br.com.appiv.iv.dao.Ganho(context);
        return dao.atualizar(ganho);
    }

    public boolean deletar(Context context,int id){

        br.com.appiv.iv.dao.Ganho dao = new br.com.appiv.iv.dao.Ganho(context);
        return dao.deletar(id);
    }
}
