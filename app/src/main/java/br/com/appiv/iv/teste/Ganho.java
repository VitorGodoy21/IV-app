package br.com.appiv.iv.teste;

import android.content.Context;
import java.util.List;

public class Ganho {

    public Ganho(){


    }

    public void buscar(Context context){

        br.com.appiv.iv.controller.Ganho controller = new br.com.appiv.iv.controller.Ganho();
        List<br.com.appiv.iv.model.Ganho> ganhos =  controller.buscar(context);
        System.out.println("TAMANHO::" + ganhos.size());
        for(br.com.appiv.iv.model.Ganho ganho : ganhos){

            System.out.println(ganho);
        }
    }

    public void buscar(Context context,
                       String nome,
                       String descricao,
                       double saldoMovimentado,
                       double saldoCalculado,
                       int qtdParcela,
                       String dataRecebimento){

        br.com.appiv.iv.controller.Ganho controller = new br.com.appiv.iv.controller.Ganho();
        List<br.com.appiv.iv.model.Ganho> ganhos = controller.buscar(context,
                nome,
                descricao,
                saldoMovimentado,
                saldoCalculado,
                qtdParcela,
                dataRecebimento);

        for(br.com.appiv.iv.model.Ganho ganho : ganhos){

            System.out.println(ganho);
        }
    }
}
