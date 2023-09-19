package com.agusoft.actividad7.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class SalirActivity{
    public SalirActivity() {
    }

    public static void mostrarDialogo(Activity activity){
        new AlertDialog.Builder(activity).setTitle("Cerrar").setMessage("¿Estas seguro de cerrar la aplicacion?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(activity, "Continuamos Trabajando", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}