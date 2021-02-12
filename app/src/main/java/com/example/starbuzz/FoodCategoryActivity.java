package com.example.starbuzz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends AppCompatActivity {
    private Food food;
    private ListView list_foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);

        food = new Food();
        aniadimosMenu();
        rellenarListView();
        listViewEvent();
    }

    private void rellenarListView() {
        list_foods = (ListView) findViewById(R.id.list_foods);

        //creamos el adaptador para acceder a los datos de la clase JAVA Food
        ArrayAdapter<Food> listAdapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1,food.getListFood());

        //asignamos el adaptador al elemento grafico que lo va a usar
        list_foods.setAdapter(listAdapter);
    }

    private void listViewEvent() {
        //creaccion del listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDrink, View itemView, int position, long id) {
                Intent intent = new Intent(FoodCategoryActivity.this, FoodActivity.class);
                for (int i = 0; food.getListFood().size() > i; i++) {
                    if (position == i) {// Drink
                        intent.putExtra("Food", food.getListFood().get(position));
                        startActivity(intent);
                        //finish();
                    }
                }
            }
        };
        //asignar listener al elemento grafico
        list_foods.setOnItemClickListener(itemClickListener);
    }

    private void aniadimosMenu() {
        //añadimos el action bar a la activity
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
            case R.id.action_create_order:
                Intent intent = new Intent(this, NewOrderFoodActivity.class);
                intent.putExtra("listFoods", food.getListFood());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}