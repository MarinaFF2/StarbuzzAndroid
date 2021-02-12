package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private TextView textCantidad;
    private TextView textTipo;
    private Button buttonValidar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        aniadimosMenu();
        rellenamosLaOrden();
        validarEvent();
    }

    private void validarEvent() {
        buttonValidar = (Button) findViewById(R.id.buttonValidar);
        buttonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, TopLevelActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(),"Su pedido se esta preprando", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void rellenamosLaOrden() {
        textCantidad = (TextView) findViewById(R.id.textCantidad);
        textTipo = (TextView) findViewById(R.id.textTipo);

        String nombre =  getIntent().getExtras().getString("nombre");
        int cantidad =  getIntent().getExtras().getInt("cantidad");
        textTipo.setText(nombre);
        textCantidad.setText(cantidad+"");
    }

    private void aniadimosMenu() {
        //añadimos el action bar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}