package com.example.myapplication.Model;

public class CountryCodes {

    private String tld;
    private String iso2;
    private String iso3;
    private  String fips;
    private Integer isonN;

    public String getTld() {
        return tld;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public String getFips() {
        return fips;
    }

    public Integer getIsonN() {
        return isonN;
    }

    public CountryCodes(String tld, String iso2, String iso3, String fips, Integer isonN) {
        this.tld = tld;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.fips = fips;
        this.isonN = isonN;
    }

    @Override
    public String toString() {
        return "CountryCodes{" +
                "tld='" + tld + '\'' +
                ", iso2='" + iso2 + '\'' +
                ", iso3='" + iso3 + '\'' +
                ", fips='" + fips + '\'' +
                ", isonN=" + isonN +
                '}';
    }
}
