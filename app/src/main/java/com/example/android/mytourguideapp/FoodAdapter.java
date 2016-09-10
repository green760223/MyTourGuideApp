package com.example.android.mytourguideapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lawrence on 2016/9/8.
 */
public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Context context, ArrayList<Food> foodAdapter) {
        super(context, 0, foodAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView =
                    LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        Food currentFood = getItem(position);

        ImageView foodImage = (ImageView) listItemView.findViewById(R.id.food_image);
        TextView foodName = (TextView) listItemView.findViewById(R.id.food_name);
        TextView foodLocation = (TextView) listItemView.findViewById(R.id.food_location);
        TextView foodOpenTime = (TextView) listItemView.findViewById(R.id.food_opentime);

        if(currentFood.hasImage()) {
            foodImage.setImageBitmap(decodeResource(getContext().getResources(), currentFood.getFoodImage()));
            foodImage.setVisibility(View.VISIBLE);
        } else {
            foodImage.setVisibility(View.GONE);
        }

        foodName.setText(currentFood.getFoodName());
        foodLocation.setText(currentFood.getFoodLocation());
        foodOpenTime.setText(currentFood.getOpenTime());

        return listItemView;
    }


    /**
     * To prevent OutOfMemoryError issue
     * @param res
     * @param id
     * @return
     */
    private static Bitmap decodeResource(Resources res, int id) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        for (options.inSampleSize = 1; options.inSampleSize <= 32; options.inSampleSize++) {
            try {
                bitmap = BitmapFactory.decodeResource(res, id, options);
                break;
            } catch (OutOfMemoryError outOfMemoryError) {

            }
        }
        return bitmap;
    }
}
