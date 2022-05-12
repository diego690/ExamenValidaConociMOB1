package com.example.myapplication.Model;

public class GeoRectangle {

    private float west;
    private float east;
    private float nort;
    private float south;

    public GeoRectangle(float west, float east, float nort, float south) {
        this.west = west;
        this.east = east;
        this.nort = nort;
        this.south = south;
    }

    public float getWest() {
        return west;
    }

    public void setWest(float west) {
        this.west = west;
    }

    public float getEast() {
        return east;
    }

    public void setEast(float east) {
        this.east = east;
    }

    public float getNort() {
        return nort;
    }

    public void setNort(float nort) {
        this.nort = nort;
    }

    public float getSouth() {
        return south;
    }

    public void setSouth(float south) {
        this.south = south;
    }

    @Override
    public String toString() {
        return "GeoRectangle{" +
                "west=" + west +
                ", east=" + east +
                ", nort=" + nort +
                ", south=" + south +
                '}';
    }
}
