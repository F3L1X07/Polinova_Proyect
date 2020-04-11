package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sign_Up extends AppCompatActivity {

    private ImageView Back;
    private TextView privacy_ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        //Cambio de Activity (Botones)
        Back = (ImageView) findViewById(R.id.Back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GetStarted = new Intent(Sign_Up.this, Get_Start.class);
                startActivity(GetStarted);
            }
        });

        privacy_ventana = findViewById(R.id.Privacy_SU);
        privacy_ventana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_Up.this, PopUp_Privacy.class));
            }
        });

    }
}
