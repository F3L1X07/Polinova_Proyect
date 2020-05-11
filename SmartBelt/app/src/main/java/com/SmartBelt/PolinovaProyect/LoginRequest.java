package com.SmartBelt.PolinovaProyect;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest  extends StringRequest {
    private  static final String ruta ="https://smartbeltbd.000webhostapp.com/login.php";
    private Map<String, String> parametros;
    public LoginRequest (String User, String Password, Response.Listener<String> listener){
        super(Request.Method.POST, ruta, listener,null);
        parametros = new HashMap<>();
        parametros.put("User",User+"");
        parametros.put("Password",Password+"");

    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}

