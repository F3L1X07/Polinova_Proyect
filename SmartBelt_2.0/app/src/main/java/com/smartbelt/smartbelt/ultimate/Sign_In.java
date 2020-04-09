package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Sign_In extends AppCompatActivity {

    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        //Cambio de Activity (Botones)
        Back = (ImageView) findViewById(R.id.Back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GetStarted = new Intent(Sign_In.this, Get_Start.class);
                startActivity(GetStarted);
            }
        });
    }
}
