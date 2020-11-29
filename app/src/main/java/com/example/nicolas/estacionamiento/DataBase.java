package com.example.nicolas.estacionamiento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataBase {
    Context context;
    SQLiteDatabase sql;
    String bd="estacionamiento";
    String tablaUsuario = "create table if not exists usuario(id integer primary key autoincrement, nombre text, telefono text, email text, password text)";
//    String tablaAuto = "create table if not exists auto(id integer primary key autoincrement, patente text, sitio text, activo text, hora_llegada text)";

    public DataBase(Context c) {
        this.context = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tablaUsuario);
    }

    public boolean nuevoUsuario(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("telefono", usuario.getTelefono());
        cv.put("email", usuario.getEmail());
        cv.put("password", usuario.getPassword());
        return sql.insert("usuario", null, cv) > 0;
    }

    public Usuario isLoginValid(String email, String password) {
        Cursor cr = sql.rawQuery("SELECT * FROM usuario where email = ? and password = ?", new String[]{email, password});
        if(  cr != null && cr.moveToFirst() ) {
            Usuario usuario= new Usuario();
            usuario.setId(cr.getInt(0));
            usuario.setNombre(cr.getString(1));
            usuario.setTelefono(cr.getString(2));
            usuario.setEmail(cr.getString(3));
            usuario.setPassword(cr.getString(4));
            return usuario;
        }
        return null;
    }



}
