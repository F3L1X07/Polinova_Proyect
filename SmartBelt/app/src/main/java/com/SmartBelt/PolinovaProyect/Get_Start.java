package com.SmartBelt.PolinovaProyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Get_Start extends AppCompatActivity {
    Button GetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstart);
        GetStarted = (Button)findViewById(R.id.GetStarted);
        GetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GetStarted = new Intent(Get_Start.this, Sign_Up.class);
                startActivity(GetStarted);
            }
        });
    }
}
