package br.com.appiv.iv.model;

import java.sql.Date;

public class Gasto {

    private String nome;
    private String descricao;
    private String tag;
    private int prioridade;
    private double saldoMovimentado;
    private double saldoCalculado;
    private int parcelas;
    private Date dataCompra;
    private Date dataPagamento;

    public Gasto() {
        nome = "";
        tag = "";
        prioridade = 0;
        saldoMovimentado = 0.0;
        saldoCalculado = 0.0;
        parcelas = 0;
        dataCompra = Date.valueOf("01/01/1980");
        dataPagamento = Date.valueOf("01/01/1980");
        descricao = "";
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
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
}
