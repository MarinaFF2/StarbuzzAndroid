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

public class StoreCategoryActivity extends AppCompatActivity {
    private Store store;
    private ListView list_stores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_category);
        store = new Store();
        aniadimosMenu();
        rellenarListView();
        listViewEvent();
    }

    private void listViewEvent() {
        //creaccion del listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDrink, View itemView, int position, long id) {
                Intent intent = new Intent(StoreCategoryActivity.this, StoreActivity.class);
                for (int i = 0; store.getListStore().size() > i; i++) {
                    if (position == i) {// Store
                        intent.putExtra("Store",store.getListStore().get(position));
                        startActivity(intent);
                        //finish();
                    }
                }
            }
        };
        //asignar listener al elemento grafico
        list_stores.setOnItemClickListener(itemClickListener);
    }

    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //crea las opciones del menu
    public boolean onCreateOptionsMenu(Menu menu){
        //añadimos el menu
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void rellenarListView() {
        list_stores = (ListView) findViewById(R.id.list_stores);
        //creamos el adaptador para acceder a los datos de la clase JAVA Store
        ArrayAdapter<Store> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,store.getListStore());
        //asignamos el adaptador al elemento grafico que lo va a usar
        list_stores.setAdapter(listAdapter);
    }
}