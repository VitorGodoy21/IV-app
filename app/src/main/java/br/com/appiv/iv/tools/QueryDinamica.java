package br.com.appiv.iv.tools;

import br.com.appiv.iv.constants.Ganho;

public class QueryDinamica {

    public QueryDinamica(){

    }

    public String buscarGanho(br.com.appiv.iv.model.Ganho ganho){

        String sqlSelect = "SELECT "
                + Ganho.ID + ","
                + Ganho.NOME + ","
                + Ganho.DESCRICAO + ","
                + Ganho.SALDO_MOVIMENTADO + ","
                + Ganho.SALDO_CALCULADO + ","
                + Ganho.QTD_PARCELA + ","
                + Ganho.DATA_RECEBIMENTO + ","
                + Ganho.ID_CONTA
                + " FROM " + Ganho.GANHO
                + " WHERE " + Ganho.ID_CONTA + "=" + ganho.getIdConta();

        if(!ganho.getNome().equals("")){

            sqlSelect += " AND " + Ganho.NOME + "=" + "'" +ganho.getNome() + "'";
        }

        if(!ganho.getDescricao().equals("")){

            sqlSelect += " AND " + Ganho.DESCRICAO + "=" + "'" + ganho.getDescricao() + "'";
        }

        if(ganho.getSaldoMovimentado() != 0){

            sqlSelect += " AND " + Ganho.SALDO_MOVIMENTADO + "=" + ganho.getSaldoMovimentado();
        }

        if(ganho.getQtdParcela() != 0){

            sqlSelect += " AND " + Ganho.QTD_PARCELA + "=" + ganho.getQtdParcela();
        }

        return sqlSelect;
    }
}
