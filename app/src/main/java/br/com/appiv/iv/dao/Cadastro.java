package br.com.appiv.iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.appiv.iv.constants.Conta;

public class Cadastro {

    private DBIV db;
    private SQLiteDatabase sqliteDatabase;

    public Cadastro(Context context){

        db = new DBIV(context);
        sqliteDatabase = db.getWritableDatabase();
    }

    public boolean inserirConta(br.com.appiv.iv.model.Conta conta){

        try {

            ContentValues values = new ContentValues();
            values.put(Conta.NOME_CONTA, conta.getNome());
            values.put(Conta.SENHA, conta.getSenha());
            values.put(Conta.SALDO, conta.getSaldo());
            values.put(Conta.DATA_FATURA, conta.getDataFatura().toString());
            sqliteDatabase.insert(Conta.CONTA, null, values);
            sqliteDatabase.close();
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }
}
