package com.example.mert.anagram;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.android.billingclient.api.Purchase;

import org.w3c.dom.Text;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class MainMenu extends AppCompatActivity implements View.OnClickListener,RewardedVideoAdListener,PurchasesUpdatedListener {
    Button settings;
    Button cikis;
    Button cikis2;
    Button newgame;
    Button buy;
    Button reklam_buton;
    Button holy_30;
    Button holy_75;
    Button holy_100;
    Button info;
    Button cikis3;
    Button lvl1;
    Button lvl2;
    Button lvl3;
    Button lvl4;
    Button lvl5;
    Button lvl6;
    Button lvl7;
    Button lvl8;
    Button lvl9;
    Button lvl10;
    Button lvl11;
    Button lvl12;
    Button back;

    MediaPlayer music;

    TextView coin;

    RelativeLayout creditsLay;
    RelativeLayout settingsLay;
    RelativeLayout buyMenu;
    RelativeLayout topLay;
    RelativeLayout chaptersLay;

    Switch buton;
    Switch muzik;

    veri_bilgi vb;

    AdView banner;
    private RewardedVideoAd mAd;
    private BillingClient mBillingClient;
    private CountDownTimer countDownTimer;
    long sayac=0;
    int holy_30sayac=0;
    int holy_75sayac=0;
    int holy_100sayac=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);

        MobileAds.initialize(this, "ca-app-pub-6773500290196994~3213845800");
        banner = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);

        MobileAds.initialize(this, "ca-app-pub-6773500290196994~3213845800");
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();


        mBillingClient = BillingClient.newBuilder(this).setListener(this).build(); //BillingClient objemizi oluşturduk
        mBillingClient.startConnection(new BillingClientStateListener() { //satın almaya hazır mı kontrolü
            @Override
            public void onBillingSetupFinished(@BillingClient.BillingResponse int billingResponseCode) {
                if (billingResponseCode == BillingClient.BillingResponse.OK) {
                    // Satın almaya hazır
                    // BUTONLARI AKTIF ET
                    //enableOrDisableButtons(true); //butonları aktif et
                } else {
                    //TODO Kullanıcıya uyarı ver
                    // Satın almaya hazır değil
                    //enableOrDisableButtons(false);//butonları pasif et
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                // Servise Bağlanamadı
                //TODO Kullanıcıya uyarı ver
                //enableOrDisableButtons(false);//butonları pasif et
            }
        });

        holy_30 = (Button)findViewById(R.id.holy_30);
        holy_30.setOnClickListener(this);
        holy_75 = (Button)findViewById(R.id.holy_75);
        holy_75.setOnClickListener(this);
        holy_100 = (Button)findViewById(R.id.holy_100);
        holy_100.setOnClickListener(this);




        vb = new veri_bilgi(this);
        vb.ac();

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

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(this);
        chaptersLay=(RelativeLayout)findViewById(R.id.chapters); 
        lvl1 = (Button) findViewById(R.id.lvl1);
        lvl2 = (Button) findViewById(R.id.lvl2);
        lvl3 = (Button) findViewById(R.id.lvl3);
        lvl4 = (Button) findViewById(R.id.lvl4);
        lvl5 = (Button) findViewById(R.id.lvl5);
        lvl6 = (Button) findViewById(R.id.lvl6);
        lvl7 = (Button) findViewById(R.id.lvl7);
        lvl8 = (Button) findViewById(R.id.lvl8);
        lvl9 = (Button) findViewById(R.id.lvl9);
        lvl10 = (Button) findViewById(R.id.lvl10);
        lvl11 = (Button) findViewById(R.id.lvl11);
        lvl12 = (Button) findViewById(R.id.lvl12);
        lvl1.setOnClickListener(this);
        lvl2.setOnClickListener(this);
        lvl3.setOnClickListener(this);
        lvl4.setOnClickListener(this);
        lvl5.setOnClickListener(this);
        lvl6.setOnClickListener(this);
        lvl7.setOnClickListener(this);
        lvl8.setOnClickListener(this);
        lvl9.setOnClickListener(this);
        lvl10.setOnClickListener(this);
        lvl11.setOnClickListener(this);
        lvl12.setOnClickListener(this);
        cikis3=(Button)findViewById(R.id.close3);
        cikis3.setOnClickListener(this);
        creditsLay=(RelativeLayout) findViewById(R.id.credits);
        info=(Button)findViewById(R.id.info);
        info.setOnClickListener(this);
        topLay=(RelativeLayout)findViewById(R.id.topLay);
        buyMenu=(RelativeLayout)findViewById(R.id.buymenu);
        buy=(Button)findViewById(R.id.buyCoin);
        buy.setOnClickListener(this);
        coin=(TextView)findViewById(R.id.main_credit);
        coin.setText(vb.get_credit()+"   ");
        newgame=(Button)findViewById(R.id.newGame);
        newgame.setOnClickListener(this);
        music= MediaPlayer.create(MainMenu.this,R.raw.morning_stroll);
        settings=(Button)findViewById(R.id.settings);
        cikis=(Button)findViewById(R.id.close);
        cikis.setOnClickListener(this);
        cikis2=(Button)findViewById(R.id.close2);
        reklam_buton = (Button)findViewById(R.id.getFree);
        reklam_buton.setOnClickListener(this);
        cikis2.setOnClickListener(this);
        settingsLay=(RelativeLayout)findViewById(R.id.settingsLay);
        settings.setOnClickListener(this);
        buton=(Switch)findViewById(R.id.button_ses);
        muzik=(Switch)findViewById(R.id.muzik_switch);
        buton.setOnClickListener(this);
        muzik.setOnClickListener(this);
        if(Integer.parseInt(vb.get_muzik())==0) {
            music.start();
            muzik.setChecked(true);
        }else{
            muzik.setChecked(false);
        }
        if(Integer.parseInt(vb.get_buton_ses())==0) {
            buton.setChecked(true);
        }else{
            buton.setChecked(false);
        }

        ((Button) findViewById(R.id.getFree)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRewardedVideoAd();
                if(sayac==0) {
                    startVideoAdd();
                }
                else if(sayac!=0) {
                    Toast.makeText(getBaseContext(), "Remaining for Free Holy Coins: " + (sayac/60)+":"+(sayac%60), Toast.LENGTH_SHORT).show();
                }
                }
        });

    }
    @Override
    public void onClick(View v){
        if(newgame.getId()==((Button)v).getId()){
        chaptersLay.setVisibility(View.VISIBLE);
        topLay.setVisibility(View.INVISIBLE);
        settings.setVisibility(View.INVISIBLE);
        newgame.setVisibility(View.INVISIBLE);
    }else if(back.getId()==((Button)v).getId()){
            chaptersLay.setVisibility(View.INVISIBLE);
            topLay.setVisibility(View.VISIBLE);
            settings.setVisibility(View.VISIBLE);
            newgame.setVisibility(View.VISIBLE);
        }else if(lvl1.getId()==v.getId()){
            vb.set_chapter(0);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk1()));
            Game();
    
        }else if(lvl2.getId()==v.getId() && Integer.parseInt(vb.get_sayac2())==1){
            vb.set_chapter(1);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk2()));
            Game();
        }
        else if(lvl3.getId()==v.getId() && Integer.parseInt(vb.get_sayac3())==1){
            vb.set_chapter(2);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk3()));
            Game();
        }
    
        else if(lvl4.getId()==v.getId() && Integer.parseInt(vb.get_sayac4())==1){
            vb.set_chapter(3);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk4()));
            Game();
        }
    
        else if(lvl5.getId()==v.getId() && Integer.parseInt(vb.get_sayac5())==1){
            vb.set_chapter(4);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk5()));
            Game();
        }
    
        else if(lvl6.getId()==v.getId() && Integer.parseInt(vb.get_sayac6())==1){
            vb.set_chapter(5);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk6()));
            Game();
        }
    
        else if(lvl7.getId()==v.getId() && Integer.parseInt(vb.get_sayac7())==1){
            vb.set_chapter(6);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk7()));
            Game();
        }
    
        else if(lvl8.getId()==v.getId() && Integer.parseInt(vb.get_sayac8())==1){
            vb.set_chapter(7);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk8()));
            Game();
        }
    
    
        else if(lvl9.getId()==v.getId() && Integer.parseInt(vb.get_sayac9())==1){
            vb.set_chapter(8);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk9()));
            Game();
        }
    
        else if(lvl10.getId()==v.getId() && Integer.parseInt(vb.get_sayac10())==1){
            vb.set_chapter(9);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk10()));
            Game();
        }
    
        else if(lvl11.getId()==v.getId() && Integer.parseInt(vb.get_sayac11())==1){
            vb.set_chapter(10);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk11()));
            Game();
        } else if(lvl12.getId()==v.getId() && Integer.parseInt(vb.get_sayac12())==1){
            vb.set_chapter(11);
            vb.set_knowing_words(Integer.parseInt(vb.get_bk12()));
            Game();
        }else if(cikis3.getId()==((Button)v).getId()){
            creditsLay.setVisibility(View.INVISIBLE);
        }else if(info.getId()==((Button)v).getId()){
            creditsLay.setVisibility(View.VISIBLE);
        }else if(holy_30.getId()==((Button)v).getId()){
            buyProduct("holy_coins");
            holy_30sayac=1;
        }else if(holy_75.getId()==((Button)v).getId()){
            buyProduct("holy_coins75");
            holy_75sayac=1;
        }else if(holy_100.getId()==((Button)v).getId()){
            buyProduct("holy_coins100");
            holy_100sayac=1;
        }else if(cikis2.getId()==((Button)v).getId()){
            buyMenu.setVisibility(View.INVISIBLE);
            newgame.setVisibility(View.VISIBLE);
            settings.setVisibility(View.VISIBLE);
        }else if(buy.getId()==((Button)v).getId()){
            settings.setVisibility(View.INVISIBLE);
            buyMenu.setVisibility(View.VISIBLE);
            newgame.setVisibility(View.INVISIBLE);
        }else if(buton.getId()==((Button)v).getId()){
            vb.buton_ses_arttir();
        }else if(muzik.getId()==((Button)v).getId()) {
            vb.muzik_arttir();
            if(Integer.parseInt(vb.get_muzik())==1)
                music.pause();
            else
                music.start();
        }else if(settings.getId()==((Button)v).getId()){
            topLay.setVisibility(View.INVISIBLE);
            settingsLay.setVisibility(View.VISIBLE);
            newgame.setVisibility(View.INVISIBLE);
        }else if(cikis.getId()==((Button)v).getId()){
            settingsLay.setVisibility(View.INVISIBLE);
            newgame.setVisibility(View.VISIBLE);
            topLay.setVisibility(View.VISIBLE);
        }
    }

    private void loadRewardedVideoAd(){
        if(!mAd.isLoaded()){
            mAd.loadAd("ca-app-pub-6773500290196994/3166308991",new AdRequest.Builder().build());
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
     loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        vb.kredi_arttir();
        coin.setText(vb.get_credit()+"   ");
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(getBaseContext(),
                "Ad left application.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        //Toast.makeText(getBaseContext(), "Ad failed to load.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        start();
        }



    public void startVideoAdd(){
        if(mAd.isLoaded()){
            mAd.show();
        }
    }
    @Override
    protected void onPause(){
        mAd.pause(this);
        music.pause();
        //vb.kapat();
        super.onPause();
    }

    public void Game(){
        Intent intent = new Intent(MainMenu.this,Game.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    protected void onResume(){
        mAd.resume(this);
        //vb.ac();
        if(Integer.parseInt(vb.get_muzik())==0) {
            music.start();
            muzik.setChecked(true);
        }else{
            muzik.setChecked(false);
        }
        if(Integer.parseInt(vb.get_buton_ses())==0) {
            buton.setChecked(true);
        }else{
            buton.setChecked(false);
        }
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
        coin.setText(vb.get_credit()+"   ");
        super.onResume();
    }


    @Override
    public void onDestroy(){
    mAd.destroy(this);
    //vb.kapat();
    super.onDestroy();
    }
    @Override
    public void onRestart(){
        music.start();
        super.onRestart();
    }

    @Override
    public void onPurchasesUpdated(int responseCode, @Nullable final List<Purchase> purchases) {
        if (responseCode == BillingClient.BillingResponse.OK
        && purchases != null) {
        for (final Purchase purchase : purchases) {
                mBillingClient.consumeAsync(purchase.getPurchaseToken(), new ConsumeResponseListener() {
                    @Override
                    public void onConsumeResponse(int responseCode, String purchaseToken) {
                        if (responseCode == BillingClient.BillingResponse.OK) {
                            //satın alma tamamlandı yapacağınız işlemler
                            if(holy_30sayac==1){
                                vb.kredi_arttir30();
                                coin.setText(vb.get_credit()+"   ");
                                holy_30sayac=0;
                            }
                            else if(holy_75sayac==1){
                                vb.kredi_arttir75();
                                coin.setText(vb.get_credit()+"   ");
                                holy_75sayac=0;
                            }
                            else if(holy_100sayac==1){
                                vb.kredi_arttir100();
                                coin.setText(vb.get_credit()+"   ");
                                holy_100sayac=0;
                            }

                        }
                    }
                });
            }
        } else if (responseCode == BillingClient.BillingResponse.USER_CANCELED) {//kullanıcı iptal etti
            // Handle an error caused by a user canceling the purchase flow.
            holy_100sayac=0;
            holy_75sayac=0;
            holy_30sayac=0;
            billingCanceled(); //kullanıcı iptal etti

        } else {
            holy_75sayac=0;
            holy_30sayac=0;
            holy_100sayac=0;
            billingCanceled(); //bir sorun var
        }
    }

    private void billingCanceled() {
        holy_100sayac=0;
        holy_75sayac=0;
        holy_30sayac=0;
        //Kullanıcı iptal ettiğinde yapılacak işlemler
    }

    private void buyProduct(String skuId) {
        //Bir defa satın almak için
        //Buradaki skuId , google playde tanımladığımız id'ler olmalı
        BillingFlowParams flowParams = BillingFlowParams.newBuilder()
                .setSku(skuId)
                .setType(BillingClient.SkuType.INAPP)
                .build();
        mBillingClient.launchBillingFlow(this, flowParams);
    }

    private void buySubscription(String skuId) {
        //haftalık,aylık,3 aylık,6 aylık ,yıllık üyelik için
        //Buradaki skuId , google playde tanımladığımız id'ler olmalı
        BillingFlowParams flowParams = BillingFlowParams.newBuilder()
                .setSku(skuId)
                .setType(BillingClient.SkuType.SUBS)
                .build();
        mBillingClient.launchBillingFlow(this, flowParams);
    }
    /*private void enableOrDisableButtons(boolean isEnabled) {
        holy_30.setEnabled(isEnabled);
        /*holy_75.setEnabled(isEnabled);
        holy_100.setEnabled(isEnabled);*/
    //}
    public  void start(){
        countDownTimer = new CountDownTimer(900*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sayac = millisUntilFinished / 1000;
            }
            @Override
            public void onFinish() {
                sayac = 0;
            }
        };
        countDownTimer.start();
    }
    public void onBackPressed(){
        chaptersLay.setVisibility(View.INVISIBLE);
        topLay.setVisibility(View.VISIBLE);
        settings.setVisibility(View.VISIBLE);
        newgame.setVisibility(View.VISIBLE);
    }
}

