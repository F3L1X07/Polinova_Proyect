package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pacient extends AppCompatActivity {

    private ImageView Exit;
    private Button Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacient_activity);

        //Regreso al Activity anterior
        Exit = (ImageView) findViewById(R.id.btn_Exit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Cambio al Activity seleccionado
        Edit = (Button) findViewById(R.id.btn_Edit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Change = new Intent(Pacient.this, Pacient_Info.class);
                startActivity(Change);
            }
        });

        //Inicialización de "Pacient" como ventana PopUp
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.95), (int) (alto * 0.9));
    }
}
