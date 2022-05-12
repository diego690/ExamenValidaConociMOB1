package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.CountryAdapter;
import com.example.myapplication.Model.Country;

import org.json.JSONArray;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class Main2 extends AppCompatActivity {

    private RecyclerView courseRV;

    private CountryAdapter adapter;
    private ArrayList<Country> courseModalArrayList;

    // below line is the variable for url from
    // where we will be querying our data.
    String url = "https://jsonkeeper.com/b/WO6S";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseRV = findViewById(R.id.recyclerView);
        courseModalArrayList = new ArrayList<>();
    }



}
