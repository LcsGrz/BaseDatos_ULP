package com.gzsoft.basedatos_ulp;

import android.app.Application;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/10/2017.
 */

public class BaseApplication extends Application {
    DBAdapter dbAdapter ;

    @Override
    public void onCreate() {
        dbAdapter = new DBAdapter (getApplicationContext());
        dbAdapter.open();
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        dbAdapter.close();
        super.onTerminate();
    }
    public void llenarDatosTabla(){
        if(dbAdapter.cliente1IsEmpty()){
            for(int i = 0 ; i < 30;i++){
                String nombre = "Nombre" + String.valueOf(i);
                String apellido = "Apellido" + String.valueOf(i);
                String telefono = "555-" + String.valueOf(i);
                dbAdapter.clienteInsert(nombre,apellido,telefono);
            }
        }
    }
    public boolean insertarCliente(String nombre,String apellido,String telefono){
        return dbAdapter.clienteInsert(nombre,apellido,telefono);
    }
    public ArrayList<String> nombreClientes(){
        ArrayList<String> lista = new ArrayList<String>();
        Cursor c = dbAdapter.getDatosCliente();
        if(c.moveToFirst()){
            do{
                lista.add(c.getString(1));
            }
            while(c.moveToNext());
        }
        return lista;
    }
}
