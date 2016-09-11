package com.example.android.mytourguideapp;

/**
 * Created by Lawrence on 2016/9/8.
 */
public class Food {

    private String foodName;

    private String foodLocation;

    private String openTime;

    private int foodImage = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Food(String foodName, String foodLocation, String openTime, int foodImage) {
        this.foodName = foodName;
        this.foodLocation = foodLocation;
        this.openTime = openTime;
        this.foodImage = foodImage;
    }


    public String getFoodName() {
        return foodName;
    }

    public String getFoodLocation() {
        return foodLocation;
    }

    public String getOpenTime() {
        return openTime;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public boolean hasImage() {
        return foodImage != NO_IMAGE_PROVIDED;
    }
}
