package com.example.mert.anagram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class veri_tabani extends SQLiteOpenHelper {

    public veri_tabani(Context c){
        super(c,"user_database",null,1);
    }

    public void onCreate (SQLiteDatabase db){
        String sql = "create table user_database (kredi integer,bilinen_kelime integer,chapter_sayisi integer," +
                "sayac1 integer,sayac2 integer,sayac3 integer, sayac4 integer, sayac5 integer,sayac6 integer," +
                " sayac7 integer,sayac8 integer, sayac9 integer , sayac10 integer, sayac11 integer," +
                " sayac12 integer,bk1 integer,bk2 integer,bk3 integer,bk4 integer,bk5 integer,bk6 integer," +
                "bk7 integer,bk8 integer,bk9 integer,bk10 integer,bk11 integer,bk12 integer,"+
                "buton_ses integer,muzik integer)";
        String ilk_kredi = "insert into user_database (kredi) values (20)";
        db.execSQL(sql);
        db.execSQL(ilk_kredi);
    }
    public void onUpgrade(SQLiteDatabase db,int eski,int yeni){

    }
}
