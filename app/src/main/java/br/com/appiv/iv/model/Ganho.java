package br.com.appiv.iv.model;


public class Ganho {

    private int id;
    private String nome;
    private String descricao;
    private double saldoMovimentado;
    private double saldoCalculado;
    private int qtdParcela;
    private String dataRecebimento;
    private int idConta;

    public Ganho() {
        nome = "";
        descricao = "";
        saldoMovimentado = 0.0;
        saldoCalculado = 0.0;
        qtdParcela = 0;
        dataRecebimento = "";
    }

    public Ganho(int id,
                 String nome,
                 String descricao,
                 double saldoMovimentado,
                 double saldoCalculado,
                 int qtdParcela,
                 String dataRecebimento,
                 int idConta) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.saldoMovimentado = saldoMovimentado;
        this.saldoCalculado = saldoCalculado;
        this.qtdParcela = qtdParcela;
        this.dataRecebimento = dataRecebimento;
        this.idConta = idConta;
    }

    public Ganho(String nome,
                 String descricao,
                 double saldoMovimentado,
                 double saldoCalculado,
                 int qtdParcela,
                 String dataRecebimento,
                 int idConta) {

        this.nome = nome;
        this.descricao = descricao;
        this.saldoMovimentado = saldoMovimentado;
        this.saldoCalculado = saldoCalculado;
        this.qtdParcela = qtdParcela;
        this.dataRecebimento = dataRecebimento;
        this.idConta = idConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSaldoMovimentado() {
        return saldoMovimentado;
    }

    public void setSaldoMovimentado(double saldoMovimentado) {
        this.saldoMovimentado = saldoMovimentado;
    }

    public double getSaldoCalculado() {
        return saldoCalculado;
    }

    public void setSaldoCalculado(double saldoCalculado) {
        this.saldoCalculado = saldoCalculado;
    }

    public int getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(int qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    @Override
    public String toString() {
        return "Ganho{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", saldoMovimentado=" + saldoMovimentado +
                ", saldoCalculado=" + saldoCalculado +
                ", qtdParcela=" + qtdParcela +
                ", dataRecebimento='" + dataRecebimento + '\'' +
                ", idConta=" + idConta +
                '}';
    }

    //Query

    public String buscarGanho(){


        return "SELECT "
                + br.com.appiv.iv.constants.Ganho.ID + ","
                + br.com.appiv.iv.constants.Ganho.NOME + ","
                + br.com.appiv.iv.constants.Ganho.DESCRICAO + ","
                + br.com.appiv.iv.constants.Ganho.SALDO_MOVIMENTADO + ","
                + br.com.appiv.iv.constants.Ganho.SALDO_CALCULADO + ","
                + br.com.appiv.iv.constants.Ganho.QTD_PARCELA + ","
                + br.com.appiv.iv.constants.Ganho.DATA_RECEBIMENTO + ","
                + br.com.appiv.iv.constants.Ganho.ID_CONTA
                + " FROM "
                + br.com.appiv.iv.constants.Ganho.GANHO;
    }

    public String buscarGanho(int id){

        return "SELECT "
                + br.com.appiv.iv.constants.Ganho.ID + ","
                + br.com.appiv.iv.constants.Ganho.NOME + ","
                + br.com.appiv.iv.constants.Ganho.DESCRICAO + ","
                + br.com.appiv.iv.constants.Ganho.SALDO_MOVIMENTADO + ","
                + br.com.appiv.iv.constants.Ganho.SALDO_CALCULADO + ","
                + br.com.appiv.iv.constants.Ganho.QTD_PARCELA + ","
                + br.com.appiv.iv.constants.Ganho.DATA_RECEBIMENTO + ","
                + br.com.appiv.iv.constants.Ganho.ID_CONTA
                + " FROM "
                + br.com.appiv.iv.constants.Ganho.GANHO
                + " WHERE "
                + br.com.appiv.iv.constants.Ganho.ID + "=" + id;
    }
}








