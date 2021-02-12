package com.example.starbuzz;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {
    private String nombre;
    private String ciudad;
    private int imageResourceId;
    private ArrayList<Store> listStore;

    public Store() {
        rellenarArrarListStores();
    }

    private void rellenarArrarListStores() {
         listStore = new ArrayList<>();
         listStore.add(new Store("Amazónico","Madrid",R.drawable.madrid));
         listStore.add(new Store("La selva","Barcelona",R.drawable.barcelona));
         listStore.add(new Store("Carmen Carmen","Ciudad Real",R.drawable.ciudadreal));
    }

    public Store(String nombre, String ciudad, int imageResourceId) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.imageResourceId = imageResourceId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public ArrayList<Store> getListStore() {
        return listStore;
    }

    public void setListStore(ArrayList<Store> listStore) {
        this.listStore = listStore;
    }

    @Override
    public String toString() {
        return this.ciudad;
    }
}
