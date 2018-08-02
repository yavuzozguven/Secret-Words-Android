package com.example.mert.anagram;


import java.util.Random;


public class gameFunc{
    int bilinen;
    int chapter;
    gameFunc(int a,int b){
        bilinen=a;
        chapter=b;
        kelimeAl();
    }
    String kelime;
    String kelimeA;
    int x;
    public void kelimeAl(){
        WordLibrary wL=new WordLibrary();
        if(chapter==0){
        kelime=wL.a1_1[bilinen];
        kelimeA=wL.a1_1_mean[bilinen];
        x=kelime.length();
        }
        if(chapter==1){
            kelime=wL.a1_2[bilinen];
            kelimeA= wL.a1_2_mean[bilinen];
            x=kelime.length();
       }
        if(chapter==2){
            kelime=wL.a2_3[bilinen];
            kelimeA= wL.a2_3_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==3){
            kelime=wL.a2_4[bilinen];
            kelimeA= wL.a2_4_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==4){
            kelime=wL.b1_5[bilinen];
            kelimeA= wL.b1_5_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==5){
            kelime=wL.b1_6[bilinen];
            kelimeA= wL.b1_6_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==6){
            kelime=wL.b2_7[bilinen];
            kelimeA= wL.b2_7_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==7){
            kelime=wL.b2_8[bilinen];
            kelimeA= wL.b2_8_mean[bilinen];
            x=kelime.length();
        }if(chapter==8){
            kelime=wL.c1_9[bilinen];
            kelimeA= wL.c1_9_mean[bilinen];
            x=kelime.length();
        }if(chapter==9){
            kelime=wL.c1_10[bilinen];
            kelimeA= wL.c1_10_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==10){
            kelime=wL.c2_11[bilinen];
            kelimeA= wL.c2_11_mean[bilinen];
            x=kelime.length();
        }
        if(chapter==11){
            kelime=wL.c2_12[bilinen];
            kelimeA= wL.c2_12_mean[bilinen];
            x=kelime.length();
        }
    }


    public String karistir(){
        Random rand=new Random();
        char[] ac=new char[kelime.length()];
        for (int i = 0; i <kelime.length() ; i++) {
            ac[i]=kelime.charAt(i);
        }
        String test;
        int s1,s2;
        char tmp;
        for (int i = 0; i <= x/2; i++) {
            s1=rand.nextInt(x);
            s2=rand.nextInt(x);
            tmp=ac[s1];
            ac[s1]=ac[s2];
            ac[s2]=tmp;
        }
        test=String.valueOf(ac);
        return test;
    }

}
