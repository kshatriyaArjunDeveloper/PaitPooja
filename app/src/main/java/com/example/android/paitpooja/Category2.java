package com.example.android.paitpooja;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Category2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Setting the name of category 2
        final TextView textView_category_name = (TextView) findViewById(R.id.textView_category_name);
        textView_category_name.setText("KUCH TEEKHA KHANA HAI !");


        // Create a list of food items
        final ArrayList<FoodItem> arrayOfFoodItems = new ArrayList<FoodItem>();
        arrayOfFoodItems.add(new FoodItem("Chole Bhature","Chole Bhature at Balji Restaurant\n \n" +
                "Football sized bhature makes the dish heavy and results in half emptied stomach by just having a look  at it. Rest of the  stomach is filled by eating chole-bhature. Chole are made spicy and sour which makes the people lick their fingers and to provide an unending taste to the customers. The place is found in the main market of old Gurgaon.",R.mipmap.food__1));
        arrayOfFoodItems.add(new FoodItem("Pakoda’s","Pakoda’s at Gandhji Pakode\n \n" +
                "A heavy snack served with tea or green chili sauce. A wide variety of pakodas are made and served daily to its customers.  Pakodas like gobi pakoda, paneer pakoda, palak pakoda, pyaaz pakoda, aaloo pakoda etc.  spiced with garam masala or chaat masala. The price of pakodas are reasonable. It is located in the market of old Gurgaon.\n" +
                "\n",R.mipmap.food__2));
        arrayOfFoodItems.add(new FoodItem("Dosa ","Dosa at Annapurna Vihar\n \n" +
                "A fine roll of rawa with the stuffing of potato and onion to make it authentic. It is served with the thick gravy of mixed vegetables like pumpkin, beans, brinjal, tamarind, curry leaves, mustard seeds and some flavouring spices. It is located in the market of old Gurgaon.",R.mipmap.food__3));
        arrayOfFoodItems.add(new FoodItem("Kathi Rolls","Kathi Rolls At Nazim’s\n \n" +
                "Kathi roll’s base is made of refined flour. It is filled with stuffing of two kebabs, onions, spinach, tomatoes, coriander leaves, chili sauce, garlic paste. The taste is very authentic. Once you have a bite of it, you will never want that moment to end soon. The outer base is cooked in vegetable oil and the stuffing is rolled inside the base.",R.mipmap.food__4));
        arrayOfFoodItems.add(new FoodItem("Bhelpuri ","Bhelpuri at Sector 57\n \n" +
                "The sweet and salty taste of this dish attracts the person to have a bite of it. It is made of puff rice, Namkeen, Coriander leaves, tamarind sauce, chopped tomatoes, chopped cucumber, chopped onions and some spices to make it spicy.",R.mipmap.food__5));
        arrayOfFoodItems.add(new FoodItem("Tandoor chaap" ,"Tandoor chaap’s at Sector 14\n \n" +
                "A very healthy food item made of soyabean. It is baked in tandoor to add smoky flavor and baking it. There are variety of Chaap made at this junction and served to the people. Variety of chaap like masala chaap, malaai chaap, pudina chaap, masala cream chaap etc.",R.mipmap.food__6));

        // Create the adapter to convert the array to views
        FoodItemAdapter foodItemAdapter = new FoodItemAdapter(this, arrayOfFoodItems);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(foodItemAdapter);

        // ListView setOnItemClickListener function apply here.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
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
