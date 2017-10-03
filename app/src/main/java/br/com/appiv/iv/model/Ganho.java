package br.com.appiv.iv.model;

import java.sql.Date;


public class Ganho {

    private double saldoMovimentado;
    private double saldoCalculado;
    private int parcelas;
    private Date dataRecebimento;
    private String descricao;
    private int idConta;
    private int id;

    public Ganho() {
        saldoMovimentado = 0.0;
        saldoCalculado = 0.0;
        parcelas = 0;
        dataRecebimento = Date.valueOf("01/01/1980");
        descricao = "";
    }

    public Ganho(double saldoMovimentado, double saldoCalculado, int parcelas, Date dataRecebimento, String descricao) {
        this.saldoMovimentado = saldoMovimentado;
        this.saldoCalculado = saldoCalculado;
        this.parcelas = parcelas;
        this.dataRecebimento = dataRecebimento;
        this.descricao = descricao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
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

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
