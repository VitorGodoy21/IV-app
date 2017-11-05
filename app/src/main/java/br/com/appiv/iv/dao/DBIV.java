package br.com.appiv.iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.appiv.iv.constants.Conta;

public class DBIV extends SQLiteOpenHelper{

    //Versão alterada 18/10/2017
    private static final int DB_VERSAO = 10;
    private static final String DB_NOME = "dbiv";

    public DBIV(Context context){

        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(br.com.appiv.iv.constants.DBIV.CONTA);
        db.execSQL(br.com.appiv.iv.constants.DBIV.GANHO);
        db.execSQL(br.com.appiv.iv.constants.DBIV.GASTO);
        db.execSQL(br.com.appiv.iv.constants.DBIV.CREDITO);
        db.execSQL(br.com.appiv.iv.constants.DBIV.PREFERENCIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAtual, int novaVersao) {

        sqLiteDatabase.execSQL("DROP TABLE GANHO");
        sqLiteDatabase.execSQL("DROP TABLE GASTO");
        sqLiteDatabase.execSQL("DROP TABLE CREDITO");
        sqLiteDatabase.execSQL("DROP TABLE PREFERENCIA");
        sqLiteDatabase.execSQL("DROP TABLE CONTA");
        onCreate(sqLiteDatabase);
    }
}