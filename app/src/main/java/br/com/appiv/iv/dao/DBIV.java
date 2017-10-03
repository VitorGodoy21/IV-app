package br.com.appiv.iv.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBIV extends SQLiteOpenHelper{

    private static final int DB_VERSAO = 1;
    private static final String DB_NOME = "dbiv";

    public DBIV(Context context){

        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabelaConta =
                "CREATE TABLE conta(" +
                        "id INTEGER PRIMARY KEY," +
                        "nomeConta TEXT," +
                        "senha INTEGER,"+
                        "saldo REAL," +
                        "dataFatura TEXT" +
                        ");";

        String tabelaGasto =
                "CREATE TABLE gasto(" +
                        "id INTEGER PRIMARY KEY," +
                        "descricao TEXT," +
                        "tag TEXT," +
                        "saldoMovimentado REAL," +
                        "saldoCalculado REAL," +
                        "parcelas INTEGER," +
                        "data TEXT," +
                        "dataPagamento TEXT," +
                        "idConta INTEGER," +
                        "FOREIGN KEY idConta REFERENCES conta(id)" +
                        ");";

        String tabelaGanho =
                "CREATE TABLE ganho(" +
                        "id INTEGER PRIMARY KEY," +
                        "descricao TEXT," +
                        "saldoMovimentado REAL," +
                        "saldoCalculado REAL," +
                        "parcelas INTEGER," +
                        "dataRecebimento TEXT," +
                        "idConta INTEGER," +
                        "FOREIGN KEY idConta REFERENCES conta(id)" +
                        ");";

        String preferencias =
                "CREATE TABLE preferencias(" +
                        "id INTEGER PRIMARY KEY," +
                        "descricao TEXT," +
                        "bloaqueado INTEGER," +
                        ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAtual, int novaVersao) {

    }
}