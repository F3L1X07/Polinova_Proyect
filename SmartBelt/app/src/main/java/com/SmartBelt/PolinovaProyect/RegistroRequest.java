package com.SmartBelt.PolinovaProyect;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.*;

public class RegistroRequest extends StringRequest {
    private  static final String ruta ="https://smartbeltbd.000webhostapp.com/registro.php";

    private Map<String, String> parametros;
    public RegistroRequest (String User, String Password, String Email,  Response.Listener<String> listener){
        super(Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("User",User+"");
        parametros.put("Password",Password+"");
        parametros.put("Email", Email+"");

        }

    @Override
    protected Map<String, String> getParams() {

         return parametros;
    }
}


