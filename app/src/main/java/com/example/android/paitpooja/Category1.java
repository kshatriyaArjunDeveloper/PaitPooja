package com.example.android.paitpooja;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Category1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Setting the name of category 1
        final TextView textView_category_name = (TextView) findViewById(R.id.textView_category_name);
        textView_category_name.setText("KUCH MEETHA HO JAE !");

        // Create a list of food items
        final ArrayList<FoodItem> arrayOfFoodItems = new ArrayList<FoodItem>();
        arrayOfFoodItems.add(new FoodItem("jalebi ", "Jalebis at Sardar Jalebi\n \n" +
                "The very sweet and crunchy Jalebi made only at Sardar Jalebi in the market of old Gurgaon. They are very crunchy and thin, one can’t back out from eating it. There is essence of saffron and cardamom in Jalebi which attracts the people from distant places too.", R.mipmap.food_6));
        arrayOfFoodItems.add(new FoodItem("Kulfi", "Kulfi’s at Manchanda Kulfi\n \n" +
                "A very sweet product made of milk and flavoring agent ate after the course meal. It is a dessert of summer season loved by every age group peoples. There are some dry fruits like raisins, almonds, and pistachio used in adding taste and healthy agent of the dish. It is served frozen.", R.mipmap.food_3));
        arrayOfFoodItems.add(new FoodItem("Shakes", "Shakes at Sector 22 Market\n \n" +
                "After the heavy and spicy fast food, one must have a glass full of juice. A full glass of juice is enough to fill the empty stomach of a person. There is a variety of juice available at this shop. Fruit shakes like banana, kiwi, strawberry, grapes, chiku, chocolate shake etc.", R.mipmap.food_2));
        arrayOfFoodItems.add(new FoodItem("Kulfi’ ", "Kulfi’s at Kings Kulfi\n \n" +
                "A very sweet product made of milk and flavouring agent ate after the course meal. It is a dessert of summer season loved by every age group peoples. There are some dry fruits like raisins, almonds, and pistachio used in adding taste and healthy agent of the dish. It is served frozen.", R.mipmap.food_5));
        arrayOfFoodItems.add(new FoodItem("Litti – Chokha", "Litti – Chokha\n \n" +
                "A traditional dish of bihar and Jharkhand served near the M.G Road metro statation near the Central Mall. The dish is very delicious and it is available at reasonable price. It is similar to Baati of Rajasthan.", R.mipmap.food_4));
        arrayOfFoodItems.add(new FoodItem("Dodha", "After all the best things make sure you don't miss having this all time famous sweet of Haryana. Many sweet shops make dodha but make sure you have the OM SWEETS Dodha. It's such a delicious sweet that even Delhi peeps look for every time they visit Gurugram.", R.mipmap.food_1));


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

