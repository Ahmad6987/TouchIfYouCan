package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Score extends AppCompatActivity {
    private Button buttonBack;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
//      Mettre entre variable et référence
        buttonBack=(Button)findViewById(R.id.buttonRetour2);
        listView=(ListView)findViewById(R.id.list);
        Intent intentScore=getIntent();
        //detruire l'Activity
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}