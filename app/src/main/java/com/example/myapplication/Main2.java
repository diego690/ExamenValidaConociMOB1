package com.example.myapplication;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CountryAdapter;
import com.example.myapplication.Model.Country;

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
    protected void onCreate() {
        onCreate();
    }


}
