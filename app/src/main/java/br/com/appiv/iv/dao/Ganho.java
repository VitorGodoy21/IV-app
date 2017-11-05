package br.com.appiv.iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.com.appiv.iv.tools.QueryDinamica;

public class Ganho {

    private DBIV db;
    private SQLiteDatabase sqliteDatabase;
    private Context context;

    public Ganho(Context context){

        this.context = context;
        db = new DBIV(context);
    }

    public boolean inserir(br.com.appiv.iv.model.Ganho ganho){

        try {

            sqliteDatabase = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(br.com.appiv.iv.constants.Ganho.NOME,ganho.getNome());
            values.put(br.com.appiv.iv.constants.Ganho.DESCRICAO,ganho.getDescricao());
            values.put(br.com.appiv.iv.constants.Ganho.SALDO_MOVIMENTADO,ganho.getSaldoMovimentado());
            values.put(br.com.appiv.iv.constants.Ganho.SALDO_CALCULADO,ganho.getSaldoCalculado());
            values.put(br.com.appiv.iv.constants.Ganho.QTD_PARCELA,ganho.getQtdParcela());
            values.put(br.com.appiv.iv.constants.Ganho.DATA_RECEBIMENTO,ganho.getDataRecebimento());
            values.put(br.com.appiv.iv.constants.Ganho.ID_CONTA,ganho.getIdConta());
            sqliteDatabase.insert(br.com.appiv.iv.constants.Ganho.GANHO, null, values);
            br.com.appiv.iv.dao.Conta daoConta = new br.com.appiv.iv.dao.Conta(context);
            daoConta.atualizarSaldo(daoConta.buscarSaldo() + ganho.getSaldoMovimentado());
            sqliteDatabase.close();
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    //consultar todos
    public List<br.com.appiv.iv.model.Ganho> buscar(){

        br.com.appiv.iv.model.Ganho ganho = new br.com.appiv.iv.model.Ganho();
        sqliteDatabase = db.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(ganho.buscarGanho(), null);
        List<br.com.appiv.iv.model.Ganho> ganhos = new ArrayList<>();
        while(cursor.moveToNext()){

            ganho =
                    new br.com.appiv.iv.model.Ganho(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getDouble(3),
                            cursor.getDouble(4),
                            cursor.getInt(5),
                            cursor.getString(6),
                            cursor.getInt(7));
            ganhos.add(ganho);

        }

        sqliteDatabase.close();
        return ganhos;
    }

    //consulta por id
    public br.com.appiv.iv.model.Ganho buscar(int id){

        br.com.appiv.iv.model.Ganho ganho = new br.com.appiv.iv.model.Ganho();
        sqliteDatabase = db.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(ganho.buscarGanho(id), null);
        if(cursor.moveToNext()) {
            ganho =
                    new br.com.appiv.iv.model.Ganho(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getDouble(3),
                            cursor.getDouble(4),
                            cursor.getInt(5),
                            cursor.getString(6),
                            cursor.getInt(7));
        }
        return ganho;
    }

    //consulta por filtragem para buscar ganho...
    public List<br.com.appiv.iv.model.Ganho> buscar(br.com.appiv.iv.model.Ganho ganho){

        sqliteDatabase = db.getReadableDatabase();
        QueryDinamica query = new QueryDinamica();
        Cursor cursor = sqliteDatabase.rawQuery(query.buscarGanho(ganho), null);
        List<br.com.appiv.iv.model.Ganho> ganhos = new ArrayList<>();
        while(cursor.moveToNext()){

            ganho =
                    new br.com.appiv.iv.model.Ganho(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getDouble(3),
                            cursor.getDouble(4),
                            cursor.getInt(5),
                            cursor.getString(6),
                            cursor.getInt(7));
            ganhos.add(ganho);

        }

        sqliteDatabase.close();
        return ganhos;
    }

    public boolean atualizar(br.com.appiv.iv.model.Ganho ganho){

            try {

                sqliteDatabase = db.getWritableDatabase();
                ContentValues values = new ContentValues();
                if (!ganho.getNome().equals("")) {

                    values.put(br.com.appiv.iv.constants.Ganho.NOME, ganho.getNome());
                }

                if (!ganho.getDescricao().equals("")) {
                    values.put(br.com.appiv.iv.constants.Ganho.DESCRICAO, ganho.getDescricao());
                }

                if (ganho.getSaldoMovimentado() != 0) {

                    br.com.appiv.iv.model.Ganho model = buscar(ganho.getId());
                    br.com.appiv.iv.dao.Conta daoConta = new br.com.appiv.iv.dao.Conta(context);
                    daoConta.atualizarSaldo((daoConta.buscarSaldo() - model.getSaldoMovimentado()) + ganho.getSaldoMovimentado());
                    double saldoCalculado = model.getSaldoCalculado() - model.getSaldoMovimentado();
                    saldoCalculado += ganho.getSaldoMovimentado();
                    ganho.setSaldoCalculado(saldoCalculado);
                    values.put(br.com.appiv.iv.constants.Ganho.SALDO_MOVIMENTADO, ganho.getSaldoMovimentado());
                    values.put(br.com.appiv.iv.constants.Ganho.SALDO_CALCULADO, ganho.getSaldoCalculado());
                }

                if (ganho.getQtdParcela() != -1) {

                    values.put(br.com.appiv.iv.constants.Ganho.QTD_PARCELA, ganho.getQtdParcela());
                }

                if (!ganho.getDataRecebimento().equals("")) {

                    values.put(br.com.appiv.iv.constants.Ganho.DATA_RECEBIMENTO, ganho.getDataRecebimento());
                }

                sqliteDatabase.update(br.com.appiv.iv.constants.Ganho.GANHO,
                        values,
                        br.com.appiv.iv.constants.Ganho.ID + "=" + ganho.getId(),
                        null);
                sqliteDatabase.close();
                return true;
            }catch (Exception e){

                e.printStackTrace();
                return false;
            }
    }

    public boolean deletar(int id){

        try {

            sqliteDatabase = db.getWritableDatabase();
            br.com.appiv.iv.dao.Conta daoConta = new br.com.appiv.iv.dao.Conta(context);
            double ganhoRetirado = buscar(id).getSaldoMovimentado();
            daoConta.atualizarSaldo(daoConta.buscarSaldo() - ganhoRetirado);
            sqliteDatabase.execSQL("DELETE FROM "
                    + br.com.appiv.iv.constants.Ganho.GANHO + " WHERE "
                    + br.com.appiv.iv.constants.Ganho.ID + "=" + id);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }
}










