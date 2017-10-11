package br.com.appiv.iv.model;

import java.sql.Date;


public class Ganho {

    private String nome;
    private String descricao;
    private double saldoMovimentado;
    private double saldoCalculado;
    private int parcelas;
    private Date dataRecebimento;

    public Ganho() {
        nome = "";
        descricao = "";
        saldoMovimentado = 0.0;
        saldoCalculado = 0.0;
        parcelas = 0;
        dataRecebimento = Date.valueOf("01/01/1980");
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
}
