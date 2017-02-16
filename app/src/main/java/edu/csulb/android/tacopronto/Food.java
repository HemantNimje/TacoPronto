package edu.csulb.android.tacopronto;

/**
 * Created by Hemant on 2/15/2017.
 */

public class Food {

    private String foodName;
    private String price;

    public Food(String foodName, String price) {
        this.foodName = foodName;
        this.price = price;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }


    public String getFoodName() {
        return foodName;
    }


}
