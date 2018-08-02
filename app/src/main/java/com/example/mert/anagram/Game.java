package com.example.mert.anagram;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


import java.util.List;

public class Game extends AppCompatActivity implements View.OnClickListener {
    veri_bilgi vb;

    LinearLayout tLayout;
    LinearLayout butonLayout;
    LinearLayout main;
    RelativeLayout dogruLayout;
    RelativeLayout inGameButtons;
    ImageView x;

    TextView kelimeD;
    TextView kelimeAnlam;
    TextView kredi;
    TextView kelime_sayac;

    MediaPlayer buton_ses;
    MediaPlayer music;

    String kelime;
    String karisik;
    String anlam;
    String harfBirlestir="";
    String harfTut;

    Button harfver;
    Button temizle;
    Button ileriB;
    Button karistir;
    Button geriAl;
    Button cevap;



    int id=100;
    int sayac=0;
    int idButton=200;
    int idSakla;
    int chapter_sayisi;
    int holy_coin30sayac=0;
    int holy_coin75sayac=0;
    int holy_coin100sayac=0;

    long reklam_sayac=0;

    double density;

    private InterstitialAd interstitialAd;

private Game g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        density= getResources().getDisplayMetrics().density;

        vb = new veri_bilgi(this);
        vb.ac();


        interstitialAd = new InterstitialAd(this);
        MobileAds.initialize(this, "ca-app-pub-6773500290196994~3213845800");
        interstitialAd.setAdUnitId("ca-app-pub-6773500290196994/2933686346");
        if(!interstitialAd.isLoaded()) {
            interstitialAd.loadAd(new AdRequest.Builder().build());
        }
        interstitialAd.setAdListener(new AdListener()
                                     {
                                         @Override
                                         public void onAdClosed(){

                                         }
                                     }
                                     );




        View decorView = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }




        music= MediaPlayer.create(Game.this,R.raw.morning_stroll);
        kredi=(TextView)findViewById(R.id.credit);
        inGameButtons=(RelativeLayout)findViewById(R.id.inGameButtonLay);
        cevap=(Button)findViewById(R.id.cevap);
        cevap.setOnClickListener(this);
        buton_ses=MediaPlayer.create(Game.this,R.raw.buton_ses);
        main =(LinearLayout)findViewById(R.id.mainLay);
        tLayout = (LinearLayout) findViewById(R.id.textBoxes);
        butonLayout = (LinearLayout) findViewById(R.id.buttonFon);
        dogruLayout=(RelativeLayout)findViewById(R.id.Dogru);
        harfver = (Button) findViewById(R.id.harf);
        kelimeAnlam=(TextView)findViewById(R.id.anlam);
        kelimeD=(TextView)findViewById(R.id.kelimeDogru);
        harfver.setOnClickListener(this);
        temizle = (Button) findViewById(R.id.clear);
        temizle.setOnClickListener(this);
        ileriB=(Button)findViewById(R.id.ileri);
        ileriB.setOnClickListener(this);
        karistir=(Button)findViewById(R.id.mix);
        karistir.setOnClickListener(this);
        geriAl=(Button)findViewById(R.id.undo);
        geriAl.setOnClickListener(this);
        kredi.setText(vb.get_credit()+"   ");
        kelime_sayac=(TextView)findViewById(R.id.kelime_sayac);
        kelime_sayac.setText(Integer.parseInt(vb.get_knownwords())+1+"/"+"35");
        Oyun();
    }

    public void Oyun(){
        dogruLayout.setVisibility(View.INVISIBLE);
        ileriB.setVisibility(View.INVISIBLE);
        String b = ""+vb.get_knownwords();
        int bilinen_kelime = Integer.parseInt(b);
        String c = ""+vb.get_chapter();
        chapter_sayisi = Integer.parseInt(c);
        if(Integer.parseInt(vb.get_chapter())==0 && Integer.parseInt(vb.get_sayac2())==1) {
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==1 && Integer.parseInt(vb.get_sayac3())==1){
                cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==2 && Integer.parseInt(vb.get_sayac4())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==3 && Integer.parseInt(vb.get_sayac5())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==4 && Integer.parseInt(vb.get_sayac6())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==5 && Integer.parseInt(vb.get_sayac7())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==6 && Integer.parseInt(vb.get_sayac8())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==7 && Integer.parseInt(vb.get_sayac9())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==8 && Integer.parseInt(vb.get_sayac10())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==9 && Integer.parseInt(vb.get_sayac11())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==10 && Integer.parseInt(vb.get_sayac12())==1){
            cevap.setVisibility(View.VISIBLE);
        }
        if(Integer.parseInt(vb.get_chapter())==11 && Integer.parseInt(vb.get_sayac1())==1){
            cevap.setVisibility(View.VISIBLE);
        }

        if(bilinen_kelime>=35){//DEGISTIR SONRA!!!
            vb.kelime_sifirla();
            bilinen_kelime=0;
            vb.chapter_arttir();

            vb.set_bk1((Integer.parseInt(vb.get_knownwords())));

            if(chapter_sayisi+1==1){
                vb.set_bk1(Integer.parseInt(vb.get_knownwords()));
                vb.sayac2();
            }
            else if(chapter_sayisi+1==2){
                vb.set_bk2(Integer.parseInt(vb.get_knownwords()));
                vb.sayac3();
            }
            else if(chapter_sayisi+1==3){
                vb.set_bk3(Integer.parseInt(vb.get_knownwords()));
                vb.sayac4();
            }
            else if(chapter_sayisi+1==4){
                vb.set_bk4(Integer.parseInt(vb.get_knownwords()));
                vb.sayac5();
            }
            else if(chapter_sayisi+1==5){
                vb.set_bk5(Integer.parseInt(vb.get_knownwords()));
                vb.sayac6();
            }
            else if(chapter_sayisi+1==6){
                vb.set_bk6(Integer.parseInt(vb.get_knownwords()));
                vb.sayac7();
            }
            else if(chapter_sayisi+1==7){
                vb.set_bk7(Integer.parseInt(vb.get_knownwords()));
                vb.sayac8();
            }
            else if(chapter_sayisi+1==8){
                vb.set_bk8(Integer.parseInt(vb.get_knownwords()));
                vb.sayac9();
            }
            else if(chapter_sayisi+1==9){
                vb.set_bk9(Integer.parseInt(vb.get_knownwords()));
                vb.sayac10();
            }
            else if(chapter_sayisi+1==10){
                vb.set_bk10(Integer.parseInt(vb.get_knownwords()));
                vb.sayac11();
            }
            else if(chapter_sayisi+1==11){
                vb.set_bk11(Integer.parseInt(vb.get_knownwords()));
                vb.sayac12();
            }
            if(chapter_sayisi+1==12){
                vb.set_bk12(Integer.parseInt(vb.get_knownwords()));
                vb.sayac1();
            }
            finish();
        }// BURAYI SIL BASA DONMESIN

        gameFunc g = new gameFunc(bilinen_kelime,chapter_sayisi);
        kelime = g.kelime;
        karisik = g.karistir();
        anlam = g.kelimeA;
        butonOlustur();
        textBoxOlustur();
    }
    public void butonSesi(){
        if(Integer.parseInt(vb.get_buton_ses())==0)
            buton_ses.start();
    }

    public void butonOlustur() {
        idButton=200;
        for (int i = 0; i < karisik.length(); i++) {
            Button a = new Button(this);
            a.setId(idButton);
            idButton++;
            char c = karisik.charAt(i);
            String s = String.valueOf(c);
            if (density < 1.0) {
                butonLayout.addView(a, 28, 28); //ldpi
                a.setBackground(getDrawable(R.drawable.buton_28));
            }
            else if (density >= 1.0 && density < 1.5) {
                butonLayout.addView(a, 35, 35); //mdpi
                a.setBackground(getDrawable(R.drawable.buton_35));
            }
            else if (density >= 1.5 && density < 2.0) {
                butonLayout.addView(a, 60, 60); //hdpi
                a.setBackground(getDrawable(R.drawable.buton_60));
            }
            else if (density >= 2.0 && density < 3.0) {
                butonLayout.addView(a, 90, 90); //xhdpi
                a.setBackground(getDrawable(R.drawable.buton_90));
            }
            else if (density >= 3.0 && density < 3.5) {
                butonLayout.addView(a, 120, 120); //xxhdpi
                a.setBackground(getDrawable(R.drawable.buton_120));
            }
            else if(density >= 3.5 && density < 4.0){
                butonLayout.addView(a, 140, 140); //xxhdpi
                a.setBackground(getDrawable(R.drawable.buton_140));
            }
            if (density >= 4.0) {
                butonLayout.addView(a, 220, 220); //xxxhdpi
                a.setBackground(getDrawable(R.drawable.buton_220));
            }
            a.setText(s);
            a.setOnClickListener(this);
        }
        idButton = 200;
    }
    public void temizle(){
        harfBirlestir = "";
        idButton = 200;
        id = 100;
        sayac=0;
        butonLayout.removeAllViews();
        tLayout.removeAllViews();
    }
    public void dogru_anim(View view) {

        ImageView v =(ImageView)view;
        v.setVisibility(View.VISIBLE);
        Drawable d = v.getDrawable();
        if(d instanceof AnimatedVectorDrawableCompat){
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;
            avd.start();
        }
        else if(d instanceof AnimatedVectorDrawable){
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) d;
            avd.start();
        }

    }
    public void yanlis_anim(View view) {

        ImageView v =(ImageView)view;
        v.setVisibility(View.VISIBLE);
        Drawable d = v.getDrawable();
        if(d instanceof AnimatedVectorDrawableCompat){
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;
            avd.start();
        }
        else if(d instanceof AnimatedVectorDrawable){
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) d;
            avd.start();
        }

    }

    public void textBoxOlustur(){
        for (int i = 0; i < karisik.length(); i++) {
            TextView t = new TextView(this);
            t.setId(id);
            id++;
            if (density < 1.0) {
                tLayout.addView(t, 28, 28); //ldpi
            }
            else if (density >= 1.0 && density < 1.5) {
                tLayout.addView(t, 35, 35); //mdpi
            }
            else if (density >= 1.5 && density < 2.0) {
                tLayout.addView(t, 60, 60); //hdpi
            }
            else if (density >= 2.0 && density < 3.0) {
                tLayout.addView(t, 90, 90); //xhdpi
            }
            else if (density >= 3.0 && density < 3.5) {
                tLayout.addView(t, 120, 120); //xxhdpi
            }
            else if(density >= 3.5 && density < 4.0){
                tLayout.addView(t, 140, 140); //xxhdpi
            }
            if (density >= 4.0) {
                tLayout.addView(t, 220, 220); //xxxhdpi
            }
            t.setTypeface(Typeface.DEFAULT_BOLD);
            t.setTextColor(Color.parseColor("#FFFFFF"));
            t.setText("__");
        }
        id=100;
    }

    @Override
    public void onClick(View v) {
         if(cevap.getId()==((Button)v).getId()){
            dogruLayout.setVisibility(View.VISIBLE);
            kelimeAnlam.setText(anlam);
            kelimeD.setText(kelime);
            vb.kelime_arttir();
            kelime_sayac.setText(Integer.parseInt(vb.get_knownwords())+1+"/"+"35");
            inGameButtons.setVisibility(View.INVISIBLE);
            geriAl.setVisibility(View.INVISIBLE);
            ileriB.setVisibility(View.VISIBLE);
            main.setVisibility(View.INVISIBLE);
        }else if(geriAl.getId()==((Button)v).getId()){
            butonSesi();
            Button undo=(Button)findViewById(idSakla);
            undo.setVisibility(View.VISIBLE);
            undo.setText(harfTut);
            id--;
            sayac--;
            TextView undoT=(TextView)findViewById(id);
            undoT.setText("__");
            harfBirlestir=harfBirlestir.substring(0,harfBirlestir.length()-1);
            geriAl.setVisibility(View.INVISIBLE);
        }else if(karistir.getId()==((Button)v).getId()){
            butonSesi();
            geriAl.setVisibility(View.INVISIBLE);
            temizle();
            Oyun();
        }else if(ileriB.getId()==((Button)v).getId()){
            butonSesi();
            geriAl.setVisibility(View.INVISIBLE);
            main.setVisibility(View.VISIBLE);
            dogruLayout.setVisibility(View.INVISIBLE);
            inGameButtons.setVisibility(View.VISIBLE);
            temizle();
            Oyun();
        }else if(temizle.getId()==((Button)v).getId()){
            geriAl.setVisibility(View.INVISIBLE);
            butonSesi();
            temizle();
            butonOlustur();
            textBoxOlustur();
        }else if(harfver.getId()==((Button)v).getId()){
            if(Integer.parseInt(vb.get_credit())>0) {
                TextView x = (TextView) findViewById(id);
                butonSesi();
                x.setText("" + kelime.charAt(sayac));
                harfBirlestir = harfBirlestir + kelime.charAt(sayac);
                vb.kredi_azalt();
                kredi.setText(vb.get_credit()+"   ");
                idButton = 200;
                for (int i = 0; i < kelime.length(); i++) {
                    Button yeni2 = (Button) findViewById(idButton);
                    if (yeni2.getText().equals("" + kelime.charAt(sayac))) {
                        yeni2.setVisibility(View.INVISIBLE);
                        idSakla = yeni2.getId();
                        harfTut = "" + yeni2.getText();
                        geriAl.setVisibility(View.VISIBLE);
                        yeni2.setText("");
                        break;
                    }
                    idButton++;
                }
                sayac++;
                id++;
            }else{
                Toast.makeText(getBaseContext(),
                        "Not Enough Holy Coins", Toast.LENGTH_SHORT).show();
            }
        }else {
            Button a = (Button) v;
            butonSesi();
            idSakla=a.getId();
            harfTut=""+a.getText();
            TextView x = (TextView) findViewById(id);
            x.setText(a.getText());
            id++;
            sayac++;
            geriAl.setVisibility(View.VISIBLE);
            a.setVisibility(View.INVISIBLE);
            harfBirlestir = harfBirlestir + a.getText();
        }
        if (sayac == kelime.length()) {
            id = 100;
            sayac = 0;
            //DOGRU ISE:
            if (harfBirlestir.equals(kelime)) {
                x = (ImageView) findViewById(R.id.dogru_anim);
                dogru_anim(x);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        x.setVisibility(View.INVISIBLE);
                        dogruLayout.setVisibility(View.VISIBLE);
                    }
                },1250);

                vb.kelime_arttir();
                kelime_sayac.setText(Integer.parseInt(vb.get_knownwords())+1+"/"+"35");
                if(Integer.parseInt(vb.get_chapter())==0){
                    vb.set_bk1(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==1){
                    vb.set_bk2(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==2){
                    vb.set_bk3(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==3){
                    vb.set_bk4(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==4){
                    vb.set_bk5(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==5){
                    vb.set_bk6(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==6){
                    vb.set_bk7(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==7){
                    vb.set_bk8(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==8){
                    vb.set_bk9(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==9){
                    vb.set_bk10(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==10){
                    vb.set_bk11(Integer.parseInt(vb.get_knownwords()));
                }
                if(Integer.parseInt(vb.get_chapter())==11){
                    vb.set_bk12(Integer.parseInt(vb.get_knownwords()));
                }

                if(Integer.parseInt(vb.get_knownwords())%7==0 && interstitialAd.isLoaded()){
                    interstitialAd.show();
                }else if(Integer.parseInt(vb.get_knownwords())%6==0 && !interstitialAd.isLoaded()){
                    interstitialAd.loadAd(new AdRequest.Builder().build());
                }

                kelimeAnlam.setText(anlam);
                kelimeD.setText(kelime);
                inGameButtons.setVisibility(View.INVISIBLE);
                geriAl.setVisibility(View.INVISIBLE);
                ileriB.setVisibility(View.VISIBLE);
                main.setVisibility(View.INVISIBLE);
                //
            } else {
                x = (ImageView) findViewById(R.id.yanlis_anim);
                yanlis_anim(x);
                geriAl.setVisibility(View.INVISIBLE);
                main.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        x.setVisibility(View.INVISIBLE);
                        main.setVisibility(View.VISIBLE);
                    }
                },1250);

                harfBirlestir = "";

                temizle();
                butonOlustur();
                textBoxOlustur();

            }
        }
    }

    protected void onResume(){
        //vb.ac();
        if(Integer.parseInt(vb.get_muzik())==0)
            music.start();
        View decorView = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }


        super.onResume();
    }
    protected void onPause(){
        music.pause();
        //vb.kapat();
        super.onPause();
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

}