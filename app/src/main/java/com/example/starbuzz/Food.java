package com.example.starbuzz;

import java.io.Serializable;
import java.util.ArrayList;

public class Food implements Serializable {
    private String nombre;
    private String descripcion;
    private int imageResourceId;
    public ArrayList<Food> listFood;

    public void rellenarArrayFood() {
        listFood = new ArrayList<>();
        listFood.add(new Food("Pizza","PIZZA CON CHORIZO, JAMÓN Y QUESO",R.drawable.pizza));
        listFood.add(new Food("Burger","Hamburguesa Colombiana\n Comerme una hamburguesa siempre fue un gran placer cuando era niña porque mis papás nunca querían gastar plata en comida chatarra. ",R.drawable.hamburguesa));
        listFood.add(new Food("Pasta","La pasta pomodoro, de origen italiano, es una clásico en la cocina. Si no la has probado déjanos decirte que te estás perdiendo de una deliciosa comida pues las especias que se utilizan hacen de esta receta algo único.",R.drawable.pasta));
    };
    public Food() {
        rellenarArrayFood();
    }
    public Food(String nombre, String descripcion, int imageResourceId) {
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

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
