package com.SmartBelt.PolinovaProyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class Popup_Notice_Of_Privacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup__notice__of__privacy);

        DisplayMetrics medidaVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int ancho = medidaVentana.widthPixels;
        int alto = medidaVentana.heightPixels;
        getWindow() .setLayout((int)(ancho * 0.80), (int)(alto * 0.6));

    }
}
