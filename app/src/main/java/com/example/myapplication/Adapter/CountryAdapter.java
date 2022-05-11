package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Country;
import com.example.myapplication.Model.Usuario;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context Ctx;
    private ArrayList<Country> lstCountrys;

    public CountryAdapter(Context ctx, ArrayList<Country> lstCountrys) {
        Ctx = ctx;
        this.lstCountrys = lstCountrys;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_usuario, null);
        return new CountryAdapter.CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {
        // setting data to our views of recycler view.
        Country modal = lstCountrys.get(position);
        holder.textViewName.setText(modal.getName());
        holder.textViewURLAvatar.setText(modal.getFlag());
        holder.textViewMail.setText(modal.getIso2());
        Picasso.with(Ctx) .load(modal.getImg()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstCountrys.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName, textViewURLAvatar, textViewMail;
        ImageView imageView;
        public CountryViewHolder(View view) {
            super(view);
            textViewName= itemView.findViewById(R.id.txtNamePais);
            textViewURLAvatar = itemView.findViewById(R.id.txtAvatarPais);
            textViewMail = itemView.findViewById(R.id.txtMailPais);
            imageView = itemView.findViewById(R.id.imgAvatarPais);
        }
    }
}
