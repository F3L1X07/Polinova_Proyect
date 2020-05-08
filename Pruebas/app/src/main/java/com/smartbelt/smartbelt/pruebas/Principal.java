package com.smartbelt.smartbelt.pruebas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /*WebView myWebView = (WebView) findViewById(R.id.GPS);
        myWebView.loadUrl("http://www.google.com");*/


       /* WebView view = (WebView) findViewById(R.id.Web_GPS);
        view.getSettings().setJavaScriptEnabled(true); //Permite que algunas páginas funcionen coreectamente
        view.getSettings().setBuiltInZoomControls(true); //Permite el zoom si la página web no es responsive
        view.loadUrl("https://smartbelt.000webhostapp.com/");

        //Metodo de Navegación Web en la App
        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading(WebView view, String url) {
                return false; //Permite que la página se refresque en el WebView
            }
        });*/
    }
}
