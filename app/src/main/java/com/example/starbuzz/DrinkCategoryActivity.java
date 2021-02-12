package com.example.starbuzz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {
    private Drink drink;
    private ListView list_drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        drink = new Drink();
        aniadimosMenu();
        rellenarListView();
        listViewEvent();
    }

    private void listViewEvent() {
        //creaccion del listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDrink, View itemView, int position, long id) {
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                for (int i = 0; drink.getListDrink().size() > i; i++) {
                    if (position == i) {// Drink
                        intent.putExtra("Drink", drink.getListDrink().get(position));
                        startActivity(intent);
                        //finish();
                    }
                }
            }
        };
        //asignar listener al elemento grafico
        list_drinks.setOnItemClickListener(itemClickListener);
    }

    private void rellenarListView() {
        list_drinks = (ListView) findViewById(R.id.list_drinks);

        //creamos el adaptador para acceder a los datos de la clase JAVA drink
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,drink.getListDrink());

        //asignamos el adaptador al elemento grafico que lo va a usar
        list_drinks.setAdapter(listAdapter);
    }

    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //añadimos la accion a los items del menu
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //crea las opciones del menu
    public boolean onCreateOptionsMenu(Menu menu){
        //añadimos el menu
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order: //si pulsamos en el +
                Intent intent = new Intent(DrinkCategoryActivity.this, NewOrderDrinkActivity.class);
                intent.putExtra("listDrinks", drink.getListDrink());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}