package br.com.appiv.iv.model;

public class Conta {

    private String nome;
    private double saldo;
    private int senha;

    public Conta() {
        nome="";
        saldo = 0.0;
        senha = 0;
    }

    public Conta(String nome, double saldo, int senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", senha=" + senha +
                '}';
    }

    //Query
    public String buscarConta(){

        br.com.appiv.iv.constants.Conta tabelaConta = new br.com.appiv.iv.constants.Conta();
        return "SELECT " + tabelaConta.NOME_CONTA + "," + tabelaConta.SALDO + " FROM " + tabelaConta.CONTA;
    }
}
