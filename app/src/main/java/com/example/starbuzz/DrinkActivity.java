package com.example.starbuzz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        aniadimosMenu();
        recogemosInformacion();
    }
    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void recogemosInformacion() {
        //obtenemos el valor que nos pasan por el intent
        Drink drink = (Drink) getIntent().getSerializableExtra("Drink");

        //Rellenar los elementos del layout con el contenido del objeto
        //1º referenciamos los elementos
        ImageView photo = (ImageView) findViewById(R.id.photo);
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);

        //llenamos los elementos
        photo.setImageResource(drink.getImageResourceId());
        name.setText(drink.getNombre());
        description.setText(drink.getDescripcion());
    }
}