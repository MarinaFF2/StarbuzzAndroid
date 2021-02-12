package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        aniadimosMenu();
        recogemosInformacion();
    }

    private void recogemosInformacion() {
        //obtenemos el valor que nos pasan por el intent
        Store store = (Store) getIntent().getSerializableExtra("Store");

        //Rellenar los elementos del layout con el contenido del objeto
        //1º referenciamos los elementos
        ImageView photo = (ImageView) findViewById(R.id.photo);
        TextView name = (TextView) findViewById(R.id.name);
        TextView ciudad = (TextView) findViewById(R.id.ciudad);
        //llenamos los elementos
        photo.setImageResource(store.getImageResourceId());
        name.setText(store.getNombre());
        ciudad.setText(store.getCiudad());
    }

    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}