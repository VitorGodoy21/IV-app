package br.com.appiv.iv.model;

import java.sql.Date;

public class Gasto {

    private String tag;
    private double saldoMovimentado;
    private double saldoCalculado;
    private int parcelas;
    private Date dataCompra;
    private Date dataPagamento;
    private String descricao;
    private int idConta;
    private int id;

    public Gasto() {
        tag = "";
        saldoMovimentado = 0.0;
        saldoCalculado = 0.0;
        parcelas = 0;
        dataCompra = Date.valueOf("01/01/1980");
        dataPagamento = Date.valueOf("01/01/1980");
        descricao = "";
    }

    public Gasto(String tag, double saldoMovimentado, double saldoCalculado, int parcelas, Date dataCompra, Date dataPagamento, String descricao) {
        this.tag = tag;
        this.saldoMovimentado = saldoMovimentado;
        this.saldoCalculado = saldoCalculado;
        this.parcelas = parcelas;
        this.dataCompra = dataCompra;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
