package edu.csulb.android.tacopronto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hemant on 2/15/2017.
 */
public class CustomAdapter extends ArrayAdapter<Food> {

    private List<Food> foodItem;

    public CustomAdapter(Context context, int resource, List<Food> items) {
        super(context, resource, items);
        this.foodItem = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Food food = foodItem.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.custom_row, null);

        // Set the text for row_checkbox
        CheckBox checkBox = (CheckBox) row.findViewById(R.id.row_checkbox);
        checkBox.setText(food.getFoodName());

        // Set the text for row_price
        TextView textView = (TextView) row.findViewById(R.id.row_price);
        textView.setText(food.getPrice());

        return row;
    }
}
