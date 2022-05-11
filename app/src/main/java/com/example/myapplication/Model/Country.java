package com.example.myapplication.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Country {

    private String name;
    private int flag;
    private String iso3;
    private String iso2;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Country(JSONObject a) throws JSONException {
        name =  a.getString("name").toString();

        flag =  a.getInt("flag");




    }

    public static ArrayList<Country> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Country> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Country(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}
