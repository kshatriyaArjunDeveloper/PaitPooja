package com.example.android.paitpooja;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodItemAdapter extends ArrayAdapter<FoodItem> {

    public FoodItemAdapter(Context context, ArrayList<FoodItem> foodItems) {
        super(context, 0, foodItems);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        // Get the data item for this position
        FoodItem foodItem = getItem(position);

        // Lookup view for data population
        TextView textView_foodItemName = convertView.findViewById(R.id.textView_foodItemName);
        TextView textView_foodItemInfo = convertView.findViewById(R.id.textView_foodItemInfo);
        ImageView imageView_foodItemImage = convertView.findViewById(R.id.imageView_foodItemImage);

        // Populate the data into the template view using the data object
        textView_foodItemName.setText(foodItem.getFoodItemName());
        textView_foodItemInfo.setText(foodItem.getFoodItemInfo());
        textView_foodItemInfo.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        imageView_foodItemImage.setImageResource(foodItem.getFoodImageResourceId());

        // Return the completed view to render on screen
        return convertView;

    }
}

