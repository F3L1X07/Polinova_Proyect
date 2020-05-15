package com.smartbelt.smartbelt.ultimate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.firebase.ui.auth.AuthUI.IdpConfig.FacebookBuilder
import com.firebase.ui.auth.AuthUI.IdpConfig.GoogleBuilder
import com.firebase.ui.auth.util.ui.PreambleHandler.setup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import kotlinx.android.synthetic.main.signin_activity.*
import kotlinx.android.synthetic.main.signup_activity.*
import java.util.*
import kotlin.jvm.java as java1


enum class ProviderType{
    BASIC
}


class Sign_In : AppCompatActivity() {
    private var Back: ImageView? = null
    private var privacy_ventana: TextView? = null
    var mfirebaseAuth: FirebaseAuth? = null
    var mAuthListener: AuthStateListener? = null
    var provider = Arrays.asList(
            FacebookBuilder().build(),
            GoogleBuilder().build()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)
        //Cambio de Activity (Botones)
        Back = findViewById<View>(R.id.Back_btn) as ImageView
        Back!!.setOnClickListener {
            val Change = Intent(this@Sign_In, Get_Start::class.java1)
            startActivity(Change)

        }

        privacy_ventana = findViewById(R.id.Privacy_SI)
        privacy_ventana!!.setOnClickListener {

            val Change2 = Intent(this@Sign_In, PopUp_Privacy::class.java1)
            startActivity(Change2)
        }

        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")

        setup(email ?: "", provider ?: "")
    } //Aqui termina OnCreate

    private fun setup(email: String, provider: String) {
        Email_SI.text = email
        Password_SI.text = provider

        Sign_in_btn.setOnClickListener {
            if (Email_SU.text.isNotEmpty() && Password_SU.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(Email_SU.text.toString(), Password_SU.text.toString())
                        .addOnCompleteListener() {
                            if (it.isSuccessful) {
                                showHome2(it.result?.user?.email ?: "", ProviderType.BASIC)





                            } else {
                                showAlert()

                            }
                        }
            }//fin if
        }


    cerrar_sesion_btn.setOnClickListener{
        FirebaseAuth.getInstance().signOut()
        val Change = Intent(this, Sign_Up::class.java1)
        startActivity(Change)
    }

}


        private fun showAlert() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Se ha producido un error de autentificacion ")
            builder.setPositiveButton("Aceptar", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }


        private fun showHome2(email: String?, provider: ProviderType) {
            val homeIntent = Intent(this, MainActivity::class.java1).apply {
                putExtra("email", email)
                putExtra("provider", provider)
            }
          //  startActivity(homeIntent)
        }



    }


