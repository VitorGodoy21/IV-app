package br.com.appiv.iv.model;

import java.sql.Date;

public class Conta {

    private String nome;
    private Date dataFatura;
    private double saldo;
    private int senha;

    public Conta() {
        nome="";
        dataFatura = Date.valueOf("01/01/1980");
        saldo = 0.0;
        senha = 0;
    }

    public Conta(String nome, Date dataFatura, double saldo, int senha) {
        this.nome = nome;
        this.dataFatura = dataFatura;
        this.saldo = saldo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(Date dataFatura) {
        this.dataFatura = dataFatura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
