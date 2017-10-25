package com.gzsoft.basedatos_ulp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
    private DBHelper dbHelper;
    private SQLiteDatabase sqlDB;

    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "AdminSoft";

    private ClienteAdapter cliente;
    private ProyectoAdapter proyecto;

    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        sqlDB = dbHelper.getWritableDatabase();

        cliente = new ClienteAdapter(sqlDB);
        proyecto = new ProyectoAdapter(sqlDB);
    }

    public void close() {
        sqlDB.close();
    }

    public boolean cliente1IsEmpty() {
        return cliente.isEmpty();
    }

    public boolean clienteInsert(String nombre, String apellido, String numero) {
        return cliente.insert(nombre, apellido, numero);
    }

    public boolean proyectoInsert(String descripcion, double costo, int cliente_id) {
        return proyecto.insert(descripcion, costo, cliente_id);
    }

    public Cursor getNombresTabla1Cursor() {
        return cliente.getNombres();
    }

    public Cursor getDatosCliente() {
        return cliente.getDatos();
    }

    public boolean borrarCliente(int id) {
        return cliente.delete(id);
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqlDB.execSQL(ClienteAdapter.CR_TABLE);
            sqlDB.execSQL(ProyectoAdapter.CR_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqlDB.execSQL("drop table if exists" + ProyectoAdapter.CR_TABLE);
            sqlDB.execSQL("drop table if exists" + ClienteAdapter.CR_TABLE);
            onCreate(sqlDB);
        }
    }
}
