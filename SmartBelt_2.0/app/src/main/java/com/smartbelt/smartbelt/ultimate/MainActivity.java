package com.smartbelt.smartbelt.ultimate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    private ImageView Pacient_Menu;
    private ImageView User_Info;
    private WebView Page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cambio de Activity
        Pacient_Menu = findViewById(R.id.Menu_Pacient);
        Pacient_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pacient.class));
            }
        });

        //Mostrar Pagina Web del GPS
        Page = (WebView) findViewById(R.id.Web_GPS);
        Page.getSettings().setJavaScriptEnabled(true); //Permite el correcto funcionamiento de algunas páginas
        Page.getSettings().setBuiltInZoomControls(true); //Permite realizar Zoom si la página no es Responsive
        Page.loadUrl("https://smartbelt.000webhostapp.com");

        //Navegación del WebView
        Page.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading(WebView view, String url) {
                return false; //Permite refrescar la Página en el WebView
            }
        });

    }
}
