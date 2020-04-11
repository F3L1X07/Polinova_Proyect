package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; 
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Get_Start extends AppCompatActivity {

    private ImageView App_Info;
    /*private TextView Titulo1;
    private Typeface Brightly;*/

    private LinearLayout Login;
    private LinearLayout Sign_Up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getstart_activity);

        //Fuente de Texto
        /*String fuente1 = "Fonts/Brightly.otf";
        this.Brightly = Typeface.createFromAsset(getAssets(),fuente1);

        //Llamar a TextView para aplicar Fuente
        Titulo1 = (TextView) findViewById(R.id.Title1_GetStart);
        Titulo1.setTypeface(Brightly);*/

        //Cambio de Activity (Botones)
        Login = (LinearLayout) findViewById(R.id.Login_btn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent GetStarted = new Intent (Get_Start.this, Sign_In.class);
                    startActivity(GetStarted);
                }
            });

        Sign_Up = (LinearLayout) findViewById(R.id.SignUp_btn);
        Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent Sign_Up = new Intent(Get_Start.this, Sign_Up.class);
               startActivity(Sign_Up);
            }
        });

        App_Info = findViewById(R.id.Info_btn);
        App_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Get_Start.this, PopUp_Information.class));
            }
        });
    }
}