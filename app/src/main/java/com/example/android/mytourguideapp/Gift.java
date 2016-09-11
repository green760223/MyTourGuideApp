package com.example.android.mytourguideapp;

/**
 * Created by Lawrence on 2016/9/9.
 */
public class Gift {

    private String giftName;

    private String giftLocation;

    private String giftNumber;

    private int giftImage = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Gift(String giftName, String giftLocation, String giftNumber, int giftImage) {
        this.giftName = giftName;
        this.giftLocation = giftLocation;
        this.giftNumber = giftNumber;
        this.giftImage = giftImage;
    }


    public String getGiftName() {
        return giftName;
    }

    public String getGiftLocation() {
        return giftLocation;
    }

    public int getGiftImage() {
        return giftImage;
    }

    public boolean hasImage() {
        return giftImage != NO_IMAGE_PROVIDED;
    }

    public String getGiftNumber() {
        return giftNumber;
    }

}
