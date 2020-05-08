package com.smartbelt.smartbelt.ultimate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    private ImageView Pacient_Menu;
    private ImageView User_Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pacient_Menu = findViewById(R.id.Menu_Pacient);
        Pacient_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pacient.class));
            }
        });

    }
}
