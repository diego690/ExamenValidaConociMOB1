package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.myapplication.Adapter.CountryAdapter;
import com.example.myapplication.Adapter.UsuarioAdapter;
import com.example.myapplication.Model.Country;
import com.example.myapplication.Model.Usuario;
import com.example.myapplication.WebService.Asynchtask;
import com.example.myapplication.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");


    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Country> lstUsuarios = new ArrayList<Country> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

            lstUsuarios = Country.JsonObjectsBuild(JSONlistaUsuarios);

            CountryAdapter adapatorUsuario = new CountryAdapter(this, lstUsuarios);

            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                    resId);
            recyclerView.setLayoutAnimation(animation);

            recyclerView.setAdapter(adapatorUsuario);



        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }


    }
}