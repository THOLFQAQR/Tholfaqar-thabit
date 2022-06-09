package com.example.cc203_tholfaqar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataClimat extends SQLiteOpenHelper {

    public final  static  String DATABASE_NAME = "Climat.db" ;
    public final  static  String TAble_NAME = "Climat" ;
    public final  static  String coll1 = "id" ;
    public final  static  String coll2 = " nomVille" ;
    public final  static  String coll3 = " pays" ;
    public final  static  String coll4 = "temprature" ;
    public final  static  String coll5 = "pourcentage " ;



    public MyDataClimat(  Context context ) {
        super(context, DATABASE_NAME, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String s = "create table " + TAble_NAME + "("+coll1+" integer primary key autoincrement,"+coll2+" TEXT,"+coll3+" TEXT,"+coll4+" INTEGER,"+coll5+" INTEGER)";
        db.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static long AddClimat(SQLiteDatabase db, Climat e){
        ContentValues cv = new ContentValues();
        cv.put(coll2,e.getNomVille());
        cv.put(coll3,e.getPays());
        cv.put(coll4,e.getTemprature());
        cv.put(coll5,e.getPourcentage());

       return db.insert(TAble_NAME,null,cv);

    }

    public static long UpdateClimat(SQLiteDatabase db, Climat e) {
        ContentValues cv = new ContentValues();
        cv.put(coll2,e.getNomVille());
        cv.put(coll3,e.getPays());
        cv.put(coll4,e.getTemprature());
        cv.put(coll5,e.getPourcentage());

        return db.update(TAble_NAME,cv,"ID="+e.id,null);

    }

    public static  long DeleteClimat(SQLiteDatabase db, int id){
        return  db.delete(TAble_NAME,"id="+id,null);
    }


    public static ArrayList<Climat> getAllClimat(SQLiteDatabase db){

        ArrayList<Climat> ar = new ArrayList<>();
        Cursor cr = db.rawQuery("select * from "+TAble_NAME ,null) ;

        while (cr.moveToNext()) {

            Climat clm = new Climat() ;

            clm.setId(cr.getInt(0));
            clm.setNomVille(cr.getString(1));
            clm.setPays(cr.getString(2));
            clm.setTemprature(cr.getInt(3));
            clm.setPourcentage(cr.getInt(4));
            ar.add(clm);
        }
        return ar ;

    }
    public static Climat getOneClimat(SQLiteDatabase db, String ville){

        Climat clm = null ;
        Cursor cr = db.rawQuery("Select *from "+TAble_NAME + "where NomVille "+ville,null) ;

        if (cr.moveToNext()){
            clm.setId(cr.getInt(0));
            clm.setNomVille(cr.getString(1));
            clm.setPays(cr.getString(2));
            clm.setTemprature(cr.getInt(3));
            clm.setPourcentage(cr.getInt(4));
        }
        return clm;

    }



}
