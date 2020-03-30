package com.SmartBelt.PolinovaProyect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    //Declaracion de bton GetStarted


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Information LOG", "Entrada al método onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Information LOG", "Entrada al método onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Information LOG", "Entrada al método onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Information LOG", "Entrada al método onDestroy");
    }
}
