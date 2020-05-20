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
//import kotlin.jvm.java as java1


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
            val Change6 = Intent(this@Sign_In, Get_Start::class.java)
            startActivity(Change6)

        }

        privacy_ventana = findViewById(R.id.Privacy_SI)
        privacy_ventana!!.setOnClickListener {

            val Change7 = Intent(this@Sign_In, PopUp_Privacy::class.java)
            startActivity(Change7)
        }

        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val password: String? = bundle?.getString("password")

        setup(email ?: "", password ?:"")
    } //Aqui termina OnCreate

    private fun setup(email: String, password: String) {
      //  Email_SI.text = email
        //Password_SI.text = password

        To_access_btn.setOnClickListener{
            if (Email_SI.text.isNotEmpty() && Password_SI.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(Email_SI.text.toString(),
                         Password_SI.text.toString())
                        .addOnCompleteListener() {

                            if (it.isSuccessful) {
                             //  showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                                val Changesr = Intent(this, MainActivity::class.java)
                                startActivity(Changesr)
                            } else {
                                showAlert()

                            }
                        }
            }//fin if
        }

        Sign_off_btn.setOnClickListener{
        FirebaseAuth.getInstance().signOut()
            onBackPressed()
      //  val Change2 = Intent(this, Get_Start::class.java)
        //startActivity(Change2)
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


   /*    private fun showHome(email: String?, provider: ProviderType) {
            val homeIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("email", email)
                putExtra("provider", provider)
            }
           startActivity(homeIntent)
        }
*/


}



