package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button buttonStart,buttonScore,buttonExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //      Mettre entre les   liens variable et les références
        buttonStart=(Button)findViewById(R.id.buttonStart);
        buttonScore=(Button)findViewById(R.id.buttonScore);
        buttonExit=(Button)findViewById(R.id.buttonExit);
        //les boutons qui redirigent vers les autres Activités
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJeu=new Intent(MainActivity.this,Start.class);
                startActivity(intentJeu);
            }
        });
        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScore=new Intent(MainActivity.this,Score.class);
                startActivity(intentScore);
                //Log.d("tag", "onClick: ");
            }
        });
        //la boutton Exit
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}