package br.com.appiv.iv.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.appiv.iv.model.Conta;

public class Home {

    private DBIV db;
    private SQLiteDatabase sqliteDatabase;

    public Home(Context context){

        db = new DBIV(context);
    }

    public Conta buscarConta(){

        Conta conta = new Conta();
        sqliteDatabase = db.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(conta.buscarConta(), null);
        if(cursor.moveToNext()){

            conta = new Conta(cursor.getString(0),cursor.getDouble(1),0);
            sqliteDatabase.close();
            return conta;
        }

        return null;
    }
}
