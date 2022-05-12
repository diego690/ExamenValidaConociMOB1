package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Adapter.CountryAdapter;
import com.example.myapplication.Model.Country;
import com.example.myapplication.WebService.Asynchtask;
import com.example.myapplication.WebService.WebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrincipalActivity extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView) findViewById(R.id.lstListaUsuario);

        View header = getLayoutInflater().inflate(R.layout.cabecera, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, PrincipalActivity.this, PrincipalActivity.this);
        ws.execute("GET");



    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Country> lstUsuarios = new ArrayList<Country> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);


            lstUsuarios = Country.JsonObjectsBuild(JSONlista);

            CountryAdapter adapatorUsuario = new CountryAdapter(this, lstUsuarios);

            lstOpciones.setAdapter(adapatorUsuario);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }


    }
}