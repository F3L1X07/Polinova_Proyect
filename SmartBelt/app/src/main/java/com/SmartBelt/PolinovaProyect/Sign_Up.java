package com.SmartBelt.PolinovaProyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sign_Up extends AppCompatActivity {
    private TextView txtNoticePrivacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtNoticePrivacy = findViewById(R.id.txtNoticePrivacy);
        txtNoticePrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_Up .this, Popup_Notice_Of_Privacy.class));
            }
        });
    }
}
