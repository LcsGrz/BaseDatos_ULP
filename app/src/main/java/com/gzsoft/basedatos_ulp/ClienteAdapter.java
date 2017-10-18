package com.gzsoft.basedatos_ulp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ClienteAdapter {
    private static final String NAME = "cliente";
    private SQLiteDatabase sqlDB;

    public ClienteAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }

    private class Colums implements BaseColumns {
        public final static String ID = "cliente_id";
        public final static String NOMBRE = "nombre";
        public final static String APELLIDO = "apellido";
        public final static String TELEFONO = "telefono";
    }

    private final static String[] COLUMS = {
            Colums.ID, Colums.NOMBRE, Colums.APELLIDO, Colums.TELEFONO
    };

    public final static String CR_TABLE = "create table if no exists" + NAME + "(" + Colums.ID + "integer primary key autoincrement," + Colums.NOMBRE + "text not nutll," + Colums.APELLIDO + "text not null," + Colums.TELEFONO + "text);";

    public boolean insert(String nombre, String apellido, String telefono) {
        ContentValues values = new ContentValues();
        values.put(Colums.NOMBRE, nombre);
        values.put(Colums.APELLIDO, apellido);
        values.put(Colums.TELEFONO, telefono);
        return sqlDB.insert(NAME, null, values) > 0;
    }

    public boolean delete(int id) {
        String whereClause = "cliente_id=?";
        String[] whereArgs = {String.valueOf(id)};

        return sqlDB.delete(NAME, whereClause, whereArgs) > 0;
    }

    public Cursor getNombres() {
        String[] colums = {Colums.NOMBRE};
        return sqlDB.query(NAME, colums, null, null, null, null, null);
    }

    public String getName() {
        return NAME;
    }

    public String[] getColums() {
        return COLUMS;
    }

    public boolean isEmpty() {
        return sqlDB.query(NAME, COLUMS, null, null, null, null, null).getCount() == 0;
    }

    public Cursor getDatos() {
        return sqlDB.query(NAME, COLUMS, null, null, null, null, null);
    }
}
