package com.smartbelt.smartbelt.ultimate;

<<<<<<< HEAD
import android.content.Intent;
=======
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
>>>>>>> ed7c497e4b29369d0c7fac2ad2cf4c3626ecede8
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
=======
>>>>>>> ed7c497e4b29369d0c7fac2ad2cf4c3626ecede8

public class Sign_In extends AppCompatActivity  {

    private ImageView Back;
    private TextView privacy_ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        //Cambio de Activity (Botones)
        Back = (ImageView) findViewById(R.id.Back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Change = new Intent(Sign_In.this, Get_Start.class);
                startActivity(Change);
            }
        });


        privacy_ventana = findViewById(R.id.Privacy_SI);
        privacy_ventana.setOnClickListener(new View.OnClickListener() {
<<<<<<< HEAD
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Sign_In.this, Pop_up_privacy.class));
    }
});
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext( ), "No se ha encontrado el usuario" + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(getApplicationContext(), "Se ha encontrado el usuario" + cajaUser.getText().toString(), Toast.LENGTH_LONG).show();
        User usuario = new User();
        JSONArray jsonArrayRequest = response.optJSONArray("datos");
        JSONObject jsonObject = null;
        try {
            jsonObject = ((JSONArray) jsonArrayRequest).getJSONObject(0);
            usuario.setUser(jsonObject.optString("User"));
            usuario.setPassword(jsonObject.optString("Password"));
            usuario.setID(jsonObject.optString("ID"));


        }
        catch (JSONException e){
            e.printStackTrace();
        }


    }

    private  void iniciarSesion(){
        String url = "http://192.168.1.77/login/sesion.php?User=" + cajaUser.getText().toString()+
                "&Password="+cajaPwd.getText().toString();

        jrq = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        rq.add(jrq);
=======
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, PopUp_Privacy.class));
            }
        });
>>>>>>> ed7c497e4b29369d0c7fac2ad2cf4c3626ecede8
    }
}
