package com.SmartBelt.PolinovaProyect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign_Up extends AppCompatActivity {
   // private TextView txtNoticePrivacy;
    private TextView Privacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Privacy = findViewById(R.id.Privacy);
        final EditText UserT = (EditText) findViewById(R.id.Username_SU);
        final EditText PasswordT = (EditText) findViewById(R.id.Password_SU);
        final EditText EmailT = (EditText) findViewById(R.id.Email_SU);

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String User = UserT.getText().toString();
                 String Password = PasswordT.getText().toString();
                 String Email = EmailT.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true) {
                                Intent i = new Intent(Sign_Up.this, Sign_In.class);
                                Sign_Up.this.startActivity(i);
                                Sign_Up.this.finish();
<<<<<<< HEAD

=======
>>>>>>> ccc801c846b7ae29f916de8006bba4cd0aa2f6af
                            } else {
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Sign_Up.this);
                                alerta.setMessage("Fallo en el regisro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {

                            e.getMessage();
                        }

                     }

                };

                RegistroRequest r = new RegistroRequest(User, Password, Email,  respuesta);
                RequestQueue cola = Volley.newRequestQueue(Sign_Up.this);
                cola.add(r);


            }
        });






        Privacy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_Up.this, popup_privacy.class));
            }
        });








    }
}
