package com.example.android.paitpooja;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Food_Item_Details_Fragment extends Fragment {


    public Food_Item_Details_Fragment() {
        // Required empty public constructor
    }


    private static final String DESCRIBABLE_KEY = "describable_key";
    private FoodItem foodItem;

    // To take a food item as an argument and make a fragment from it
    public static Food_Item_Details_Fragment newInstance(FoodItem foodItem) {
        Food_Item_Details_Fragment fragment = new Food_Item_Details_Fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DESCRIBABLE_KEY, foodItem);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Food item by which we will make an argument
        foodItem = (FoodItem) getArguments().getSerializable(DESCRIBABLE_KEY);
        View rootView = inflater.inflate(R.layout.fragment_description, container, false);

        // Setting the views according to the food item
        TextView textView_name = rootView.findViewById(R.id.textView_FoodItemName_Details);
        textView_name.setText(foodItem.getFoodItemName());
        TextView textView_info = rootView.findViewById(R.id.textView_FoodItemInfo_Details);
        textView_info.setText(foodItem.getFoodItemInfo());
        ImageView imageView = rootView.findViewById(R.id.imageView_FoodItemImage_Details);
        imageView.setImageResource(foodItem.getFoodImageResourceId());


        // Inflate the layout for this fragment
        return rootView;

    }

}
