package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PopUp_Information extends AppCompatActivity {

    private ImageView Exit;
    private Button Accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_information_activity);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int largo = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85), (int)(largo *0.8));

        Exit = findViewById(R.id.Exit_Image);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopUp_Information.this, Get_Start.class));
            }
        });

        Accept = findViewById(R.id.Accept_btn);
        Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopUp_Information.this, Get_Start.class));
            }
        });
    }
}
