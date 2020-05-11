package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class Pacient_Info extends AppCompatActivity {

    private Button Cancel;

    private int Dia;
    private int Mes;
    private int Año;
    private EditText C_Fecha;
    private ImageView btn_Fecha;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener Selector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientinfo_activity);

        //Regreso al Activity anterior
        Cancel = findViewById(R.id.btn_Cancel);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Obtener Instancia de los controles GUI en el Layout
        C_Fecha = (EditText) findViewById(R.id.P_Date);
        btn_Fecha = (ImageView) findViewById(R.id.btn_Date);

        //Obtener Fecha del Dispositivo
        Calendar calendario = Calendar.getInstance();
        Dia = calendario.get(Calendar.DAY_OF_MONTH);
        Mes = calendario.get(Calendar.MONTH);
        Año = calendario.get(Calendar.YEAR);
        M_Fecha();

        Selector = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Dia = dayOfMonth;
                Mes = month;
                Año = year;
                M_Fecha();
            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this, Selector, Dia, Mes, Año);
        }
        return null;
    }

    //Metodo para el Funcionamiento del "Botón" (Mostrar Calendario)
    public void M_Calendar(View control) {
        showDialog(TIPO_DIALOGO);
    }

    public void M_Fecha(){
        //Estructura de la Colocación de las variables en forma de Texto
        C_Fecha.setText(Dia + " / " + (Mes+ 1) + " /  " + Año);
    }
}
