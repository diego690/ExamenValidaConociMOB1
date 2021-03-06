package com.example.myapplication.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Country {
    private String nombrePais;
    private String url_Pais;
    private double[] coordenadasPais;
    private  String iso2;



    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getUrl_Pais() {
        return url_Pais;
    }

    public void setUrl_Pais(String url_Pais) {
        this.url_Pais = url_Pais;
    }

    public Country(String npais, String nurl, double[] ncoordenadasPais,String is2) throws JSONException {
        nombrePais = npais;
        url_Pais = nurl;
        coordenadasPais = ncoordenadasPais;
        iso2 = is2;
    }

    public static Country get_Pais(JSONObject datos, float[] pais) throws JSONException {
        return Country.JsonObjectsBuild(datos).get((int) pais[1]);
    }


    public static ArrayList<Country> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<Country> paises = new ArrayList<>();

        JSONObject results = datos.getJSONObject("Results");
        JSONArray namesBD = results.names();

        for (int i = 0; i < namesBD.length(); i++) {

            String namebd = namesBD.getString(i);
            JSONObject datosBD = results.getJSONObject(namebd);
            String nombrePais = datosBD.getString("Name");
            JSONObject countryCodes = datosBD.getJSONObject("CountryCodes");
            String iso2 = countryCodes.getString("iso2");

            JSONObject georectangle = datosBD.getJSONObject("GeoRectangle");
            JSONArray geopt = datosBD.getJSONArray("GeoPt");

            double[] datosRectangulo = new double[6];
            datosRectangulo[0] = georectangle.getDouble("West");
            datosRectangulo[1] = georectangle.getDouble("East");
            datosRectangulo[2] = georectangle.getDouble("North");
            datosRectangulo[3] = georectangle.getDouble("South");

            datosRectangulo[4] = geopt.getDouble(0);
            datosRectangulo[5] = geopt.getDouble(1);

            paises.add(new Country(nombrePais, "http://www.geognos.com/api/en/countries/flag/" + iso2 + ".png", datosRectangulo,iso2));
        }

        return paises;
    }


    public double[] getCoordenadasPais() {
        return coordenadasPais;
    }

    public void setCoordenadasPais(double[] coordenadasPais) {
        this.coordenadasPais = coordenadasPais;
    }


}
