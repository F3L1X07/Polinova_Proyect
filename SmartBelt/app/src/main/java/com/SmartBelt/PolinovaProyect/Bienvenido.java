package com.SmartBelt.PolinovaProyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
         final TextView mensaje = (TextView)findViewById(R.id.mensaje);
        Intent i = this.getIntent();
        String User = i.getStringExtra("User");
        String Password = i.getStringExtra("Password");
        mensaje.setText(mensaje.getText()+" "+User+ "Su password"+ Password+"");

    }
}
