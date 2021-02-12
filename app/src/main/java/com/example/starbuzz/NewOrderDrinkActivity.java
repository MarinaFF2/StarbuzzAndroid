package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewOrderDrinkActivity extends AppCompatActivity {
    private Button buttonSave;
    private Spinner spinnerDrinks;
    private ImageButton imageMas;
    private ImageButton imageMenos;
    private TextView textCantidad;
    private ArrayList<Drink> listDrink;
    private Drink drink;
    private int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order_drink);

        imageMas = (ImageButton) findViewById(R.id.imageMas);
        imageMenos = (ImageButton) findViewById(R.id.imageMenos);
        textCantidad = (TextView) findViewById(R.id.textCantidad);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        aniadimosMenu();
        rellenarSpinner();
        buttonSaveEvent();
        spinerEvent();
        buttonMenosEvent();
        buttonMasEvent();
    }
    private void buttonMenosEvent() {
        imageMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = Integer.parseInt (textCantidad.getText().toString());
                if(cantidad >= 1){
                    cantidad = cantidad-1;
                    textCantidad.setText(cantidad+"");
                }
            }
        });
    }

    private void buttonMasEvent() {
        imageMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = Integer.parseInt (textCantidad.getText().toString());
                cantidad = cantidad+1;
                textCantidad.setText(cantidad+"");
            }
        });
    }

    private void spinerEvent() {
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // An item was selected. You can retrieve the selected item using
                drink = (Drink) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                drink = null;
            }
        };
        //añadimos el adpatador al spinner
        spinnerDrinks.setOnItemSelectedListener(itemSelectedListener);
    }

    private void rellenarSpinner() {
        listDrink = (ArrayList<Drink>) getIntent().getSerializableExtra("listDrinks");
        if (listDrink != null) {
            spinnerDrinks = (Spinner) findViewById(R.id.spinnerDrinks);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<Drink> adapter = new ArrayAdapter(NewOrderDrinkActivity.this, android.R.layout.simple_spinner_item, listDrink);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinnerDrinks.setAdapter(adapter);
        }
    }
    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void buttonSaveEvent() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewOrderDrinkActivity.this, OrderActivity.class);
                intent.putExtra("nombre", drink.getNombre());
                intent.putExtra("cantidad", cantidad);
                startActivity(intent);
                finish();
            }
        });
    }
}