package com.example.mert.anagram;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class veri_bilgi {
    SQLiteDatabase db;
    veri_tabani bdb;

    public veri_bilgi(Context c){
        bdb = new veri_tabani(c);
    }
    public void ac(){
        db = bdb.getReadableDatabase();
        }
    public void kapat(){
        bdb.close();
    }
    public void kelime_arttir(){
        String bilinen_kelime = ""+get_knownwords();
        int bilinen = Integer.parseInt(bilinen_kelime);
        bilinen++;
        String sql = "update user_database set bilinen_kelime = "+bilinen;
        db.execSQL(sql);
    }
    public void kelime_sifirla(){
        String sql = "update user_database set bilinen_kelime=0";
        db.execSQL(sql);
    }
    public String sayaclar(){
        String kolon[]={"sayac1"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void sayac1(){
        String sql = "update user_database set sayac1 =1 ";
        db.execSQL(sql);
    }
    public void sayac2(){
        String sql = "update user_database set sayac2 =1 ";
        db.execSQL(sql);
    }
    public void sayac3(){
        String sql = "update user_database set sayac3 =1 ";
        db.execSQL(sql);
    }
    public void sayac4(){
        String sql = "update user_database set sayac4 =1 ";
        db.execSQL(sql);
    }
    public void sayac5(){
        String sql = "update user_database set sayac5 =1 ";
        db.execSQL(sql);
    }
    public void sayac6(){
        String sql = "update user_database set sayac6 =1 ";
        db.execSQL(sql);
    }
    public void sayac7(){
        String sql = "update user_database set sayac7 =1 ";
        db.execSQL(sql);
    }
    public void sayac8(){
        String sql = "update user_database set sayac8 =1 ";
        db.execSQL(sql);

    }
    public void sayac9(){
        String sql = "update user_database set sayac9 =1 ";
        db.execSQL(sql);
    }
    public void sayac10(){
        String sql = "update user_database set sayac10 =1 ";
        db.execSQL(sql);
    }
    public void sayac11(){
        String sql = "update user_database set sayac11 =1 ";
        db.execSQL(sql);
    }
    public void sayac12(){
        String sql = "update user_database set sayac12 =1 ";
        db.execSQL(sql);
    }

    public String get_sayac1(){
        String kolon[]={"sayac1"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }
    public String get_sayac2(){
        String kolon[]={"sayac2"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }
    public String get_sayac3(){
        String kolon[]={"sayac3"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }
    public String get_sayac4(){
        String kolon[]={"sayac4"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }
    public String get_sayac5(){
        String kolon[]={"sayac5"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac6(){
        String kolon[]={"sayac6"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac7(){
        String kolon[]={"sayac7"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac8(){
        String kolon[]={"sayac8"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac9(){
        String kolon[]={"sayac9"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac10(){
        String kolon[]={"sayac10"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac11(){
        String kolon[]={"sayac11"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }public String get_sayac12(){
        String kolon[]={"sayac12"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int sayac = c.getInt(0);
        String str = ""+sayac;
        return str;
    }

    public void set_chapter(int x){
        String chapter = ""+x;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set chapter_sayisi = "+chapter_s;
        db.execSQL(sql);
    }
    public void chapter_arttir(){
        String chapter = ""+get_knownwords();
        int chapter_s = Integer.parseInt(chapter);
        chapter_s++;
        String sql = "update user_database set chapter_sayisi = "+chapter_s;
        db.execSQL(sql);
    }
    public void chapter_sifirla(){
        String sql = "update user_database set chapter_sayisi =0 ";
        db.execSQL(sql);
    }
    
    public void buton_ses_arttir(){
        String ses = ""+get_buton_ses();
        int ses_b = Integer.parseInt(ses);
        ses_b++;
        if(ses_b==2)
            ses_b=0;
        String sql = "update user_database set buton_ses = "+ses_b;
        db.execSQL(sql);
    }
    public String get_buton_ses(){
        String kolon[]={"buton_ses"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int ses = c.getInt(0);
        String str = ""+ses;
        return str;
    }
    public void muzik_arttir(){
        String ses = ""+get_muzik();
        int ses_b = Integer.parseInt(ses);
        ses_b++;
        if(ses_b==2)
            ses_b=0;
        String sql = "update user_database set muzik = "+ses_b;
        db.execSQL(sql);
    }
    public String get_muzik(){
        String kolon[]={"muzik"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int ses = c.getInt(0);
        String str = ""+ses;
        return str;
    }

    public String get_knownwords(){
        String kolon[]={"bilinen_kelime"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }



    public String get_chapter(){
        String kolon[]={"chapter_sayisi"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }

    public void kredi_azalt(){
        String kredi_sayisi = ""+get_credit();
        int kredi = Integer.parseInt(kredi_sayisi);
        kredi--;
        String sql = "update user_database set kredi= "+kredi;
        db.execSQL(sql);
    }
    public void kredi_20(){
        String sql = "update user_database set kredi=20";
        db.execSQL(sql);
    }
    public void kredi_arttir(){
        String kredi_sayisi = ""+get_credit();
        int kredi = Integer.parseInt(kredi_sayisi);
        kredi=kredi+3;
        String sql = "update user_database set kredi= "+kredi;
        db.execSQL(sql);
    }
    public void kredi_arttir30(){
        String kredi_sayisi = ""+get_credit();
        int kredi = Integer.parseInt(kredi_sayisi);
        kredi=kredi+30;
        String sql = "update user_database set kredi= "+kredi;
        db.execSQL(sql);
    }
    public void kredi_arttir75(){
        String kredi_sayisi = ""+get_credit();
        int kredi = Integer.parseInt(kredi_sayisi);
        kredi=kredi+75;
        String sql = "update user_database set kredi= "+kredi;
        db.execSQL(sql);
    }
    public void kredi_arttir100(){
        String kredi_sayisi = ""+get_credit();
        int kredi = Integer.parseInt(kredi_sayisi);
        kredi=kredi+100;
        String sql = "update user_database set kredi= "+kredi;
        db.execSQL(sql);
    }

    public String get_credit(){
        String kolon[]={"kredi"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
        }

    public String get_bk1(){
        String kolon[]={"bk1"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk1(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk1="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk2(){
        String kolon[]={"bk2"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk2(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk2="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk3(){
        String kolon[]={"bk3"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk3(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk3="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk4(){
        String kolon[]={"bk4"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk4(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk4="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk5(){
        String kolon[]={"bk5"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk5(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk5="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk6(){
        String kolon[]={"bk6"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk6(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk6="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk7(){
        String kolon[]={"bk7"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk7(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk7="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk8(){
        String kolon[]={"bk8"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk8(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk8="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk9(){
        String kolon[]={"bk9"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk9(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk9="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk10(){
        String kolon[]={"bk10"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk10(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk10="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk11(){
        String kolon[]={"bk11"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk11(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk11="+chapter_s;
        db.execSQL(sql);
    }
    public String get_bk12(){
        String kolon[]={"bk12"};
        Cursor c = db.query("user_database",kolon,null,null,null,null,null);
        c.moveToFirst();
        int kredisayisi = c.getInt(0);
        String str = ""+kredisayisi;
        return str;
    }
    public void set_bk12(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bk12="+chapter_s;
        db.execSQL(sql);
    }
    public void set_knowing_words(int i){
        String chapter = ""+i;
        int chapter_s = Integer.parseInt(chapter);
        String sql = "update user_database set bilinen_kelime="+chapter_s;
        db.execSQL(sql);
    }
}
