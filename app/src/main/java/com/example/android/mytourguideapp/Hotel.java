package com.example.android.mytourguideapp;

/**
 * Created by Lawrence on 2016/9/8.
 */
public class Hotel {

    private String hotelName;

    private String hotelLocation;

    private String hotelNumber;

    private int hotelImage = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Hotel(String hotelName, String hotelLocation, String hotelNumber, int hotelImage) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.hotelNumber = hotelNumber;
        this.hotelImage = hotelImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public String getHotelNumber() {
        return hotelNumber;
    }

    public boolean hasImage() {
        return hotelImage != NO_IMAGE_PROVIDED;
    }

    public int getHotelImage() {
        return hotelImage;
    }

}
