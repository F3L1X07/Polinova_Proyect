package com.SmartBelt.PolinovaProyect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign_In extends AppCompatActivity {
   // private TextView txtNoticePrivacy;
   private TextView Privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Privacy = findViewById(R.id.Privacy);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final EditText UserT = (EditText)findViewById(R.id.Username_SI);
        final EditText PasswordT = (EditText)findViewById(R.id.Password_SI);





        Privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, popup_privacy.class));
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String User = UserT.getText().toString();
                final String Password = PasswordT.getText().toString();
                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok  = jsonRespuesta.getBoolean("success");
                            if (ok == true){
                                String User = jsonRespuesta.getString("User");
                                String Password = jsonRespuesta.getString("Password");
                                Intent bienvenido = new Intent(Sign_In.this, Bienvenido.class );
                                bienvenido.putExtra("User", User);
                                bienvenido.putExtra("Password", Password);

                                Sign_In.this.startActivity(bienvenido);
                                Sign_In.this.finish();

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Sign_In.this);
                                alerta.setMessage("Fallo en el Login").setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.getMessage();
                        }
                    }
                };

            }
        });

    }
}
