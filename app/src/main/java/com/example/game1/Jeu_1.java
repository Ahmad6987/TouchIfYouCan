package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Jeu_1 extends AppCompatActivity {
    int score=0;
    private Button buttonRetour,b1,b2,b3,b4,b5,b6,b7;
    private int counter=10;
    private TextView textViewTimer,textViewScore,textView3,textView4;
    private int time=0;
    ArrayList<Button> buttonList=new ArrayList<>();
    private Thread th;
    private Handler hd;
    private SharedPreferences sharredPrefrencesScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_1);
        //      Mettre entre les   liens variable et les références
        textViewScore=(TextView)findViewById(R.id.textViewScore);
        textViewTimer=(TextView)findViewById(R.id.textViewTimer);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        //Remplire la list
        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        buttonList.add(b7);
        buttonRetour=(Button)findViewById(R.id.buttonRetour1);
        buttonRetour.setVisibility(View.INVISIBLE);

         hd =new Handler();
        th=new Thread(){
            @Override
            public void run() {
                hd.postDelayed(th,1000);
                counter--;
               textViewTimer.setText(String.valueOf(counter));
               //appeler la fonction qui permet d'afficher une boutton dune façon aléatoire
                randomNumber();
                //appeler la fonctin qui permet de compter le nombre de fois de clique sur les bouttons
                clickCount();
                if(counter==0){
                    textViewTimer.setVisibility((View.GONE));
                    buttonRetour.setVisibility(View.VISIBLE);
                    textViewScore.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    textViewScore.setText(String.valueOf(score));
                    textView3.setVisibility(View.INVISIBLE);
                    Disparaitre();
                    //sharredPrefrencesScore=getSharedPreferences("data",MODE_PRIVATE);
                    hd.removeCallbacks(th);
                }
            }
        };
        th.run();
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //Créer fonction qui permet d'afficher une boutton dune façon aléatoire
    void randomNumber(){
        for(int i=0; i<buttonList.size();i++){
            buttonList.get(i).setVisibility(View.INVISIBLE);
        }
        int resultRandom;
        Random r =new Random();
        resultRandom=r.nextInt(7);
        buttonList.get(resultRandom).setVisibility(View.VISIBLE);

    }
    //Créer une fonction qui cache la dernière boutton
    void Disparaitre(){
        for(int i=0; i<buttonList.size();i++){
            buttonList.get(i).setVisibility(View.INVISIBLE);
        }
    }
    //Créer une fonction qui permet de compter le nombre de fois de clique sur les bouttons
    void clickCount() {
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    score++;
                }
            });
        }
    }
}