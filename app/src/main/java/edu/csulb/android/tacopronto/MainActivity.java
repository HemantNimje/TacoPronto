package edu.csulb.android.tacopronto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import static android.R.attr.id;
import static edu.csulb.android.tacopronto.R.string.price;
import static edu.csulb.android.tacopronto.R.string.radio_button_corn;
import static edu.csulb.android.tacopronto.R.string.radio_button_flour;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private int fillingCount = 0;
    private int toppingCount = 0;
    private BigDecimal bPrice = new BigDecimal(0);
    private BigDecimal finalPrice = new BigDecimal(0);
    private BigDecimal changedPrice;


    RadioButton radioButtonLarge, radioButtonMedium, radioButtonCorn, radioButtonFlour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

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

    public void init() {
        radioButtonLarge = (RadioButton) findViewById(R.id.radio_button_large);
        radioButtonMedium = (RadioButton) findViewById(R.id.radio_button_medium);

        radioButtonCorn = (RadioButton) findViewById(R.id.radio_button_corn);
        radioButtonFlour = (RadioButton) findViewById(R.id.radio_button_flour);

    }

    /* Choose maximum two fillings */
    public void chooseFillings(View view) {
        CheckBox checkBoxBeef = (CheckBox) findViewById(R.id.checkbox_beef);
        boolean hasBeef = checkBoxBeef.isChecked();

        CheckBox checkBoxChicken = (CheckBox) findViewById(R.id.checkbox_chicken);
        boolean hasChicken = checkBoxChicken.isChecked();

        CheckBox checkBoxWhiteFish = (CheckBox) findViewById(R.id.checkbox_white_fish);
        boolean hasWhiteFish = checkBoxWhiteFish.isChecked();

        CheckBox checkBoxSeaFood = (CheckBox) findViewById(R.id.checkbox_sea_food);
        boolean hasSeaFood = checkBoxSeaFood.isChecked();

        switch (view.getId()) {
            case R.id.checkbox_beef:
                if (hasBeef) {
                    fillingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(2.70));
                } else {
                    fillingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(2.70));
                }
                break;
            case R.id.checkbox_chicken:
                if (hasChicken) {
                    fillingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(2.40));
                } else {
                    fillingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(2.40));
                }
                break;
            case R.id.checkbox_white_fish:
                if (hasWhiteFish) {
                    fillingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(2.45));
                } else {
                    fillingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(2.45));
                }
                break;
            case R.id.checkbox_sea_food:
                if (hasSeaFood) {
                    fillingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(2.60));
                } else {
                    fillingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(2.60));
                }
                break;
        }

        if (fillingCount < 2) {
            checkBoxBeef.setEnabled(true);
            checkBoxChicken.setEnabled(true);
            checkBoxWhiteFish.setEnabled(true);
            checkBoxSeaFood.setEnabled(true);
        } else {
            if (!hasBeef) {
                checkBoxBeef.setEnabled(false);
            } else {
                checkBoxBeef.setEnabled(true);
            }
            if (!hasChicken) {
                checkBoxChicken.setEnabled(false);
            } else {
                checkBoxChicken.setEnabled(true);
            }
            if (!hasWhiteFish) {
                checkBoxWhiteFish.setEnabled(false);
            } else {
                checkBoxWhiteFish.setEnabled(true);
            }
            if (!hasSeaFood) {
                checkBoxSeaFood.setEnabled(false);
            } else {
                checkBoxSeaFood.setEnabled(true);
            }
        }

        if (fillingCount == 2) {
            Toast.makeText(this, "You can select only two fillings", Toast.LENGTH_SHORT).show();
        }
        calculatePrice();
    }

    /* Choose maximum four toppings */
    public void chooseToppings(View view) {
        CheckBox checkBoxCheese = (CheckBox) findViewById(R.id.checkbox_cheese);
        boolean hasCheese = checkBoxCheese.isChecked();

        CheckBox checkBoxRice = (CheckBox) findViewById(R.id.checkbox_rice);
        boolean hasRice = checkBoxRice.isChecked();

        CheckBox checkBoxBeans = (CheckBox) findViewById(R.id.checkbox_beans);
        boolean hasBeans = checkBoxBeans.isChecked();

        CheckBox checkBoxPicoDeGallo = (CheckBox) findViewById(R.id.checkbox_pico_de_gallo);
        boolean hasPicoDeGallo = checkBoxPicoDeGallo.isChecked();

        CheckBox checkBoxGuacamole = (CheckBox) findViewById(R.id.checkbox_guacamole);
        boolean hasGaucamole = checkBoxGuacamole.isChecked();

        CheckBox checkBoxLBT = (CheckBox) findViewById(R.id.checkbox_lbt);
        boolean hasLBT = checkBoxLBT.isChecked();

        switch (view.getId()) {
            case R.id.checkbox_cheese:
                if (hasCheese) {
                    toppingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(0.50));

                } else {
                    toppingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(0.50));
                }
                break;
            case R.id.checkbox_rice:
                if (hasRice) {
                    toppingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(1.00));
                } else {
                    toppingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(1.00));
                }
                break;
            case R.id.checkbox_beans:
                if (hasBeans) {
                    toppingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(0.65));
                } else {
                    toppingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(0.65));
                }
                break;
            case R.id.checkbox_pico_de_gallo:
                if (hasPicoDeGallo) {
                    toppingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(0.50));
                } else {
                    toppingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(0.50));
                }
                break;
            case R.id.checkbox_guacamole:
                if (hasGaucamole) {
                    toppingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(1.25));
                } else {
                    toppingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(1.25));
                }
                break;
            case R.id.checkbox_lbt:
                if (hasLBT) {
                    toppingCount += 1;
                    bPrice = bPrice.add(BigDecimal.valueOf(1.50));
                } else {
                    toppingCount -= 1;
                    bPrice = bPrice.subtract(BigDecimal.valueOf(1.50));
                }
                break;
        }

        if (toppingCount < 4) {
            checkBoxCheese.setEnabled(true);
            checkBoxRice.setEnabled(true);
            checkBoxBeans.setEnabled(true);
            checkBoxPicoDeGallo.setEnabled(true);
            checkBoxGuacamole.setEnabled(true);
            checkBoxLBT.setEnabled(true);
        } else {
            if (!hasCheese) {
                checkBoxCheese.setEnabled(false);
            } else {
                checkBoxCheese.setEnabled(true);
            }
            if (!hasRice) {
                checkBoxRice.setEnabled(false);
            } else {
                checkBoxRice.setEnabled(true);
            }
            if (!hasBeans) {
                checkBoxBeans.setEnabled(false);
            } else {
                checkBoxBeans.setEnabled(true);
            }
            if (!hasPicoDeGallo) {
                checkBoxPicoDeGallo.setEnabled(false);
            } else {
                checkBoxPicoDeGallo.setEnabled(true);
            }
            if (!hasGaucamole) {
                checkBoxGuacamole.setEnabled(false);
            } else {
                checkBoxGuacamole.setEnabled(true);
            }
            if (!hasLBT) {
                checkBoxLBT.setEnabled(false);
            } else {
                checkBoxLBT.setEnabled(true);
            }
        }

        if (toppingCount == 4) {
            Toast.makeText(this, "You can select only four toppings", Toast.LENGTH_SHORT).show();
        }
        calculatePrice();
    }

    /* Choose beverages */
    public void chooseBeverages(View view) {

        CheckBox checkBoxSoda = (CheckBox) findViewById(R.id.checkbox_soda);
        boolean hasSoda = checkBoxSoda.isChecked();

        CheckBox checkBoxCerveza = (CheckBox) findViewById(R.id.checkbox_cerveza);
        boolean hasCerveza = checkBoxCerveza.isChecked();

        CheckBox checkBoxMargarita = (CheckBox) findViewById(R.id.checkbox_margarita);
        boolean hasMargarita = checkBoxMargarita.isChecked();

        CheckBox checkBoxTequila = (CheckBox) findViewById(R.id.checkbox_tequila);
        boolean hasTequila = checkBoxTequila.isChecked();

        switch (view.getId()) {
            case R.id.checkbox_soda:
                if (hasSoda) {
                    bPrice = bPrice.add(BigDecimal.valueOf(1.45));
                } else {
                    bPrice = bPrice.subtract(BigDecimal.valueOf(1.45));
                }
                break;
            case R.id.checkbox_cerveza:
                if (hasCerveza) {
                    bPrice = bPrice.add(BigDecimal.valueOf(1.75));
                } else {
                    bPrice = bPrice.subtract(BigDecimal.valueOf(1.75));
                }
                break;
            case R.id.checkbox_margarita:
                if (hasMargarita) {
                    bPrice = bPrice.add(BigDecimal.valueOf(2.00));
                } else {
                    bPrice = bPrice.subtract(BigDecimal.valueOf(2.00));
                }
                break;
            case R.id.checkbox_tequila:
                if (hasTequila) {
                    bPrice = bPrice.add(BigDecimal.valueOf(3.45));
                } else {
                    bPrice = bPrice.subtract(BigDecimal.valueOf(3.45));
                }
                break;
        }
        calculatePrice();
    }

    /* Increase the number of orders to be placed */
    public void increment(View view) {
        if (quantity == 9) {
            Toast.makeText(this, "Can't order more than 9 orders at a time.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity = quantity + 1;

        }
        displayQuantity(quantity);
    }

    /* Decrease the number of orders to be placed */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
        } else {
            Toast.makeText(this, "Minimum 1 order needs to be placed", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }

    /* Display the number of tacos */
    private void displayQuantity(int quantity) {
        TextView orderQuantity = (TextView) findViewById(R.id.text_view_order_quantity);
        orderQuantity.setText("" + quantity);
    }

    /* Display the total cost */
    private void displayCost() {
        TextView textViewTotalCost = (TextView) findViewById(R.id.text_view_total_cost);

        textViewTotalCost.setText("$" + finalPrice);
        //Toast.makeText(this,"Total Cost:"+bPrice,Toast.LENGTH_SHORT).show();
    }

    /* Choose taco size */
    public void chooseSize(View view) {
        calculatePrice();
    }

    private void calculatePrice() {
        if (radioButtonLarge.isChecked()) {
            Toast.makeText(this, "For large taco every cost is increased by 2%", Toast.LENGTH_SHORT).show();
            changedPrice = new BigDecimal(quantity);
            changedPrice = changedPrice.multiply(BigDecimal.valueOf(1.2));
            finalPrice = bPrice.multiply(changedPrice);
        }
        if (radioButtonMedium.isChecked()) {
            finalPrice = bPrice.multiply(new BigDecimal(quantity));
        }
        displayCost();
    }

}
