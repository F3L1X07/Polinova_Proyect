package com.smartbelt.smartbelt.ultimate;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Pacient_Info extends AppCompatActivity {

    private Button Cancel;

    DatabaseReference mRootReference; //referencia a la base de datos
    Button mButtonSubirDatosFirebase;
    EditText mEditTextDatoName;
    EditText mEditTextDatoLocation;
    EditText mEditTextDatoWeight;
    EditText mEditTextDatoHeight;
    EditText mEditTextDatoCellphone;
    EditText mEditTextDatoEmail;
    //EditText mEditTextDatoBirthday;
    EditText mEditTextDatoMedicalHistory;


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

        mRootReference = FirebaseDatabase.getInstance().getReference(); //inica referencia en el nodo principal.
        mButtonSubirDatosFirebase = findViewById(R.id.btn_Accept);
        mEditTextDatoName = findViewById(R.id.P_Name);
        mEditTextDatoLocation = findViewById(R.id.P_Location);
        mEditTextDatoWeight = findViewById(R.id.P_Weight);
        mEditTextDatoHeight = findViewById(R.id.P_Height);
        mEditTextDatoCellphone = findViewById(R.id.P_Cellphone);
        mEditTextDatoEmail = findViewById(R.id.P_Email);
        //mEditTextDatoBirthday = findViewById(R.id.P_Date);
        mEditTextDatoMedicalHistory = findViewById(R.id.P_H_Medic);


        mButtonSubirDatosFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = mEditTextDatoName.getText().toString();
                String Location = mEditTextDatoLocation.getText().toString();
                int Weight = Integer.parseInt(mEditTextDatoWeight.getText().toString());
                float Height = Float.parseFloat(mEditTextDatoHeight.getText().toString());
                int Cellphone = Integer.parseInt(mEditTextDatoCellphone.getText().toString());
                String Email = mEditTextDatoEmail.getText().toString();
               // String Birthday = mEditTextDatoBirthday.getText().toString();
                String MedicalHistory = mEditTextDatoMedicalHistory.getText().toString();

                cargarDatosFirebase(Name, Location, Weight, Height, Cellphone, Email, MedicalHistory);
            }
        });

    }// Aqui termina OnCreate

    private void cargarDatosFirebase(String name, String location, int weight, float height, int cellphone, String email, String medicalHistory) {
        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("Name", name);
        datosUsuario.put("Location", location);
        datosUsuario.put("Weight", weight);
        datosUsuario.put("Height", height);
        datosUsuario.put("Cellphone", cellphone);
        datosUsuario.put("Email", email);
        //datosUsuario.put("Birthday", Birthday);
        datosUsuario.put("MedicalHistory", medicalHistory);

        mRootReference.child("Usuarios").push().setValue(datosUsuario);
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
