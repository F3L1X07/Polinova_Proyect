package com.smartbelt.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LOGCAT", "Inicialización del método Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("LOGCAT", "Inicialización del método Resumen");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LOGCAT", "Inicialización del método Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("LOGCAT", "Inicialización del método Destroy");
    }
}
