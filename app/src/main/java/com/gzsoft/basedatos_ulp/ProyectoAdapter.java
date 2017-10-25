package com.gzsoft.basedatos_ulp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ProyectoAdapter {

    private static final String NAME = "proyecto";
    private SQLiteDatabase sqlDB;

    public ProyectoAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }

    private class Colums implements BaseColumns {
        public final static String ID = "proyecto_id";
        public final static String DESCRIPCION = "descripcion";
        public final static String COSTO = "costo";
        public final static String CLIENTE_ID = "cliente_id";
    }

    private final static String[] COLUMNS = {Colums.ID, Colums.DESCRIPCION, Colums.COSTO, Colums.CLIENTE_ID};

    public final static String CR_TABLE = "create table if no exists " + NAME + "(" + Colums.ID + "integer primary keay autoincrement," + Colums.DESCRIPCION + "text not null," + Colums.COSTO + "real," + Colums.CLIENTE_ID + "integer, foreign key (cliente_id) references cliente(cliente_id));";

    public boolean insert(String descripcion, double costo, int cliente_id) {
        ContentValues values = new ContentValues();
        values.put(Colums.DESCRIPCION, descripcion);
        values.put(Colums.COSTO, costo);
        values.put(Colums.CLIENTE_ID, cliente_id);

        return sqlDB.insert(NAME, null, values) > 0;
    }

    public Cursor getDescripciones() {
        String[] colums = {Colums.DESCRIPCION};
        return sqlDB.query(NAME, colums, null, null, null, null, null);
    }

    public String getName(){
        return NAME;
    }

    public String[] getColums(){
        return COLUMNS;
    }

    public boolean isEmpty(){
        return sqlDB.query(NAME, COLUMNS, null,null,null,null,null).getCount() == 0;
    }

    public Cursor getDatos(){
        return sqlDB.query(NAME, COLUMNS, null,null,null,null,null);
    }
}
