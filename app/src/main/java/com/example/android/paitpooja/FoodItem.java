package com.example.android.paitpooja;

import java.io.Serializable;

/**
 * {@link FoodItem} represents a food item that the user can eat according to his need.
 * It contains a food item name, some info about it and an image for that word.
 */
public class FoodItem implements Serializable {


    /** Food item name */
    private String foodItemName;

    /** Food item info */
    private String foodItemInfo;

    /** Image resource ID for the food item */
    private int fImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this food item */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * @param foodItemName is the name of food item
     * @param foodItemInfo is all info about the food item
     * @param fImageResourceId is the image resource id of food item
     */
    public FoodItem(String foodItemName,String foodItemInfo,int fImageResourceId){
        this.foodItemName = foodItemName;
        this.foodItemInfo = foodItemInfo;
        this.fImageResourceId = fImageResourceId;
    }

    /**
     * @return food item name
     */
    public String getFoodItemName() {
        return foodItemName;
    }

    /**
     * @return food item info
     */
    public String getFoodItemInfo() {
            return foodItemInfo;
    }

    /**
     * @return food item image resource id
     */
    public int getFoodImageResourceId() {
        return fImageResourceId;
    }




}
