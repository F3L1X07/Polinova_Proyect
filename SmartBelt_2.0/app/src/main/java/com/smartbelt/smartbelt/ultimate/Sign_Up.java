package com.smartbelt.smartbelt.ultimate;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Sign_Up extends AppCompatActivity {

    private ImageView Back;
    private TextView privacy_ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        //Cambio de Activity (Botones)
        Back = (ImageView) findViewById(R.id.Back_btn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GetStarted = new Intent(Sign_Up.this, Get_Start.class);
                startActivity(GetStarted);
            }
        });

        privacy_ventana = findViewById(R.id.Privacy_SU);
        privacy_ventana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_Up.this, PopUp_Privacy.class));
            }
        });


        final Button boton_registrar = findViewById(R.id.Register_btn);
        final EditText nombre_usuario = findViewById(R.id.Username_SU);
        final EditText email_usuario = findViewById(R.id.Email_SU);
        final EditText contrasena_usuario = findViewById(R.id.Password_SU);

        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = nombre_usuario.getText().toString();
                String Email = email_usuario.getText().toString();
                String Password = contrasena_usuario.getText().toString();
                new DescargarImagen(Sign_Up.this).execute(User,Email,Password);
            }
        });

    }


    public static class DescargarImagen extends AsyncTask<String, Void,String>{

        private WeakReference<Context> context;

        public DescargarImagen (Context context)
        {
            this.context = new WeakReference<>(context);
        }
        protected String doInBackground(String...params){
            String registrar_url = "http://smartbelt.ueuo.com/Registro.php";
            String resultado;

            try {
                URL url = new URL(registrar_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

                String User = params[0];
                String Email = params[1];
                String Password = params[2];

                String data = URLEncoder.encode("Username_SU","UTF-8") + "=" + URLEncoder.encode(User, "UTF-8")
                        + "&" + URLEncoder.encode("Email_SU", "UTF-8") + "=" + URLEncoder.encode(Email, "UTF-8")
                        + "&" + URLEncoder.encode("Password_SU", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream  inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) !=null){
                    stringBuilder.append(line);
                }
                resultado = stringBuilder.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (MalformedURLException e){
                Log.d("MiAPP", "Se ha utilizado una URL con formato incorrecto");
                resultado = "Se ha producido un error";
            } catch (IOException e){
                Log.d("MiAPP", "Error inesperado, posible problema de conexion de red");
                resultado = "Se ha producido un error, compruebe conexion a internet";
            }
            return resultado;

        }

        protected void onPostExecute(String resultado){
        Toast.makeText(context.get(), resultado, Toast.LENGTH_LONG).show();
    }
}



}
