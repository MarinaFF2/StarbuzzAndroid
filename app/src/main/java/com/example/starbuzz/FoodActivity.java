package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        aniadimosMenu();
        recogemosInformacion();
    }

    private void recogemosInformacion() {
        //obtenemos el valor que nos pasan por el intent
        Food food = (Food) getIntent().getSerializableExtra("Food");

        //Rellenar los elementos del layout con el contenido del objeto
        //1º referenciamos los elementos
        ImageView photo = (ImageView) findViewById(R.id.photo);
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);
        //llenamos los elementos
        photo.setImageResource(food.getImageResourceId());
        name.setText(food.getNombre());
        description.setText(food.getDescripcion());
    }

    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}