package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Sign_In extends AppCompatActivity  {

    private ImageView Back;
    private TextView privacy_ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        //Cambio de Activity (Botones)
        Back = (ImageView) findViewById(R.id.Back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Change = new Intent(Sign_In.this, Get_Start.class);
                startActivity(Change);
            }
        });


        privacy_ventana = findViewById(R.id.Privacy_SI);
        privacy_ventana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, PopUp_Privacy.class));
            }
        });
    }
}
