package com.example.android.paitpooja;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Category3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Setting the name of category 3
        final TextView textView_category_name = (TextView) findViewById(R.id.textView_category_name);
        textView_category_name.setText("JEB DHEELI !");

        // Create a list of food items
        final ArrayList<FoodItem> arrayOfFoodItems = new ArrayList<FoodItem>();
        arrayOfFoodItems.add(new FoodItem("Momos ", "BIG WONG –\n \n" +
                "This place is known for Dimsums Chicken Sui mai and Curry prawn you must order!  The curry prawn Dimsums topped with yellow curry sauce is another unique preparation you must order The yellow curry sauce is a speciality! Yes, you heard it right. Momos with cheese! Hurry up and get there.", R.mipmap.food___2));
        arrayOfFoodItems.add(new FoodItem("Gol Gappa", "The Gol Gappa Point – Sector 15 (Gurgaon)\n \n" +
                "The presentation is exactly what you see on the streets of Kolkatta, unique for Gurgaon & NCR.  The puchka is only available in Aataa (wheat) flour and the water is completely made from Imlee (Tamarind), pure authentic touch. Priced at Rs 20/- for 5 pieces.", R.mipmap.food___3));
        arrayOfFoodItems.add(new FoodItem("Chaat", "15-Sector Wala\n \n" +
                "The famous Chat Corner serves the best and tangy flavored water balls and tiki are served at the movable stall. A crispy and spicy tiki is made served to the visitors. It comes under the category of local eateries. The water served with water balls consists of coriander leaves, mint leaves, Jaljeera powder, salt to taste, black pepper.", R.mipmap.food___5));
        arrayOfFoodItems.add(new FoodItem("samosas ", "A small shop that serves the most amazing samosas – Sunny Sweets is located in Qutab Plaza and has many a Gurgaonwalla’s vote for samosas that satiates your Old Delhi street food craving.", R.mipmap.food___6));
        arrayOfFoodItems.add(new FoodItem("Choco Strawberry Waferstick", "You can’t really go wrong with chocolate and strawberry. But we think we’ve perfected the combo! Our Chocostrawberry Stick is what happens when the yummiest chocolate meets the best strawberry flavour. All this, wrapped in our signature Gone Mad crunchy wafer.", R.mipmap.food___1));
        arrayOfFoodItems.add(new FoodItem("Mattra Kulcha", "The heavenly combo of spicy, tangy white peas served with Kulcha that makes the duo completely irresistible!\n", R.mipmap.food___4));

        // Create the adapter to convert the array to views
        FoodItemAdapter foodItemAdapter = new FoodItemAdapter(this, arrayOfFoodItems);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(foodItemAdapter);

        // ListView setOnItemClickListener function apply here.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // After clicking on the view it's detail activity will open
                FoodItem foodItem = new FoodItem(arrayOfFoodItems.get(position).getFoodItemName(),arrayOfFoodItems.get(position).getFoodItemInfo(),arrayOfFoodItems.get(position).getFoodImageResourceId());


                // Create new fragment and transaction
                Food_Item_Details_Fragment newFragment = Food_Item_Details_Fragment.newInstance(foodItem);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.activity_container, newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
    }
}
