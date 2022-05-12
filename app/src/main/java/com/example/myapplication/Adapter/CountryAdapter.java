package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Country;
import com.example.myapplication.Model.Usuario;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter  extends ArrayAdapter<Country> {

    public CountryAdapter(Context context, ArrayList<Country> datos) {
        super(context, R.layout.items, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.items, null);

        TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
        TextView lblemail = (TextView) item.findViewById(R.id.lblEmail);
        TextView lblweb = (TextView) item.findViewById(R.id.lblweb);

        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);

        Glide.with(this.getContext())
                .load(getItem(position).getUrl_Pais())
                .into(imageView);

        //.error(R.drawable.imgnotfound)


        lblNombre.setText(getItem(position).getNombrePais());
        lblemail.setText(getItem(position).getIso2());
        lblweb.setText(getItem(position).getUrl_Pais());

        return (item);
    }
}
