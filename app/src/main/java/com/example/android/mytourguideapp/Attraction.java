package com.example.android.mytourguideapp;

/**
 * Created by Lawrence on 2016/9/7.
 */
public class Attraction {

    private String attractionName;

    private String attractionDescription;

    private int attractionImage = NO_IMAGE_PROVIED;

    private int attractionLocation = NO_IMAGE_PROVIED;

    private static final int NO_IMAGE_PROVIED = -1;

    private String attractionType;


    public Attraction(String attractionName, String attractionDescription, int attractionImage, String attractionType, int attractionLocation) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.attractionImage = attractionImage;
        this.attractionType = attractionType;
        this.attractionLocation = attractionLocation;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "attractionName='" + attractionName + '\'' +
                ", attractionDescription='" + attractionDescription + '\'' +
                ", attractionImage=" + attractionImage +
                ", attractionLocation=" + attractionLocation +
                ", attractionType='" + attractionType + '\'' +
                '}';
    }

    public String getAttractionName() {
        return attractionName;
    }

    public String getAttractionDescription() {
        return attractionDescription;
    }

    public int getAttractionImage() {
        return attractionImage;
    }

    public String getAttractionType() {
        return attractionType;
    }

    public int getAttractionLocation() {
        return attractionLocation;
    }

    public boolean hasAttractionImage() {
        return attractionImage != NO_IMAGE_PROVIED;
    }

}
