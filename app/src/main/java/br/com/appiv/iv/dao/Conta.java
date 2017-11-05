package br.com.appiv.iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Conta {

    private DBIV db;
    private SQLiteDatabase sqliteDatabase;

    public Conta(Context context){

        db = new DBIV(context);
    }

    public boolean atualizarSaldo(double saldo){

        try{

            sqliteDatabase = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(br.com.appiv.iv.constants.Conta.SALDO,saldo);
            sqliteDatabase.update(br.com.appiv.iv.constants.Conta.CONTA,
                    values,
                    br.com.appiv.iv.constants.Conta.ID + "=" + 1,
                    null);
            db.close();
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    public double buscarSaldo(){

        br.com.appiv.iv.model.Conta conta = new br.com.appiv.iv.model.Conta();
        sqliteDatabase = db.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(conta.buscarSaldo(), null);
        double saldo = 0;
        if(cursor.moveToNext()){

            saldo = cursor.getDouble(0);
        }
        db.close();
        return saldo;
    }
}
