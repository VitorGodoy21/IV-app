package br.com.appiv.iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.appiv.iv.constants.Conta;

public class Cadastro {

    public boolean inserirConta(br.com.appiv.iv.model.Conta conta, Context context){

        try {
            DBIV db;
            SQLiteDatabase sqliteDataBase;
            db = new DBIV(context);
            sqliteDataBase = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Conta.NOME_CONTA, conta.getNome());
            values.put(Conta.SENHA, conta.getSenha());
            values.put(Conta.SALDO, conta.getSaldo());
            values.put(Conta.DATA_FATURA, conta.getDataFatura().toString());
            sqliteDataBase.insert(Conta.CONTA, null, values);
            sqliteDataBase.close();
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }
}
