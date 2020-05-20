package com.smartbelt.smartbelt.ultimate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pacient extends AppCompatActivity {

    private ImageView Exit;
    private Button Edit;

    TextView msj, msj1,msj2,msj3,msj4,msj5,msj6;

   //TextView tvInfoEnviadaName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacient_activity);

        msj = (TextView) findViewById(R.id.P_Name);
        msj1 = (TextView) findViewById(R.id.Txt_Loca);
        msj2 = (TextView) findViewById(R.id.Txt_Kg);
        msj3 = (TextView) findViewById(R.id.Txt_Cm);
        msj4 = (TextView) findViewById(R.id.Txt_Cellphone);
        msj5 = (TextView) findViewById(R.id.Txt_Email);
        msj6 = (TextView) findViewById(R.id.Txt_H_Medic);

        Bundle myBundle = this.getIntent().getExtras();
        if ( myBundle !=null){
           String nombre = myBundle.getString("Name");
            String location = myBundle.getString("Location");
            String weight = myBundle.getString("Weight");
            String height = myBundle.getString("Height");
            String cellphone = myBundle.getString("Cellphone");
            String email = myBundle.getString("Email");
            String medicalhistory = myBundle.getString("MedicalHistory");

            msj.setText(nombre);
            msj1.setText(location);
            msj2.setText(weight);
            msj3.setText(height);
            msj4.setText(cellphone);
            msj5.setText(email);
            msj6.setText(medicalhistory);

        }

        //Recibir Info del Pacient Info
    /*    tvInfoEnviadaName = (TextView)findViewById(R.id.P_Name_P);


        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("Name").toString();
        tvInfoEnviadaName.setText(dato);
*/
        //Regreso al Activity anterior
        Exit = (ImageView) findViewById(R.id.btn_Exit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Cambio al Activity seleccionado
        Edit = (Button) findViewById(R.id.btn_Edit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Change = new Intent(Pacient.this, Pacient_Info.class);
                startActivity(Change);
            }
        });

        //Inicialización de "Pacient" como ventana PopUp
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.95), (int) (alto * 0.9));
    }
}
