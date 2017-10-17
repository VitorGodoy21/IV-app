package br.com.appiv.iv.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by vitor on 14/10/2017.
 */

public class Mensagem {


    public static void mostrarAlert(String m,Context context){

        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle(br.com.appiv.iv.constants.Mensagem.ATENCAO);
        alerta.setMessage(m);
        alerta.setPositiveButton(br.com.appiv.iv.constants.Mensagem.OK, null);
        alerta.show();

    }

    public static void mostrarToast(String m, Context context){
        Toast.makeText(
                context,
                m,
                Toast.LENGTH_LONG
        ).show();
    }
}
