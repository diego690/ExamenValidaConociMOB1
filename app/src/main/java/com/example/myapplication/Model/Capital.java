package com.example.myapplication.Model;

public class Capital {
    private int flg;
    private float td;
    private String Name;

    public Capital() {
    }

    public Capital(int flg, float td, String name) {
        this.flg = flg;
        this.td = td;
        Name = name;
    }

    public int getFlg() {
        return flg;
    }

    public void setFlg(int flg) {
        this.flg = flg;
    }

    public float getTd() {
        return td;
    }

    public void setTd(float td) {
        this.td = td;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "flg=" + flg +
                ", td=" + td +
                ", Name='" + Name + '\'' +
                '}';
    }
}
