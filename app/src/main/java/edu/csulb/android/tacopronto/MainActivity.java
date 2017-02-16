package edu.csulb.android.tacopronto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Find the custom_list_view_fillings and add content to it*/
        /*ListView listViewFillings = (ListView) findViewById(R.id.custom_list_view_fillings);

        List<Food> foodFillings = new ArrayList<>();
        foodFillings.add(new Food("Beef", "2.70"));
        foodFillings.add(new Food("Chicken", "2.40"));
        foodFillings.add(new Food("White Fish", "2.40"));
        foodFillings.add(new Food("Sea Food", "2.40"));
        listViewFillings.setAdapter(new CustomAdapter(this, R.layout.custom_row, foodFillings));

         *//* Find the custom_list_view_toppings and add content to it*//*
        ListView listViewToppings = (ListView) findViewById(R.id.custom_list_view_toppings);

        List<Food> foodToppings = new ArrayList<>();
        foodToppings.add(new Food("Beef", "2.70"));
        foodToppings.add(new Food("Chicken", "2.40"));
        foodToppings.add(new Food("White Fish", "2.40"));
        foodToppings.add(new Food("Sea Food", "2.40"));
        listViewToppings.setAdapter(new CustomAdapter(this, R.layout.custom_row, foodToppings));



        *//* Find the custom_list_view_beverages and add content to it*//*
        ListView listViewBeverage = (ListView) findViewById(R.id.custom_list_view_beverages);

        List<Food> foodBeverage = new ArrayList<>();
        foodBeverage.add(new Food("Soda", "1.85"));
        foodBeverage.add(new Food("Cerveza", "2.10"));
        foodBeverage.add(new Food("Margarita", "2.40"));
        foodBeverage.add(new Food("Tequila", "2.75"));
        listViewBeverage.setAdapter(new CustomAdapter(this, R.layout.custom_row, foodBeverage));*/
    }
}
