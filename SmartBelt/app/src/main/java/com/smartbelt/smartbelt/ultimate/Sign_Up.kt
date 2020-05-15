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
            val Change = Intent(this@Sign_Up, Sign_In::class.java)
            startActivity(Change)
        }




        setup()



    }//Aqui termina OnCreate

    private fun setup(){
        Register_btn.setOnClickListener{
            if (Email_SU.text.isNotEmpty()&& Password_SU.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email_SU.text.toString(), Password_SU.text.toString())
                        .addOnCompleteListener(){
                            if (it.isSuccessful){
                                showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                                val Change = Intent(this, Sign_In::class.java)
                                startActivity(Change)


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



    private fun showHome(email: String?, provider: ProviderType){
        val homeIntent = Intent(this, Sign_In::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider)
        }
        startActivity(homeIntent)

        }
    }


