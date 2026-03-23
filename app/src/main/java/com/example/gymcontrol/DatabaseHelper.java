
package com.example.gymcontrol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME="gymcontrol_tcc.db";
    private static final int DB_VERSION=1;

    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,senha TEXT)");

        db.execSQL("CREATE TABLE alunos(id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT,email TEXT)");

        db.execSQL("CREATE TABLE exercicios(id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT,grupo TEXT)");

        db.execSQL("CREATE TABLE treinos(id INTEGER PRIMARY KEY AUTOINCREMENT,aluno_id INTEGER,exercicio TEXT,series INTEGER,reps INTEGER,carga REAL)");

        db.execSQL("CREATE TABLE evolucao(id INTEGER PRIMARY KEY AUTOINCREMENT,aluno_id INTEGER,peso REAL,imc REAL,data TEXT)");

        db.execSQL("CREATE TABLE pagamentos(id INTEGER PRIMARY KEY AUTOINCREMENT,aluno_id INTEGER,valor REAL,data TEXT)");
    }

    public boolean validarLogin(String email,String senha){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(
            "SELECT * FROM usuarios WHERE email=? AND senha=?",
            new String[]{email,senha}
        );

        boolean valido=cursor.getCount()>0;
        cursor.close();
        return valido;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS alunos");
        db.execSQL("DROP TABLE IF EXISTS exercicios");
        db.execSQL("DROP TABLE IF EXISTS treinos");
        db.execSQL("DROP TABLE IF EXISTS evolucao");
        db.execSQL("DROP TABLE IF EXISTS pagamentos");
        onCreate(db);
    }
}
