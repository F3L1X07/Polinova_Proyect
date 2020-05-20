package com.smartbelt.smartbelt.ultimate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.signup_activity.*

class Sign_Up : AppCompatActivity() {
    private var Back: ImageView? = null
     var privacy_ventana: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        //Cambio de Activity (Botones)
        Back = findViewById<View>(R.id.Back_btn) as ImageView
        Back!!.setOnClickListener {
            val Change4 = Intent(this@Sign_Up, Get_Start::class.java)
            startActivity(Change4)
        }


        privacy_ventana = findViewById(R.id.Privacy_SU)
        privacy_ventana!!.setOnClickListener {

            val Change3 = Intent(this@Sign_Up, PopUp_Privacy::class.java)
            startActivity(Change3)
        }

        setup()



    }//Aqui termina OnCreate


    private fun setup(){

        Register_btn.setOnClickListener{
            if (Email_SU.text.isNotEmpty()&& Password_SU.text.isNotEmpty()){

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email_SU.text.toString(),
                        Password_SU.text.toString()).addOnCompleteListener(){
                            if (it.isSuccessful){
                                showHome(it.result?.user?.email?:"", password = "")
                              //  val Change = Intent(this, Sign_In::class.java)
                                //startActivity(Change)


                            }else{
                                showAlert()

                            }
                        }
            }//fin if 1
        }
    }

    private fun showAlert (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error de autentificacion ")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }



    private fun showHome(email: String?, password: String?){
        val homeIntent = Intent(this, Sign_In::class.java).apply {
            putExtra("email", email)
            putExtra("password", password)
        }
        startActivity(homeIntent)

        }
    }


