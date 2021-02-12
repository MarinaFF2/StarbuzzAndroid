package com.example.starbuzz;

import java.io.Serializable;
import java.util.ArrayList;

public class Drink implements Serializable {
    private String nombre;
    private String descripcion;
    private int imageResourceId;
    private ArrayList<Drink> listDrink;

    public void rellenarArrarListDrinks(){
        listDrink = new ArrayList<>();
        listDrink.add(new Drink("Latte","A couple of espresso shots with steamed milk",R.drawable.latte));
        listDrink.add(new Drink("Cappucino","Espresso, hot milk, and a steamed milk foam",R.drawable.cappuccino));
        listDrink.add(new Drink("Filter","Highest quality beans roasted and brewed fresh",R.drawable.filter));
    };

    public Drink() {
        rellenarArrarListDrinks();
    }
    public Drink(String nombre, String descripcion, int imageResourceId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imageResourceId = imageResourceId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public ArrayList<Drink> getListDrink() {
        return listDrink;
    }

    public void setListDrink(ArrayList<Drink> listDrink) {
        this.listDrink = listDrink;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
