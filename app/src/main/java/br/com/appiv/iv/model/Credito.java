package br.com.appiv.iv.model;

import java.sql.Date;

public class Credito {

    private String nome;
    private String descricao;
    private Date dataInicio;
    private int diaFatura;
    private double limite;

    public Credito() {
        this.nome = "";
        this.descricao = "";
        this.dataInicio = Date.valueOf("01/01/2001");
        this.diaFatura = 0;
        this.limite = 0.0;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDiaFatura() {
        return diaFatura;
    }

    public void setDiaFatura(int diaFatura) {
        this.diaFatura = diaFatura;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
