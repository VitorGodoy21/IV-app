package br.com.appiv.iv.constants;

public class DBIV {

    public DBIV(){

    }

    public static final String CONTA =
            "CREATE TABLE conta(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT," +
            "senha INTEGER,"+
            "saldo REAL" +
            ");";

    public static final String GASTO =
            "CREATE TABLE gasto(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT," +
            "descricao TEXT," +
            "tag TEXT," +
            "prioridade INTEGER," +
            "saldoMovimentado REAL," +
            "saldoCalculado REAL," +
            "parcelas INTEGER," +
            "data TEXT," +
            "dataPagamento TEXT," +
            "idConta INTEGER," +
            "FOREIGN KEY (idConta) REFERENCES conta(id)" +
            ");";

    public static final String GANHO =
            "CREATE TABLE ganho(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT," +
            "descricao TEXT," +
            "saldoMovimentado REAL," +
            "saldoCalculado REAL," +
            "qtdParcela INTEGER," +
            "dataRecebimento TEXT," +
            "idConta INTEGER," +
            "FOREIGN KEY (idConta) REFERENCES conta(id)" +
            ");";

    public static final String CREDITO =
            "CREATE TABLE credito(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT," +
            "descricao TEXT," +
            "dataInicio TEXT," +
            "dataFatura TEXT," +
            "limite REAL," +
            "idConta INTEGER," +
            "FOREIGN KEY (idConta) REFERENCES conta(id)" +
            ");";

    public static final String PREFERENCIA =
            "CREATE TABLE preferencia(" +
            "id INTEGER PRIMARY KEY," +
            "descricao TEXT," +
            "bloaqueado INTEGER" +
            ");";
}






